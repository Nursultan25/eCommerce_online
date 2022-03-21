package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Price;
import com.example.ecommerce_online.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
@CrossOrigin("*")
public class PriceController implements AbstractBaseController<Price> {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    //CRUD operations

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Price price) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(priceService.create(price));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(priceService.getAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(priceService.get(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Price price) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(priceService.update(price));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(priceService.delete(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
