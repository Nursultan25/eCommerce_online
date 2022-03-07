package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.mapper.ProductMapper;
import com.example.ecommerce_online.service.dto.ProductDto;
import com.example.ecommerce_online.repository.*;
import com.example.ecommerce_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;
    private final InventoryRepo inventoryRepo;
    private final DiscountRepo discountRepo;
    private final CategoryRepo categoryRepo;
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo,
                              PriceRepo priceRepo,
                              InventoryRepo inventoryRepo,
                              DiscountRepo discountRepo,
                              CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.priceRepo = priceRepo;
        this.inventoryRepo = inventoryRepo;
        this.discountRepo = discountRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "product.id")
    public List<ProductDto> getAll() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByLowPrice() {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByHighPrice() {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByDateOld() {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByDateNew() {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public ProductDto get(Long id) {
        return null;
    }

    @Override
    @CachePut(cacheNames = "product", key = "#id")
    public ProductDto update(ProductDto productDto) {
        return null;
    }

    @Override
    @CacheEvict(cacheNames = "product", key = "#id")
    public ProductDto delete(Long id) {
        return null;
    }
}
