package com.ERPsystem.miningcompany.controller.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalIncident;
import com.ERPsystem.miningcompany.service.environment.EnvironmentalIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/environmental-incidents")
public class EnvironmentalIncidentController {
    @Autowired
    private EnvironmentalIncidentService environmentalIncidentService;

    @GetMapping
    public List<EnvironmentalIncident> getAllEnvironmentalIncidents() {
        return environmentalIncidentService.getAllEnvironmentalIncidents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentalIncident> getEnvironmentalIncidentById(@PathVariable Long id) {
        EnvironmentalIncident environmentalIncident = environmentalIncidentService.getEnvironmentalIncidentById(id);
        return ResponseEntity.ok().body(environmentalIncident);
    }

    @PostMapping
    public EnvironmentalIncident createEnvironmentalIncident(@RequestBody EnvironmentalIncident environmentalIncident) {
        return environmentalIncidentService.createEnvironmentalIncident(environmentalIncident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentalIncident> updateEnvironmentalIncident(@PathVariable Long id, @RequestBody EnvironmentalIncident environmentalIncidentDetails) {
        EnvironmentalIncident updatedEnvironmentalIncident = environmentalIncidentService.updateEnvironmentalIncident(id, environmentalIncidentDetails);
        return ResponseEntity.ok(updatedEnvironmentalIncident);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvironmentalIncident(@PathVariable Long id) {
        environmentalIncidentService.deleteEnvironmentalIncident(id);
        return ResponseEntity.noContent().build();
    }
}
