package com.ERPsystem.miningcompany.Entity.finance;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "accounts_payable")
public class AccountsPayable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String supplierName;
    private String reference; // Invoice reference
    private String transactionType;
    private String transactionId;
    private Double amountOwed;
    private Double balance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paymentDueDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date invoiceDateIssued; // Date the invoice was issued


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(Double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Date getInvoiceDateIssued() {
        return invoiceDateIssued;
    }

    public void setInvoiceDateIssued(Date invoiceDateIssued) {
        this.invoiceDateIssued = invoiceDateIssued;
    }
}
