package com.ERPsystem.miningcompany.service.project;

import com.ERPsystem.miningcompany.Entity.project.Project;
import com.ERPsystem.miningcompany.Repository.project.ProjectRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
    }

    public Project updateProject(Long id, Project project) {
        if (projectRepository.existsById(id)) {
            project.setId(id);
            return projectRepository.save(project);
        } else {
            throw new ResourceNotFoundException("Project not found with id " + id);
        }
    }

    public void deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Project not found with id " + id);
        }
    }
}
