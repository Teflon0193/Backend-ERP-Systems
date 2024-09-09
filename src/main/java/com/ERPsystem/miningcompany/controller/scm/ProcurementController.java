package com.ERPsystem.miningcompany.controller.scm;

import com.ERPsystem.miningcompany.Entity.scm.Procurement;
import com.ERPsystem.miningcompany.service.scm.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/procurements")
public class ProcurementController {
    @Autowired
    private ProcurementService procurementService;

    @PostMapping
    public ResponseEntity<Procurement> createProcurement(@RequestBody Procurement procurement) {
        Procurement createdProcurement = procurementService.createProcurement(procurement);
        return new ResponseEntity<>(createdProcurement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Procurement>> getAllProcurements() {
        List<Procurement> procurements = procurementService.getAllProcurements();
        return new ResponseEntity<>(procurements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procurement> getProcurementById(@PathVariable Long id) {
        Optional<Procurement> procurement = procurementService.getProcurementById(id);
        return procurement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procurement> updateProcurement(@PathVariable Long id, @RequestBody Procurement procurement) {
        Procurement updatedProcurement = procurementService.updateProcurement(id, procurement);
        return updatedProcurement != null ? ResponseEntity.ok(updatedProcurement) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcurement(@PathVariable Long id) {
        procurementService.deleteProcurement(id);
        return ResponseEntity.noContent().build();
    }

}
