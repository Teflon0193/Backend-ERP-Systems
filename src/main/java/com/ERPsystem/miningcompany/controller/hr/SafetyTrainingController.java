package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.SafetyTraining;
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
        return new ResponseEntity<>(createdSafetyTraining, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SafetyTraining>> getAllSafetyTrainings() {
        List<SafetyTraining> safetyTrainings = safetyTrainingService.getAllSafetyTrainings();
        return new ResponseEntity<>(safetyTrainings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafetyTraining> getSafetyTrainingById(@PathVariable Long id) {
        Optional<SafetyTraining> safetyTraining = safetyTrainingService.getSafetyTrainingById(id);
        return safetyTraining.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SafetyTraining> updateSafetyTraining(@PathVariable Long id, @RequestBody SafetyTraining safetyTrainingDetails) {
        SafetyTraining updatedSafetyTraining = safetyTrainingService.updateSafetyTraining(id, safetyTrainingDetails);
        return updatedSafetyTraining != null ? ResponseEntity.ok(updatedSafetyTraining) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSafetyTraining(@PathVariable Long id) {
        safetyTrainingService.deleteSafetyTraining(id);
        return ResponseEntity.noContent().build();
    }

}
