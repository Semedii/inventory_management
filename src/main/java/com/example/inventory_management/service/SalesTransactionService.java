package com.example.inventory_management.service;

import com.example.inventory_management.model.InventoryItem;
import com.example.inventory_management.model.SalesTransaction;
import com.example.inventory_management.repository.InventoryItemRepository;
import com.example.inventory_management.repository.SalesTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesTransactionService {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public SalesTransaction requestTransaction(SalesTransaction transaction) {
        // Check inventory availability
        InventoryItem item = inventoryItemRepository.findById(transaction.getInventoryItem().getId())
                .orElseThrow(() -> new RuntimeException("Inventory item not found"));
        if (item.getQuantity() < transaction.getRequestedQuantity()) {
            
            throw new RuntimeException("Not enough inventory available. "+item.getQuantity());
        }
        
        // Set initial approved quantity to 0 and isApproved to false
        transaction.setApprovedQuantity(0);
        transaction.setApproved(false);
        return salesTransactionRepository.save(transaction);
    }

    public void approveTransaction(Long transactionId, int approvedQuantity) {
        SalesTransaction transaction = getTransactionById(transactionId);
        if (transaction != null) {
            transaction.setApproved(true);
            transaction.setApprovedQuantity(approvedQuantity);
            salesTransactionRepository.save(transaction);

            // Update inventory if needed
            InventoryItem item = transaction.getInventoryItem();
            item.setQuantity(item.getQuantity() - approvedQuantity);
            inventoryItemRepository.save(item);
        }
    }

    public List<SalesTransaction> getAllTransactions() {
        return salesTransactionRepository.findAll();
    }

    public List<SalesTransaction> getUnapprovedTransactions() {
        return salesTransactionRepository.findAllByIsApproved(false);
    }

    public SalesTransaction getTransactionById(Long id) {
        return salesTransactionRepository.findById(id).orElse(null);
    }

    public void deleteTransaction(Long id) {
        salesTransactionRepository.deleteById(id);
    }
}
