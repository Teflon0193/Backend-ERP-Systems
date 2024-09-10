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

    public SafetyTraining updateSafetyTraining(Long id, SafetyTraining safetyTrainingDetails) {
        if (safetyTrainingRepository.existsById(id)) {
            safetyTrainingDetails.setId(id);
            return safetyTrainingRepository.save(safetyTrainingDetails);
        } else {
            throw new ResourceNotFoundException("SafetyTraining not found with id " + id);
        }
    }

    public void deleteSafetyTraining(Long id) {
        if (safetyTrainingRepository.existsById(id)) {
            safetyTrainingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("SafetyTraining not found with id " + id);
        }
    }
}
