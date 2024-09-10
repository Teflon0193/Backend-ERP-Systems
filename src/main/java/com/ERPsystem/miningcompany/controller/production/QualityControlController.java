package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.QualityControl;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.production.QualityControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/quality-control")
public class QualityControlController {
    @Autowired
    private QualityControlService qualityControlService;

    @PostMapping
    public ResponseEntity<QualityControl> createQualityControl(@RequestBody QualityControl qualityControl) {
        QualityControl createdQualityControl = qualityControlService.createQualityControl(qualityControl);
        return ResponseEntity.status(201).body(createdQualityControl);  // Return status 201 (Created)
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQualityControlById(@PathVariable Long id) {
        try {
            QualityControl qualityControl = qualityControlService.getQualityControlById(id);
            return ResponseEntity.ok(qualityControl);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<QualityControl>> getAllQualityControls() {
        return ResponseEntity.ok(qualityControlService.getAllQualityControls());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQualityControl(@PathVariable Long id, @RequestBody QualityControl updatedQualityControl) {
        try {
            QualityControl qualityControl = qualityControlService.updateQualityControl(id, updatedQualityControl);
            return ResponseEntity.ok(qualityControl);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQualityControl(@PathVariable Long id) {
        try {
            qualityControlService.deleteQualityControl(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }
}
