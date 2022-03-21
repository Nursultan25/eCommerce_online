package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import com.example.ecommerce_online.model.request.UpdateProductRequest;
import com.example.ecommerce_online.service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDto create(CreateProductRequest request);

    List<ProductDto> getAll();

    List<ProductDto> findByLowPrice();

    List<ProductDto> findByHighPrice();

    List<ProductDto> findByDateOld();

    List<ProductDto> findByDateNew();

    List<ProductDto> findByCategory(Category category);

    ProductDto get(Long id);

    ProductDto update(UpdateProductRequest request);

    ProductDto delete(Long id);

}
