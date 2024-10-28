package com.example.inventory_management.repository;

import com.example.inventory_management.model.SalesManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesManagerRepository extends JpaRepository<SalesManager, Long> {
    // Additional query methods can be defined here if needed
}
