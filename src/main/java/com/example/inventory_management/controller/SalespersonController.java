package com.example.inventory_management.controller;

import com.example.inventory_management.model.SalesPerson;
import com.example.inventory_management.service.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salespersons")
public class SalespersonController {

    @Autowired
    private SalespersonService salespersonService;

    @PostMapping
    public ResponseEntity<SalesPerson> addSalesperson(@RequestBody SalesPerson salesperson) {
        SalesPerson createdSalesperson = salespersonService.addSalesperson(salesperson);
        return new ResponseEntity<>(createdSalesperson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalesPerson>> getAllSalespersons() {
        List<SalesPerson> salespersons = salespersonService.getAllSalespersons();
        return new ResponseEntity<>(salespersons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesPerson> getSalespersonById(@PathVariable Long id) {
        SalesPerson salesperson = salespersonService.getSalespersonById(id);
        return salesperson != null ? new ResponseEntity<>(salesperson, HttpStatus.OK) 
                                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesPerson> updateSalesperson(@PathVariable Long id, @RequestBody SalesPerson salespersonDetails) {
        SalesPerson updatedSalesperson = salespersonService.updateSalesperson(id, salespersonDetails);
        return updatedSalesperson != null ? new ResponseEntity<>(updatedSalesperson, HttpStatus.OK) 
                                           : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesperson(@PathVariable Long id) {
        salespersonService.deleteSalesperson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
