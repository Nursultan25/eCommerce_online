package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Inventory;
import com.example.ecommerce_online.repository.InventoryRepo;
import com.example.ecommerce_online.service.InventoryService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepo inventoryRepo;

    @Autowired
    public InventoryServiceImpl(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public Inventory create(Inventory inventoryDto) {
        Inventory inventory = new Inventory();
        inventory.setQuantity(inventoryDto.getQuantity());
        inventory.setInStock(checkQuantity(inventoryDto.getQuantity()));
        return inventoryRepo.save(inventory);
    }

    @Override
    @Cacheable(cacheNames = "inventory", key = "#id")
    public List<Inventory> getAll() {
        return inventoryRepo.findAll();
    }

    @Override
    @Cacheable(cacheNames = "inventory", key = "#id")
    public Inventory get(Long id) {
        return inventoryRepo.getById(id);
    }

    @Override
    @CachePut(cacheNames = "inventory", key = "#id")
    public Inventory update(Inventory inventory) {
        return inventoryRepo.findById(inventory.getId())
                .map(inventory1 -> {
                    inventory1.setQuantity(inventory.getQuantity());
                    inventory1.setInStock(checkQuantity(inventory.getQuantity()));
                    inventoryRepo.save(inventory1);
                    return inventory1;
                }).orElseThrow(() -> new NotFoundException("Could not update with id: " + inventory.getId()));
    }

    @Override
    @CacheEvict(cacheNames = "inventory", key = "#id")
    public Inventory delete(Long id) {
        inventoryRepo.deleteById(id);
        return inventoryRepo.findById(id).
                orElseThrow(() -> new NotFoundException("Could not update with id: " + id));
    }

    private Boolean checkQuantity(Long quantity) {
        if (quantity == 0) {
            return false;
        }
        return true;
    }
}
