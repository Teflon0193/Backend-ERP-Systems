package com.ERPsystem.miningcompany.controller.project;

import com.ERPsystem.miningcompany.Entity.project.ProjectResource;
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
        return new ResponseEntity<>(createdProjectResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResource>> getAllProjectResources() {
        List<ProjectResource> projectResources = projectResourceService.getAllProjectResources();
        return new ResponseEntity<>(projectResources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResource> getProjectResourceById(@PathVariable Long id) {
        Optional<ProjectResource> projectResource = projectResourceService.getProjectResourceById(id);
        return projectResource.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResource> updateProjectResource(@PathVariable Long id, @RequestBody ProjectResource projectResource) {
        ProjectResource updatedProjectResource = projectResourceService.updateProjectResource(id, projectResource);
        return updatedProjectResource != null ? ResponseEntity.ok(updatedProjectResource) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectResource(@PathVariable Long id) {
        projectResourceService.deleteProjectResource(id);
        return ResponseEntity.noContent().build();
    }

}
