package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.EmployeeTraining;
import com.ERPsystem.miningcompany.Repository.hr.EmployeeTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTrainingService {

    @Autowired
    private EmployeeTrainingRepository employeeTrainingRepository;

    // Create a new EmployeeTraining
    public EmployeeTraining createEmployeeTraining(EmployeeTraining employeeTraining) {
        return employeeTrainingRepository.save(employeeTraining);
    }

    // Get all EmployeeTraining records
    public List<EmployeeTraining> getAllEmployeeTrainings() {
        return employeeTrainingRepository.findAll();
    }

    // Get EmployeeTraining by ID
    public Optional<EmployeeTraining> getEmployeeTrainingById(Long id) {
        return employeeTrainingRepository.findById(id);
    }

    // Get all trainings for a specific employee
    public List<EmployeeTraining> getTrainingsByEmployeeId(Long employeeId) {
        return employeeTrainingRepository.findByEmployeeId(employeeId);
    }

    // Get all employees for a specific training
    public List<EmployeeTraining> getEmployeesByTrainingId(Long trainingId) {
        return employeeTrainingRepository.findBySafetyTrainingId(trainingId);
    }

    // Update EmployeeTraining
    public EmployeeTraining updateEmployeeTraining(Long id, EmployeeTraining employeeTrainingDetails) {
        EmployeeTraining employeeTraining = employeeTrainingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeTraining not found with id: " + id));

        employeeTraining.setCompletionStatus(employeeTrainingDetails.getCompletionStatus());
        employeeTraining.setCertificate(employeeTrainingDetails.getCertificate());

        return employeeTrainingRepository.save(employeeTraining);
    }

    // Delete EmployeeTraining
    public void deleteEmployeeTraining(Long id) {
        employeeTrainingRepository.deleteById(id);
    }
}
