package com.ERPsystem.miningcompany.service.project;

import com.ERPsystem.miningcompany.Entity.project.Resource;
import com.ERPsystem.miningcompany.Repository.project.ResourceRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id " + id));
    }

    public Resource updateResource(Long id, Resource resource) {
        if (resourceRepository.existsById(id)) {
            resource.setId(id);
            return resourceRepository.save(resource);
        } else {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }
    }

    public void deleteResource(Long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }
    }
}
