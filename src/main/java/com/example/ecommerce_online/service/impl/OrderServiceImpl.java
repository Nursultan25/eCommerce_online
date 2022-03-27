package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.mapper.CustomerMapper;
import com.example.ecommerce_online.mapper.ProductMapper;
import com.example.ecommerce_online.model.entity.Order;
import com.example.ecommerce_online.model.request.CreateOrderRequest;
import com.example.ecommerce_online.repository.OrderRepo;
import com.example.ecommerce_online.service.CustomerService;
import com.example.ecommerce_online.service.OrderService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CustomerService customerService;
    private CustomerMapper customerMapper;
    private ProductMapper productMapper;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, CustomerService customerService) {
        this.orderRepo = orderRepo;
        this.customerService = customerService;
    }

    @Override
    public Order create(CreateOrderRequest request) {
        Order order = new Order();
        order.setProductList(productMapper.toEntities(request.getProducts()));
        order.setCustomer(customerMapper.toEntity(customerService.register(request.getCustomerRequest())));
        order.setTotalPrice(request.getTotalPrice());
        orderRepo.save(order);
        return order;
    }

    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public Order get(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new NotFoundException("Order not " + id + " found"));
    }
}
