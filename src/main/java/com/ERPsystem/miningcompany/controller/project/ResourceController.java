package com.ERPsystem.miningcompany.controller.project;

import com.ERPsystem.miningcompany.Entity.project.Resource;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.project.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return ResponseEntity.status(201).body(createdResource);
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable Long id) {
        try {
            Resource resource = resourceService.getResourceById(id);
            return ResponseEntity.ok(resource);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        try {
            Resource updatedResource = resourceService.updateResource(id, resource);
            return ResponseEntity.ok(updatedResource);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Long id) {
        try {
            resourceService.deleteResource(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
