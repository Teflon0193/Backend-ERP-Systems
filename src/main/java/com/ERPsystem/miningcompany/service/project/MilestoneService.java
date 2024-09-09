package com.ERPsystem.miningcompany.service.project;

import com.ERPsystem.miningcompany.Entity.project.Milestone;
import com.ERPsystem.miningcompany.Repository.project.MilestoneRepository;
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

    public Optional<Milestone> getMilestoneById(Long id) {
        return milestoneRepository.findById(id);
    }

    public Iterable<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    public void deleteMilestone(Long id) {
        milestoneRepository.deleteById(id);
    }

    public Milestone updateMilestone(Long id, Milestone updatedMilestone) {
        if (milestoneRepository.existsById(id)) {
            updatedMilestone.setId(id);
            return milestoneRepository.save(updatedMilestone);
        } else {
            return null;
        }
    }

}
