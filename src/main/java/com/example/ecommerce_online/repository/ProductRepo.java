package com.example.ecommerce_online.repository;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM tb_product AS prod " +
            "JOIN tb_price AS prs ON prod.id = prs.id " +
            "ORDER BY prs.price DESC", nativeQuery = true)
    Optional<List<Product>> findByLowPrice();

    @Query(value = "SELECT * FROM tb_product AS prod " +
            "JOIN tb_price AS prs ON prod.id = prs.id " +
            "ORDER BY prs.price ASC", nativeQuery = true)
    Optional<List<Product>> findByHighPrice();

    @Query(value = "SELECT * FROM tb_product AS prod" +
            "ORDER BY date_created DESC", nativeQuery = true)
    Optional<List<Product>> findByDateOld();

    @Query(value = "SELECT * FROM tb_product AS prod" +
            "ORDER BY date_created ASC", nativeQuery = true)
    Optional<List<Product>> findByDateNew();

    Optional<List<Product>> findByCategory(Category category);
}
