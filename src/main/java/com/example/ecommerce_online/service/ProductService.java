package com.example.ecommerce_online.service;

import com.example.ecommerce_online.service.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto create(ProductDto productDto);
    List<ProductDto> getAll();
    List<ProductDto> findByLowPrice(); //Написать query в репозитории
    List<ProductDto> findByHighPrice(); //Написать query в репозитории
    List<ProductDto> findByDateOld(); //Написать query в репозитории
    List<ProductDto> findByDateNew(); //Написать query в репозитории
    ProductDto get(Long id);
    ProductDto update(ProductDto productDto);
    ProductDto delete(Long id);
}
