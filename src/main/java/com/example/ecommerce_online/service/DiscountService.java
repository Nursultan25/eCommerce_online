package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {

    Discount create(Discount discount);

    List<Discount> getAll();

    Discount get(Long id);

    Discount update(Discount discount);

    Discount delete(Long id);

}
