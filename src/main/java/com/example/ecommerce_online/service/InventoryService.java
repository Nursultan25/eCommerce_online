package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    Inventory create(Inventory inventory);

    List<Inventory> getAll();

    Inventory get(Long id);

    Inventory update(Inventory inventory);

    Inventory delete(Long id);

}
