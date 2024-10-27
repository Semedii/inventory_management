package com.example.inventory_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventory_management.model.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}
