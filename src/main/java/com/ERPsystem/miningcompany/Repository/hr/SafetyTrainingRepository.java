package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.SafetyTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyTrainingRepository extends JpaRepository<SafetyTraining, Long> {
}
