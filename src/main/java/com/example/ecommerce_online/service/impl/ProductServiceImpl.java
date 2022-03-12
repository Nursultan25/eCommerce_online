package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.mapper.ProductMapper;
import com.example.ecommerce_online.model.entity.*;
import com.example.ecommerce_online.model.enums.ProductStatus;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import com.example.ecommerce_online.model.request.UpdateProductRequest;
import com.example.ecommerce_online.service.dto.ProductDto;
import com.example.ecommerce_online.repository.*;
import com.example.ecommerce_online.service.ProductService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

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
    public ProductDto create(CreateProductRequest request) {
        Category category = categoryRepo.getById(request.getCategory());
        Price price = priceRepo.getById(request.getPrice());
        Discount discount = discountRepo.getById(request.getDiscount());
        Inventory inventory = inventoryRepo.getById(request.getInventory());

        ProductDto productDto = ProductDto.builder()
                .name(request.getName())
                .description(request.getDescription())
                .suitableFor(request.getSuitableFor())
                .usage(request.getUsage())
                .consistOf(request.getConsistOf())
                .volume(request.getVolume())
                .brand(request.getBrand())
                .productStatus(request.getProductStatus())
                .category(category)
                .price(price)
                .discount(discount)
                .inventory(inventory)
                .image(request.getImage())
                .discountedPrice(discountedPricer(price, discount))
                .build();

            productRepo.save(new ProductMapper().toEntity(productDto));
        return productDto;
    }

    public BigDecimal discountedPricer(Price price, Discount discount) {
        BigDecimal priceVal = price.getPrice();
        double discountVal = discount.getDiscount() / 100;
        BigDecimal result = BigDecimal.ZERO;
        result = BigDecimal.valueOf(priceVal.doubleValue() - (priceVal.doubleValue() * discountVal));
        return result;
    }

    @Override
    @Cacheable(cacheNames = "product", key = "product.id")
    public List<ProductDto> getAll() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByLowPrice() {
        return new ProductMapper().toDtoList(productRepo.findByLowPrice()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByHighPrice() {
        return new ProductMapper().toDtoList(productRepo.findByHighPrice()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByDateOld() {
        return new ProductMapper().toDtoList(productRepo.findByDateOld()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public List<ProductDto> findByDateNew() {
        return new ProductMapper().toDtoList(productRepo.findByDateNew()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    public List<ProductDto> findByCategory(Category category) {
        return new ProductMapper().toDtoList(productRepo.findByCategory(category)
                .orElseThrow(() -> new NotFoundException("No products with category: " + category.getName())));
    }

    @Override
    @Cacheable(cacheNames = "product", key = "#id")
    public ProductDto get(Long id) {
        return new ProductMapper().toDto(productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Could  not find by id: " + id)));
    }

    @Override
    @CachePut(cacheNames = "product", key = "#id")
    public ProductDto update(UpdateProductRequest request) {
        Category category = categoryRepo.getById(request.getCategory());
        Price price = priceRepo.getById(request.getPrice());
        Discount discount = discountRepo.getById(request.getDiscount());
        Inventory inventory = inventoryRepo.getById(request.getInventory());

        return new ProductMapper().toDto(productRepo.findById(request.getId())
                .map(product -> {
                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setSuitableFor(request.getSuitableFor());
                    product.setUsage(request.getUsage());
                    product.setConsistOf(request.getConsistOf());
                    product.setVolume(request.getVolume());
                    product.setBrand(request.getBrand());
                    product.setProductStatus(request.getProductStatus());
                    product.setCategory(category);
                    product.setPrice(price);
                    product.setDiscount(discount);
                    product.setInventory(inventory);
                    product.setImage(request.getImage());
                    product.setDiscountedPrice(discountedPricer(price, discount));
                    productRepo.save(product);
                    return product;
                }));
    }

    @Override
    @CacheEvict(cacheNames = "product", key = "#id")
    public ProductDto delete(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id: " + id + " not found or already deleted"));
        productRepo.deleteById(id);
        return new ProductMapper().toDto(product);
    }
}
