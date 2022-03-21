package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Price;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService {

    Price create(Price price);

    List<Price> getAll();

    Price get(Long id);

    Price update(Price price);

    Price delete(Long id);

}
