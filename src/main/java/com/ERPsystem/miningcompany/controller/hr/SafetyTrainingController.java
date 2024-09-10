package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.SafetyTraining;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.SafetyTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/safety-training")
public class SafetyTrainingController {
    @Autowired
    private SafetyTrainingService safetyTrainingService;

    @PostMapping
    public ResponseEntity<SafetyTraining> createSafetyTraining(@RequestBody SafetyTraining safetyTraining) {
        SafetyTraining createdSafetyTraining = safetyTrainingService.createSafetyTraining(safetyTraining);
        return ResponseEntity.status(201).body(createdSafetyTraining);  // Created status with safetyTraining
    }

    @GetMapping
    public ResponseEntity<List<SafetyTraining>> getAllSafetyTrainings() {
        List<SafetyTraining> safetyTrainings = safetyTrainingService.getAllSafetyTrainings();
        return ResponseEntity.ok(safetyTrainings);  // OK status with safetyTrainings list
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSafetyTrainingById(@PathVariable Long id) {
        try {
            SafetyTraining safetyTraining = safetyTrainingService.getSafetyTrainingById(id);
            return ResponseEntity.ok(safetyTraining);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSafetyTraining(@PathVariable Long id, @RequestBody SafetyTraining safetyTrainingDetails) {
        try {
            SafetyTraining updatedSafetyTraining = safetyTrainingService.updateSafetyTraining(id, safetyTrainingDetails);
            return ResponseEntity.ok(updatedSafetyTraining);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSafetyTraining(@PathVariable Long id) {
        try {
            safetyTrainingService.deleteSafetyTraining(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

}
