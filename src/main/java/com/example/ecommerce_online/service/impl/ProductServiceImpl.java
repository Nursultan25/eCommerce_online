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
        Category category = categoryRepo.findById(request.getCategory()).get();
        Price price = priceRepo.findById(request.getPrice()).get();
        Discount discount = discountRepo.findById(request.getDiscount()).get();
        Inventory inventory = inventoryRepo.findById(request.getInventory()).get();

        Product product = Product.builder()
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

            productRepo.save(product);
        return new ProductMapper().toDto(product);
    }

    public BigDecimal discountedPricer(Price price, Discount discount) {
        BigDecimal priceVal = price.getPrice();
        System.out.println("------------------------- PRICE IS " + priceVal);
        int discountVal = discount.getDiscount();
        System.out.println("------------------------- DISCOUNT IS " + discountVal);
        BigDecimal result = BigDecimal.ZERO;
        result = BigDecimal.valueOf((discountVal / priceVal.doubleValue()) * 100);
        System.out.println("------------------------- FINAL PRICE " + result);
        return BigDecimal.valueOf(Math.round(result.doubleValue()));
    }

    @Override
    public List<ProductDto> getAll() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    public List<ProductDto> findByLowPrice() {
        return new ProductMapper().toDtoList(productRepo.findByLowPrice()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    public List<ProductDto> findByHighPrice() {
        return new ProductMapper().toDtoList(productRepo.findByHighPrice()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
    public List<ProductDto> findByDateOld() {
        return new ProductMapper().toDtoList(productRepo.findByDateOld()
                .orElseThrow(() -> new NotFoundException("No products found")));
    }

    @Override
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
    public ProductDto get(Long id) {
        return new ProductMapper().toDto(productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Could  not find by id: " + id)));
    }

    @Override
    public ProductDto update(UpdateProductRequest request) {

        return new ProductMapper().toDto(productRepo.findById(request.getId())
                .map(product -> {
                    if (request.getName() == null) {
                        product.setName(product.getName());
                    } else
                    product.setName(request.getName());

                    if (request.getDescription() == null) {
                        product.setDescription(product.getDescription());
                    } else
                    product.setDescription(request.getDescription());

                    if (request.getSuitableFor() == null) {
                        product.setSuitableFor(product.getSuitableFor());
                    } else
                    product.setSuitableFor(request.getSuitableFor());

                    if (request.getUsage() == null) {
                        product.setUsage(product.getUsage());
                    } else
                    product.setUsage(request.getUsage());

                    if (request.getConsistOf() == null) {
                        product.setConsistOf(product.getConsistOf());
                    } else
                    product.setConsistOf(request.getConsistOf());

                    if (request.getVolume() == null) {
                        product.setVolume(product.getVolume());
                    } else
                    product.setVolume(request.getVolume());

                    if (request.getBrand() == null) {
                        product.setBrand(product.getBrand());
                    } else
                    product.setBrand(request.getBrand());

                    if (request.getProductStatus() == null) {
                        product.setProductStatus(product.getProductStatus());
                    } else
                    product.setProductStatus(request.getProductStatus());

                    if (request.getCategory() == null) {
                        product.setCategory(product.getCategory());
                    } else
                    product.setCategory(categoryRepo.findById(request.getCategory()).get());

                    if (request.getPrice() == null) {
                        product.setPrice(product.getPrice());
                    } else
                    product.setPrice(priceRepo.findById(request.getPrice()).get());

                    if (request.getDiscount() == null) {
                        product.setDiscount(product.getDiscount());
                    } else
                    product.setDiscount(discountRepo.findById(request.getDiscount()).get());

                    if (request.getInventory() == null) {
                        product.setInventory(product.getInventory());
                    } else
                    product.setInventory(inventoryRepo.findById(request.getInventory()).get());

                    if (request.getImage() == null) {
                        product.setImage(product.getImage());
                    } else
                    product.setImage(request.getImage());

                    product.setDiscountedPrice(discountedPricer(product.getPrice(), product.getDiscount()));

                    productRepo.save(product);
                    return product;
                }).orElseThrow(() -> new NotFoundException("Could not update with id: " + request.getId())));
    }

    @Override
    public ProductDto delete(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with id: " + id + " not found or already deleted"));
        productRepo.deleteById(id);
        return new ProductMapper().toDto(product);
    }
}
