package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.SafetyTraining;
import com.ERPsystem.miningcompany.Repository.hr.SafetyTrainingRepository;
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

    public Optional<SafetyTraining> getSafetyTrainingById(Long id) {
        return safetyTrainingRepository.findById(id);
    }

    public SafetyTraining updateSafetyTraining(Long id, SafetyTraining safetyTrainingDetails) {
        if (safetyTrainingRepository.existsById(id)) {
            safetyTrainingDetails.setId(id);
            return safetyTrainingRepository.save(safetyTrainingDetails);
        } else {
            return null;
        }
    }

    public void deleteSafetyTraining(Long id) {
        safetyTrainingRepository.deleteById(id);
    }
}
