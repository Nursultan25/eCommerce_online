package com.example.ecommerce_online.repository;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
