package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.QualityControl;
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
        return ResponseEntity.ok(createdQualityControl);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualityControl> getQualityControlById(@PathVariable Long id) {
        Optional<QualityControl> qualityControl = qualityControlService.getQualityControlById(id);
        return qualityControl.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<QualityControl>> getAllQualityControls() {
        return ResponseEntity.ok(qualityControlService.getAllQualityControls());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QualityControl> updateQualityControl(@PathVariable Long id, @RequestBody QualityControl updatedQualityControl) {
        QualityControl qualityControl = qualityControlService.updateQualityControl(id, updatedQualityControl);
        if (qualityControl != null) {
            return ResponseEntity.ok(qualityControl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualityControl(@PathVariable Long id) {
        qualityControlService.deleteQualityControl(id);
        return ResponseEntity.noContent().build();
    }
}
