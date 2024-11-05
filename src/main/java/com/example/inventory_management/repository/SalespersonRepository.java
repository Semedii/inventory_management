package com.example.inventory_management.repository;

import com.example.inventory_management.model.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalespersonRepository extends JpaRepository<SalesPerson, Long> {
}
