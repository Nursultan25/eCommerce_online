package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Order;
import com.example.ecommerce_online.model.request.CreateOrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order create(CreateOrderRequest request);

    List<Order> getAll();

    Order get(Long id);
}
