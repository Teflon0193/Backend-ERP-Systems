package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.Applicant;
import com.ERPsystem.miningcompany.Entity.hr.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}

