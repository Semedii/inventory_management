package com.example.inventory_management.service;

import com.example.inventory_management.model.InventoryItem;
import com.example.inventory_management.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    // Add a new inventory item
    public InventoryItem addItem(InventoryItem item) {
        return inventoryItemRepository.save(item);
    }

    // Get all inventory items
    public List<InventoryItem> getAllItems() {
        return inventoryItemRepository.findAll();
    }

    // Get a specific inventory item by ID
    public Optional<InventoryItem> getItemById(Long id) {
        return inventoryItemRepository.findById(id);
    }

    // Update an existing inventory item
    public InventoryItem updateItem(Long id, InventoryItem itemDetails) {
        InventoryItem item = inventoryItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(itemDetails.getName());
        item.setQuantity(itemDetails.getQuantity());
        return inventoryItemRepository.save(item);
    }

    // Delete an inventory item
    public void deleteItem(Long id) {
        inventoryItemRepository.deleteById(id);
    }
}
