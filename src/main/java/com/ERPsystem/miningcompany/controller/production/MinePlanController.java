package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.MinePlan;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.production.MinePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/mine-plans")
public class MinePlanController {
    @Autowired
    private MinePlanService minePlanService;

    @PostMapping
    public ResponseEntity<MinePlan> createMinePlan(@RequestBody MinePlan minePlan) {
        MinePlan createdMinePlan = minePlanService.createMinePlan(minePlan);
        return ResponseEntity.status(201).body(createdMinePlan);  // Return status 201 (Created)
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMinePlanById(@PathVariable Long id) {
        try {
            MinePlan minePlan = minePlanService.getMinePlanById(id);
            return ResponseEntity.ok(minePlan);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<MinePlan>> getAllMinePlans() {
        return ResponseEntity.ok(minePlanService.getAllMinePlans());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMinePlan(@PathVariable Long id, @RequestBody MinePlan updatedMinePlan) {
        try {
            MinePlan minePlan = minePlanService.updateMinePlan(id, updatedMinePlan);
            return ResponseEntity.ok(minePlan);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMinePlan(@PathVariable Long id) {
        try {
            minePlanService.deleteMinePlan(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }


}
