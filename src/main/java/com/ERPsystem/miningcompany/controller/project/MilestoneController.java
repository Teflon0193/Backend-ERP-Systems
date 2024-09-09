package com.ERPsystem.miningcompany.controller.project;

import com.ERPsystem.miningcompany.Entity.project.Milestone;
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
        return ResponseEntity.ok(createdMilestone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Milestone> getMilestoneById(@PathVariable Long id) {
        Optional<Milestone> milestone = milestoneService.getMilestoneById(id);
        return milestone.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Milestone>> getAllMilestones() {
        return ResponseEntity.ok(milestoneService.getAllMilestones());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Milestone> updateMilestone(@PathVariable Long id, @RequestBody Milestone updatedMilestone) {
        Milestone milestone = milestoneService.updateMilestone(id, updatedMilestone);
        if (milestone != null) {
            return ResponseEntity.ok(milestone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMilestone(@PathVariable Long id) {
        milestoneService.deleteMilestone(id);
        return ResponseEntity.noContent().build();
    }

}
