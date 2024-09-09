package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.MinePlan;
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
        return ResponseEntity.ok(createdMinePlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinePlan> getMinePlanById(@PathVariable Long id) {
        Optional<MinePlan> minePlan = minePlanService.getMinePlanById(id);
        return minePlan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<MinePlan>> getAllMinePlans() {
        return ResponseEntity.ok(minePlanService.getAllMinePlans());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinePlan> updateMinePlan(@PathVariable Long id, @RequestBody MinePlan updatedMinePlan) {
        MinePlan minePlan = minePlanService.updateMinePlan(id, updatedMinePlan);
        if (minePlan != null) {
            return ResponseEntity.ok(minePlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMinePlan(@PathVariable Long id) {
        minePlanService.deleteMinePlan(id);
        return ResponseEntity.noContent().build();
    }


}
