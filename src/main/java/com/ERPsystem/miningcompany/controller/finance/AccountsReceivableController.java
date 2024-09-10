package com.ERPsystem.miningcompany.controller.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsReceivable;
import com.ERPsystem.miningcompany.service.finance.AccountsReceivableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts-receivable")
public class AccountsReceivableController {
    @Autowired
    private AccountsReceivableService accountsReceivableService;

    // Retrieve all accounts receivable
    @GetMapping
    public List<AccountsReceivable> getAllAccountsReceivable() {
        return accountsReceivableService.getAllAccountsReceivable();
    }

    // Retrieve a specific accounts receivable entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountsReceivable> getAccountsReceivableById(@PathVariable Long id) {
        AccountsReceivable accountsReceivable = accountsReceivableService.getAccountsReceivableById(id);
        return ResponseEntity.ok().body(accountsReceivable);
    }

    // Create a new accounts receivable entry
    @PostMapping
    public AccountsReceivable createAccountsReceivable(@RequestBody AccountsReceivable accountsReceivable) {
        return accountsReceivableService.saveAccountsReceivable(accountsReceivable);
    }

    // Update an existing accounts receivable entry
    @PutMapping("/{id}")
    public ResponseEntity<AccountsReceivable> updateAccountsReceivable(@PathVariable Long id, @RequestBody AccountsReceivable accountsReceivableDetails) {
        try {
            AccountsReceivable updatedAccountsReceivable = accountsReceivableService.updateAccountsReceivable(id, accountsReceivableDetails);
            return ResponseEntity.ok(updatedAccountsReceivable);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an accounts receivable entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountsReceivable(@PathVariable Long id) {
        accountsReceivableService.deleteAccountsReceivable(id);
        return ResponseEntity.noContent().build();
    }
}
