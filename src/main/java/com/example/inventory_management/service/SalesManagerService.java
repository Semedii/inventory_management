package com.example.inventory_management.service;

import com.example.inventory_management.model.SalesManager;
import com.example.inventory_management.repository.SalesManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesManagerService {

    @Autowired
    private SalesManagerRepository salesManagerRepository;

    public SalesManager addSalesManager(SalesManager salesManager) {
        return salesManagerRepository.save(salesManager);
    }

    public List<SalesManager> getAllSalesManagers() {
        return salesManagerRepository.findAll();
    }

    public SalesManager getSalesManagerById(Long id) {
        return salesManagerRepository.findById(id).orElse(null);
    }

    public SalesManager updateSalesManager(Long id, SalesManager salesManagerDetails) {
        SalesManager salesManager = getSalesManagerById(id);
        if (salesManager != null) {
            salesManager.setName(salesManagerDetails.getName());
            // Set other fields as necessary
            return salesManagerRepository.save(salesManager);
        }
        return null;
    }

    public void deleteSalesManager(Long id) {
        salesManagerRepository.deleteById(id);
    }
}
