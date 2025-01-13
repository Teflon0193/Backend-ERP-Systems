package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.SafetyTraining;
import com.ERPsystem.miningcompany.Repository.hr.SafetyTrainingRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SafetyTrainingService {
    @Autowired
    private SafetyTrainingRepository safetyTrainingRepository;

    public SafetyTraining createSafetyTraining(SafetyTraining safetyTraining) {
        return safetyTrainingRepository.save(safetyTraining);
    }

    public List<SafetyTraining> getAllSafetyTrainings() {
        return safetyTrainingRepository.findAll();
    }

    public SafetyTraining getSafetyTrainingById(Long id) {
        return safetyTrainingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SafetyTraining not found with id " + id));
    }

    // Update an existing safety training
    public SafetyTraining updateSafetyTraining(Long id, SafetyTraining safetyTrainingDetails) {
        SafetyTraining safetyTraining = safetyTrainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Safety Training not found with id: " + id));

        safetyTraining.setTraining_name(safetyTrainingDetails.getTraining_name());
        safetyTraining.setStartDate(safetyTrainingDetails.getStartDate());
        safetyTraining.setEndDate(safetyTrainingDetails.getEndDate());
        safetyTraining.setDuration(safetyTrainingDetails.getDuration());
        safetyTraining.setStatus(safetyTrainingDetails.getStatus());
        safetyTraining.setCertificate(safetyTrainingDetails.getCertificate());

        return safetyTrainingRepository.save(safetyTraining);
    }

    public void deleteSafetyTraining(Long id) {
        if (safetyTrainingRepository.existsById(id)) {
            safetyTrainingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("SafetyTraining not found with id " + id);
        }
    }
}
