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
    private Double amountOwed;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paymentDueDate;


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

    public Double getAmountOwed() {
        return amountOwed;
    }
    public void setAmountOwed(Double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }
    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }
}
