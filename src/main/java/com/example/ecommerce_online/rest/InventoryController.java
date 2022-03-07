package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Inventory;
import com.example.ecommerce_online.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/#/inventory")
public class InventoryController implements AbstractBaseController<Inventory>{

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    //CRUD operations

    @Override
    @PostMapping("/create")
    public ResponseEntity<?> create(Inventory inventory) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.create(inventory));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get-all")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<?> get(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryService.get(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<?> update(Inventory inventory) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryService.update(inventory));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(inventoryService.delete(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
