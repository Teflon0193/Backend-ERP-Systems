package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsPayable;
import com.ERPsystem.miningcompany.Repository.finance.AccountsPayableRepository;
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
    public Optional<AccountsPayable> getAccountsPayableById(Long id) {
        return accountsPayableRepository.findById(id);
    }

    // Save a new accounts payable entry
    public AccountsPayable saveAccountsPayable(AccountsPayable accountsPayable) {
        return accountsPayableRepository.save(accountsPayable);
    }

    // Update an existing accounts payable entry
    public AccountsPayable updateAccountsPayable(Long id, AccountsPayable accountsPayableDetails) {
        Optional<AccountsPayable> optionalAccountsPayable = accountsPayableRepository.findById(id);

        if (optionalAccountsPayable.isPresent()) {
            AccountsPayable existingAccountsPayable = optionalAccountsPayable.get();
            existingAccountsPayable.setSupplierName(accountsPayableDetails.getSupplierName());
            existingAccountsPayable.setAmountOwed(accountsPayableDetails.getAmountOwed());
            existingAccountsPayable.setPaymentDueDate(accountsPayableDetails.getPaymentDueDate());

            return accountsPayableRepository.save(existingAccountsPayable);
        } else {
            throw new RuntimeException("AccountsPayable not found with id " + id);
        }
    }

    // Delete an accounts payable entry by ID
    public void deleteAccountsPayable(Long id) {
        accountsPayableRepository.deleteById(id);
    }
}
