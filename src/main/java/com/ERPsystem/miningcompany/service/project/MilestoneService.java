package com.ERPsystem.miningcompany.service.project;

import com.ERPsystem.miningcompany.Entity.project.Milestone;
import com.ERPsystem.miningcompany.Repository.project.MilestoneRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MilestoneService {
    @Autowired
    private MilestoneRepository milestoneRepository;

    public Milestone createMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    public Milestone getMilestoneById(Long id) {
        return milestoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Milestone not found with id " + id));
    }

    public Iterable<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    public void deleteMilestone(Long id) {
        if (milestoneRepository.existsById(id)) {
            milestoneRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Milestone not found with id " + id);
        }
    }

    public Milestone updateMilestone(Long id, Milestone updatedMilestone) {
        if (milestoneRepository.existsById(id)) {
            updatedMilestone.setId(id);
            return milestoneRepository.save(updatedMilestone);
        } else {
            throw new ResourceNotFoundException("Milestone not found with id " + id);
        }
    }

}
