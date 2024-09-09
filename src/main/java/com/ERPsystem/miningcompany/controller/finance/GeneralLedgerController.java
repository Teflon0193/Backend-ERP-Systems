package com.ERPsystem.miningcompany.controller.finance;

import com.ERPsystem.miningcompany.Entity.finance.GeneralLedger;
import com.ERPsystem.miningcompany.service.finance.GeneralLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/general-ledger")
public class GeneralLedgerController {
    @Autowired
    private GeneralLedgerService generalLedgerService;

    // Retrieve all general ledgers
    @GetMapping
    public List<GeneralLedger> getAllGeneralLedgers() {
        return generalLedgerService.getAllGeneralLedgers();
    }

    // Retrieve a specific general ledger by ID
    @GetMapping("/{id}")
    public ResponseEntity<GeneralLedger> getGeneralLedgerById(@PathVariable Long id) {
        Optional<GeneralLedger> generalLedger = generalLedgerService.getGeneralLedgerById(id);
        return generalLedger.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new general ledger
    @PostMapping
    public GeneralLedger createGeneralLedger(@RequestBody GeneralLedger generalLedger) {
        return generalLedgerService.saveGeneralLedger(generalLedger);
    }

    // Update an existing general ledger
    @PutMapping("/{id}")
    public ResponseEntity<GeneralLedger> updateGeneralLedger(@PathVariable Long id, @RequestBody GeneralLedger generalLedgerDetails) {
        try {
            GeneralLedger updatedGeneralLedger = generalLedgerService.updateGeneralLedger(id, generalLedgerDetails);
            return ResponseEntity.ok(updatedGeneralLedger);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a general ledger by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeneralLedger(@PathVariable Long id) {
        generalLedgerService.deleteGeneralLedger(id);
        return ResponseEntity.noContent().build();
    }
}
