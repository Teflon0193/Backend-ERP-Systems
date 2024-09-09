package com.ERPsystem.miningcompany.controller.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalMetric;
import com.ERPsystem.miningcompany.service.environment.EnvironmentalMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/environmental-metrics")
public class EnvironmentalMetricController {
    @Autowired
    private EnvironmentalMetricService environmentalMetricService;

    @GetMapping
    public List<EnvironmentalMetric> getAllEnvironmentalMetrics() {
        return environmentalMetricService.getAllEnvironmentalMetrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalMetric> getEnvironmentalMetricById(@PathVariable Long id) {
        EnvironmentalMetric environmentalMetric = environmentalMetricService.getEnvironmentalMetricById(id)
                .orElseThrow(() -> new RuntimeException("EnvironmentalMetric not found for this id :: " + id));
        return ResponseEntity.ok().body(environmentalMetric);
    }

    @PostMapping
    public EnvironmentalMetric createEnvironmentalMetric(@RequestBody EnvironmentalMetric environmentalMetric) {
        return environmentalMetricService.createEnvironmentalMetric(environmentalMetric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalMetric> updateEnvironmentalMetric(@PathVariable Long id, @RequestBody EnvironmentalMetric environmentalMetricDetails) {
        EnvironmentalMetric updatedEnvironmentalMetric = environmentalMetricService.updateEnvironmentalMetric(id, environmentalMetricDetails);
        return ResponseEntity.ok(updatedEnvironmentalMetric);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironmentalMetric(@PathVariable Long id) {
        environmentalMetricService.deleteEnvironmentalMetric(id);
        return ResponseEntity.noContent().build();
    }
}
