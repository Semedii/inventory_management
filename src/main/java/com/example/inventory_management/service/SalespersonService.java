package com.example.inventory_management.service;

import com.example.inventory_management.model.SalesPerson;
import com.example.inventory_management.repository.SalespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalespersonService {

    @Autowired
    private SalespersonRepository salespersonRepository;

    public SalesPerson addSalesperson(SalesPerson salesperson) {
        return salespersonRepository.save(salesperson);
    }

    public List<SalesPerson> getAllSalespersons() {
        return salespersonRepository.findAll();
    }

    public SalesPerson getSalespersonById(Long id) {
        return salespersonRepository.findById(id).orElse(null);
    }

    public SalesPerson updateSalesperson(Long id, SalesPerson salespersonDetails) {
        SalesPerson salesperson = getSalespersonById(id);
        if (salesperson != null) {
            salesperson.setName(salespersonDetails.getName());
            // Set other fields as necessary
            return salespersonRepository.save(salesperson);
        }
        return null;
    }

    public void deleteSalesperson(Long id) {
        salespersonRepository.deleteById(id);
    }
}
