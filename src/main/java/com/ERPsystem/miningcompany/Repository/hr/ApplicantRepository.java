package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
