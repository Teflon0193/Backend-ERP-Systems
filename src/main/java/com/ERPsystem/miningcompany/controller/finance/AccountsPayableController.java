package com.ERPsystem.miningcompany.controller.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsPayable;
import com.ERPsystem.miningcompany.service.finance.AccountsPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts-payable")
public class AccountsPayableController {
    @Autowired
    private AccountsPayableService accountsPayableService;

    // Retrieve all accounts payable
    @GetMapping
    public List<AccountsPayable> getAllAccountsPayable() {
        return accountsPayableService.getAllAccountsPayable();
    }

    // Retrieve a specific accounts payable entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountsPayable> getAccountsPayableById(@PathVariable Long id) {
        Optional<AccountsPayable> accountsPayable = accountsPayableService.getAccountsPayableById(id);
        return accountsPayable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new accounts payable entry
    @PostMapping
    public AccountsPayable createAccountsPayable(@RequestBody AccountsPayable accountsPayable) {
        return accountsPayableService.saveAccountsPayable(accountsPayable);
    }

    // Update an existing accounts payable entry
    @PutMapping("/{id}")
    public ResponseEntity<AccountsPayable> updateAccountsPayable(@PathVariable Long id, @RequestBody AccountsPayable accountsPayableDetails) {
        try {
            AccountsPayable updatedAccountsPayable = accountsPayableService.updateAccountsPayable(id, accountsPayableDetails);
            return ResponseEntity.ok(updatedAccountsPayable);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an accounts payable entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountsPayable(@PathVariable Long id) {
        accountsPayableService.deleteAccountsPayable(id);
        return ResponseEntity.noContent().build();
    }
}
