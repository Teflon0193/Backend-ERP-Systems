package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsReceivable;
import com.ERPsystem.miningcompany.Repository.finance.AccountsReceivableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsReceivableService {
    @Autowired
    private AccountsReceivableRepository accountsReceivableRepository;

    public List<AccountsReceivable> getAllAccountsReceivable() {
        return accountsReceivableRepository.findAll();
    }

    public Optional<AccountsReceivable> getAccountsReceivableById(Long id) {
        return accountsReceivableRepository.findById(id);
    }

    public AccountsReceivable saveAccountsReceivable(AccountsReceivable accountsReceivable) {
        return accountsReceivableRepository.save(accountsReceivable);
    }

    public AccountsReceivable updateAccountsReceivable(Long id, AccountsReceivable accountsReceivableDetails) {
        AccountsReceivable existingAccountsReceivable = accountsReceivableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountsReceivable not found with id " + id));
        existingAccountsReceivable.setCustomerName(accountsReceivableDetails.getCustomerName());
        existingAccountsReceivable.setAmountDue(accountsReceivableDetails.getAmountDue());
        existingAccountsReceivable.setDueDate(accountsReceivableDetails.getDueDate());
        return accountsReceivableRepository.save(existingAccountsReceivable);
    }

    public void deleteAccountsReceivable(Long id) {
        accountsReceivableRepository.deleteById(id);
    }
}
