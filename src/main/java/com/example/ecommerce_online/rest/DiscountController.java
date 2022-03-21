package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Discount;
import com.example.ecommerce_online.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
@CrossOrigin("*")
public class DiscountController implements AbstractBaseController<Discount>{

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    //CRUD operations

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Discount discount) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(discountService.create(discount));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(discountService.getAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(discountService.get(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Discount discount) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(discountService.update(discount));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(discountService.delete(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
