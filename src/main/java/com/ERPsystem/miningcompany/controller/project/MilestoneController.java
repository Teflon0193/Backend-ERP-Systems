package com.ERPsystem.miningcompany.controller.project;

import com.ERPsystem.miningcompany.Entity.project.Milestone;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.project.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {
    @Autowired
    private MilestoneService milestoneService;

    @PostMapping
    public ResponseEntity<Milestone> createMilestone(@RequestBody Milestone milestone) {
        Milestone createdMilestone = milestoneService.createMilestone(milestone);
        return ResponseEntity.status(201).body(createdMilestone);  // Return status 201 (Created)
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMilestoneById(@PathVariable Long id) {
        try {
            Milestone milestone = milestoneService.getMilestoneById(id);
            return ResponseEntity.ok(milestone);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Milestone>> getAllMilestones() {
        return ResponseEntity.ok(milestoneService.getAllMilestones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMilestone(@PathVariable Long id, @RequestBody Milestone updatedMilestone) {
        try {
            Milestone milestone = milestoneService.updateMilestone(id, updatedMilestone);
            return ResponseEntity.ok(milestone);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMilestone(@PathVariable Long id) {
        try {
            milestoneService.deleteMilestone(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

}
