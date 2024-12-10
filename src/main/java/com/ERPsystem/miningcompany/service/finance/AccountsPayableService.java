package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsPayable;
import com.ERPsystem.miningcompany.Repository.finance.AccountsPayableRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        existingAccountsPayable.setBalance(accountsPayableDetails.getBalance());
        existingAccountsPayable.setPaymentDueDate(accountsPayableDetails.getPaymentDueDate());
        existingAccountsPayable.setInvoiceDateIssued(accountsPayableDetails.getInvoiceDateIssued());
        existingAccountsPayable.setReference(accountsPayableDetails.getReference());
        existingAccountsPayable.setTransactionId(accountsPayableDetails.getTransactionId());
        existingAccountsPayable.setTransactionType(accountsPayableDetails.getTransactionType());

        return accountsPayableRepository.save(existingAccountsPayable);
    }

    // Delete an accounts payable entry by ID
    public void deleteAccountsPayable(Long id) {
        AccountsPayable accountsPayable = accountsPayableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AccountsPayable not found with id " + id));

        accountsPayableRepository.delete(accountsPayable);
    }

    // Group accounts payable by due date with totals
    public List<Map<String, Object>> getGroupedByDueDateWithTotals() {
        List<AccountsPayable> allRecords = accountsPayableRepository.findAll();

        // Group by due date
        Map<Date, List<AccountsPayable>> groupedByDueDate = allRecords.stream()
                .collect(Collectors.groupingBy(AccountsPayable::getPaymentDueDate));

        // Prepare response with totals
        List<Map<String, Object>> groupedDataWithTotals = new ArrayList<>();
        for (Map.Entry<Date, List<AccountsPayable>> entry : groupedByDueDate.entrySet()) {
            Map<String, Object> group = new LinkedHashMap<>();
            group.put("dueDate", entry.getKey());
            group.put("accountsPayable", entry.getValue());

            // Calculate total for the group
            double totalAmount = entry.getValue().stream()
                    .mapToDouble(AccountsPayable::getAmountOwed)
                    .sum();
            group.put("total", totalAmount);

            groupedDataWithTotals.add(group);
        }

        return groupedDataWithTotals;
    }
}
