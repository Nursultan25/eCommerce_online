package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Discount;
import com.example.ecommerce_online.repository.DiscountRepo;
import com.example.ecommerce_online.service.DiscountService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;

    @Autowired
    public DiscountServiceImpl(DiscountRepo discountRepo) {
        this.discountRepo = discountRepo;
    }

    @Override
    public Discount create(Discount discount) {
        return discountRepo.save(discount);
    }

    @Override
    @Cacheable(cacheNames = "discount", key = "#id")
    public List<Discount> getAll() {
        return discountRepo.findAll();
    }

    @Override
    @Cacheable(cacheNames = "discount", key = "#id")
    public Discount get(Long id) {
        return discountRepo.getById(id);
    }

    @Override
    @CachePut(cacheNames = "discount", key = "#id")
    public Discount update(Discount discount) {
        return discountRepo.findById(discount.getId())
                .map(discount1 -> {
                    discount1.setDiscount(discount.getDiscount());
                    discount1.setStartDate(discount.getStartDate());
                    discount1.setEndDate(discount.getEndDate());
                    discountRepo.save(discount1);
                    return discount1;
                }).orElseThrow(() -> new NotFoundException("Could not update with id: " + discount.getId()));
    }

    @Override
    @CacheEvict(cacheNames = "discount", key = "#id")
    public Discount delete(Long id) {
        discountRepo.deleteById(id);
        return discountRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Could not delete with id: " + id));

    }
}
