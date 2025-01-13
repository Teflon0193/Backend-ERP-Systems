package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.EmployeeTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeTrainingRepository extends JpaRepository<EmployeeTraining, Long> {
    List<EmployeeTraining> findByEmployeeId(Long employeeId);
    List<EmployeeTraining> findBySafetyTrainingId(Long trainingId);
}
