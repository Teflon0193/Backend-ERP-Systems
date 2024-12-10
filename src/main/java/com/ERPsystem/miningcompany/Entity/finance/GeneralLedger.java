package com.ERPsystem.miningcompany.Entity.finance;

import jakarta.persistence.*;

@Entity
@Table(name = "general_ledger")
public class GeneralLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String accountName;  // Account description (e.g., "Accounts Payable")
    private String accountCode;  // Account code (e.g., "800")
    private Double debit;        // Debit amount
    private Double credit;       // Credit amount
    @Column(insertable = false, updatable = false)
    private Double netMovement;  // Net movement (debit - credit)


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getNetMovement() {
        return netMovement;
    }

    public void setNetMovement(Double netMovement) {
        this.netMovement = netMovement;
    }
}
