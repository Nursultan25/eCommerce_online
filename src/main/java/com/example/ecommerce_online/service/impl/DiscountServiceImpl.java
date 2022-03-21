package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Discount;
import com.example.ecommerce_online.model.request.UpdateProductRequest;
import com.example.ecommerce_online.repository.DiscountRepo;
import com.example.ecommerce_online.repository.ProductRepo;
import com.example.ecommerce_online.service.DiscountService;
import com.example.ecommerce_online.service.ProductService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;
    private final ProductRepo productRepo;
    private final ProductService productService;

    @Autowired
    public DiscountServiceImpl(DiscountRepo discountRepo, ProductRepo productRepo, ProductService productService) {
        this.discountRepo = discountRepo;
        this.productRepo = productRepo;
        this.productService = productService;
    }

    @Scheduled(cron = "0 0 */12 ? * *")
    public void updatingDiscount() throws InterruptedException{
        List<Discount> discounts = discountRepo.findAll();
        for (Discount discount : discounts) {
            int interSeconds = discount.getStartDate().getSecond() - LocalDateTime.now().getSecond();
            if (discount.getEndDate().compareTo(discount.getStartDate().plusSeconds(interSeconds)) < 0) {
                discount.setDiscount(0);
                discountRepo.save(discount);
                productRepo.findByDiscount(discount).map(products -> products.stream().map(product ->
                        productService.update( new UpdateProductRequest(product.getId()))));
            }
        }
    }

    @Override
    public Discount create(Discount discount) {
        return discountRepo.save(Discount.builder()
                        .discount(discount.getDiscount())
                        .startDate(LocalDateTime.now())
                        .endDate(LocalDateTime.now().plusWeeks(2))
                .build());
    }

    @Override
    public List<Discount> getAll() {
        return discountRepo.findAll();
    }

    @Override
    public Discount get(Long id) {
        return discountRepo.getById(id);
    }

    @Override
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
    public Discount delete(Long id) {
        discountRepo.deleteById(id);
        return discountRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Could not delete with id: " + id));

    }
}
