package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.repository.CategoryRepo;
import com.example.ecommerce_online.service.CategoryService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"category"})
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category get(Long id) {
        return categoryRepo.getById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepo.findById(category.getId())
                .map(category1 -> {
                    category1.setName(category.getName());
                    category1.setActive(category.getActive());
                    category1.setImage(category.getImage());
                    categoryRepo.save(category1);
                    return category1;
                }).orElseThrow(() -> new NotFoundException("Could not find with id: " + category.getId()));
    }

    @Override
    public Category delete(Long id) {
        categoryRepo.deleteById(id);
        return categoryRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Could not found with id: " + id));
    }
}
