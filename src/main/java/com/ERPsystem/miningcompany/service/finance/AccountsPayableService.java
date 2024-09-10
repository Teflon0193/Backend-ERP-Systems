package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsPayable;
import com.ERPsystem.miningcompany.Repository.finance.AccountsPayableRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsPayableService {
    @Autowired
    private AccountsPayableRepository accountsPayableRepository;

    // Retrieve all accounts payable
    public List<AccountsPayable> getAllAccountsPayable() {
        return accountsPayableRepository.findAll();
    }

    // Retrieve a specific accounts payable entry by ID
    public AccountsPayable getAccountsPayableById(Long id) {
        return accountsPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountsPayable not found with id " + id));
    }

    // Save a new accounts payable entry
    public AccountsPayable saveAccountsPayable(AccountsPayable accountsPayable) {
        return accountsPayableRepository.save(accountsPayable);
    }

    // Update an existing accounts payable entry
    public AccountsPayable updateAccountsPayable(Long id, AccountsPayable accountsPayableDetails) {
        AccountsPayable existingAccountsPayable = accountsPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountsPayable not found with id " + id));

        existingAccountsPayable.setSupplierName(accountsPayableDetails.getSupplierName());
        existingAccountsPayable.setAmountOwed(accountsPayableDetails.getAmountOwed());
        existingAccountsPayable.setPaymentDueDate(accountsPayableDetails.getPaymentDueDate());

        return accountsPayableRepository.save(existingAccountsPayable);
    }

    // Delete an accounts payable entry by ID
    public void deleteAccountsPayable(Long id) {
        AccountsPayable accountsPayable = accountsPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountsPayable not found with id " + id));

        accountsPayableRepository.delete(accountsPayable);
    }
}
