package com.example.inventory_management.repository;

import com.example.inventory_management.model.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalespersonRepository extends JpaRepository<SalesPerson, Long> {
    // Additional query methods can be defined here if needed
}
