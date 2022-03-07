package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Price;
import com.example.ecommerce_online.repository.PriceRepo;
import com.example.ecommerce_online.service.PriceService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepo priceRepo;

    @Autowired
    public PriceServiceImpl(PriceRepo priceRepo) {
        this.priceRepo = priceRepo;
    }

    @Override
    public Price create(Price price) {
        return priceRepo.save(price);
    }

    @Override
    @Cacheable(cacheNames = "price", key = "#id")
    public List<Price> getAll() {
        return priceRepo.findAll();
    }

    @Override
    @Cacheable(cacheNames = "price", key = "#id")
    public Price get(Long id) {
        return priceRepo.getById(id);
    }

    @Override
    @CachePut(cacheNames = "price", key = "#id")
    public Price update(Price price) {
        return priceRepo.findById(price.getId())
                .map(price1 -> {
                    price1.setPrice(price.getPrice());
                    priceRepo.save(price1);
                    return price1;
                }).orElseThrow(() -> new NotFoundException("Could not update with id: " + price.getId()));
    }

    @Override
    @CachePut(cacheNames = "price", key = "#id")
    public Price delete(Long id) {
        priceRepo.deleteById(id);
        return priceRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not update with id: " + id));
    }
}
