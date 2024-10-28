package com.example.inventory_management.repository;

import com.example.inventory_management.model.SalesTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, Long> {
    List<SalesTransaction> findAllByIsApproved(boolean isApproved);
}
