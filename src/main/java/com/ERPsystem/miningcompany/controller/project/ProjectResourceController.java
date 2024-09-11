package com.ERPsystem.miningcompany.controller.project;

import com.ERPsystem.miningcompany.Entity.project.ProjectResource;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.project.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project-resources")
public class ProjectResourceController  {
    @Autowired
    private ProjectResourceService projectResourceService;

    @PostMapping
    public ResponseEntity<ProjectResource> createProjectResource(@RequestBody ProjectResource projectResource) {
        ProjectResource createdProjectResource = projectResourceService.createProjectResource(projectResource);
        return ResponseEntity.status(201).body(createdProjectResource);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResource>> getAllProjectResources() {
        List<ProjectResource> projectResources = projectResourceService.getAllProjectResources();
        return ResponseEntity.ok(projectResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectResourceById(@PathVariable Long id) {
        try {
            ProjectResource projectResource = projectResourceService.getProjectResourceById(id);
            return ResponseEntity.ok(projectResource);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProjectResource(@PathVariable Long id, @RequestBody ProjectResource projectResource) {
        try {
            ProjectResource updatedProjectResource = projectResourceService.updateProjectResource(id, projectResource);
            return ResponseEntity.ok(updatedProjectResource);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectResource(@PathVariable Long id) {
        try {
            projectResourceService.deleteProjectResource(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
