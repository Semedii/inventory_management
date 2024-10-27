package com.example.inventory_management.controller;

import com.example.inventory_management.model.InventoryItem;
import com.example.inventory_management.repository.InventoryItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.findAll();
    }

    @PostMapping
    public InventoryItem addItem(@RequestBody InventoryItem item) {
        return inventoryItemRepository.save(item);
    }
}
