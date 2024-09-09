package com.ERPsystem.miningcompany.service.project;

import com.ERPsystem.miningcompany.Entity.project.ProjectResource;
import com.ERPsystem.miningcompany.Repository.project.ProjectResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceService {
    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    public ProjectResource createProjectResource(ProjectResource projectResource) {
        return projectResourceRepository.save(projectResource);
    }

    public List<ProjectResource> getAllProjectResources() {
        return projectResourceRepository.findAll();
    }

    public Optional<ProjectResource> getProjectResourceById(Long id) {
        return projectResourceRepository.findById(id);
    }

    public ProjectResource updateProjectResource(Long id, ProjectResource projectResource) {
        if (projectResourceRepository.existsById(id)) {
            projectResource.setId(id);
            return projectResourceRepository.save(projectResource);
        }
        return null;
    }

    public void deleteProjectResource(Long id) {
        projectResourceRepository.deleteById(id);
    }
}
