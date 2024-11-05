package com.example.inventory_management.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class SalesTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private SalesPerson salesperson;

    @ManyToOne
    @JoinColumn(name = "sales_manager_id")
    private SalesManager salesManager;

    @ManyToOne
    @JoinColumn(name = "inventory_item_id")
    private InventoryItem inventoryItem;

    private int requestedQuantity; 
    private int approvedQuantity; 
    private Date transactionDate;
    private boolean isApproved; 

    public SalesTransaction() {}

    public SalesTransaction(SalesPerson salesperson, SalesManager salesManager, InventoryItem inventoryItem, int requestedQuantity, Date transactionDate, boolean isApproved) {
        this.salesperson = salesperson;
        this.salesManager = salesManager;
        this.inventoryItem = inventoryItem;
        this.requestedQuantity = requestedQuantity;
        this.transactionDate = transactionDate;
        this.isApproved = isApproved;
        this.approvedQuantity = 0; 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesPerson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(SalesPerson salesperson) {
        this.salesperson = salesperson;
    }

    public SalesManager getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(SalesManager salesManager) {
        this.salesManager = salesManager;
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public int getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(int requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public int getApprovedQuantity() {
        return approvedQuantity;
    }

    public void setApprovedQuantity(int approvedQuantity) {
        this.approvedQuantity = approvedQuantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
