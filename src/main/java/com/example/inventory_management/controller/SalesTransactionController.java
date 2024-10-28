package com.example.inventory_management.controller;

import com.example.inventory_management.model.SalesTransaction;
import com.example.inventory_management.service.SalesTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-transactions")
public class SalesTransactionController {

    @Autowired
    private SalesTransactionService salesTransactionService;

    // Request a sales transaction
    @PostMapping("/request")
    public ResponseEntity<SalesTransaction> requestTransaction(@RequestBody SalesTransaction transaction) {
        SalesTransaction createdTransaction = salesTransactionService.requestTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    // Approve a transaction
    @PostMapping("/{id}/approve")
    public ResponseEntity<Void> approveTransaction(@PathVariable Long id, @RequestParam int approvedQuantity) {
        salesTransactionService.approveTransaction(id, approvedQuantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<SalesTransaction>> getAllTransactions() {
        List<SalesTransaction> transactions = salesTransactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesTransaction> getTransactionById(@PathVariable Long id) {
        SalesTransaction transaction = salesTransactionService.getTransactionById(id);
        return transaction != null ? new ResponseEntity<>(transaction, HttpStatus.OK) 
                                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        salesTransactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/unapproved")
    public ResponseEntity<List<SalesTransaction>> getUnapprovedTransactions() {
        List<SalesTransaction> unapprovedTransactions = salesTransactionService.getUnapprovedTransactions();
        return new ResponseEntity<>(unapprovedTransactions, HttpStatus.OK);
    }
}
