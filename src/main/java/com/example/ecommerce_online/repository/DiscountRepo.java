package com.example.ecommerce_online.repository;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
}