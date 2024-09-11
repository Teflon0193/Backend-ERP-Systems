package com.ERPsystem.miningcompany.controller.scm;

import com.ERPsystem.miningcompany.Entity.scm.Procurement;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
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
    public ResponseEntity<?> getProcurementById(@PathVariable Long id) {
        try {
            Procurement procurement = procurementService.getProcurementById(id);
            return ResponseEntity.ok(procurement);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProcurement(@PathVariable Long id, @RequestBody Procurement procurement) {
        try {
            Procurement updatedProcurement = procurementService.updateProcurement(id, procurement);
            return ResponseEntity.ok(updatedProcurement);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProcurement(@PathVariable Long id) {
        try {
            procurementService.deleteProcurement(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
