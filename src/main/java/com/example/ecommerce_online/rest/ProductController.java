package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import com.example.ecommerce_online.model.request.UpdateProductRequest;
import com.example.ecommerce_online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateProductRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-low-price")
    public ResponseEntity<?> getByLowPrice() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findByLowPrice());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-high-price")
    public ResponseEntity<?> getByHighPrice() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findByHighPrice());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
    @GetMapping("/get-date-new")
    public ResponseEntity<?> getByDateNew() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findByDateNew());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-date-old")
    public ResponseEntity<?> getByDateOld() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findByDateOld());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-category")
    public ResponseEntity<?> getByCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.findByCategory(category));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.get(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateProductRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.update(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
