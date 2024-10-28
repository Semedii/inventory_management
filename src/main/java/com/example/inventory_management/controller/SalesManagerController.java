package com.example.inventory_management.controller;

import com.example.inventory_management.model.SalesManager;
import com.example.inventory_management.service.SalesManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-managers")
public class SalesManagerController {

    @Autowired
    private SalesManagerService salesManagerService;

    @PostMapping
    public ResponseEntity<SalesManager> addSalesManager(@RequestBody SalesManager salesManager) {
        SalesManager createdSalesManager = salesManagerService.addSalesManager(salesManager);
        return new ResponseEntity<>(createdSalesManager, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalesManager>> getAllSalesManagers() {
        List<SalesManager> salesManagers = salesManagerService.getAllSalesManagers();
        return new ResponseEntity<>(salesManagers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesManager> getSalesManagerById(@PathVariable Long id) {
        SalesManager salesManager = salesManagerService.getSalesManagerById(id);
        return salesManager != null ? new ResponseEntity<>(salesManager, HttpStatus.OK) 
                                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesManager> updateSalesManager(@PathVariable Long id, @RequestBody SalesManager salesManagerDetails) {
        SalesManager updatedSalesManager = salesManagerService.updateSalesManager(id, salesManagerDetails);
        return updatedSalesManager != null ? new ResponseEntity<>(updatedSalesManager, HttpStatus.OK) 
                                            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesManager(@PathVariable Long id) {
        salesManagerService.deleteSalesManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
