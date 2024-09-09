package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.JobPosting;
import com.ERPsystem.miningcompany.Repository.hr.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long id) {
        return jobPostingRepository.findById(id);
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        if (jobPostingRepository.existsById(id)) {
            jobPostingDetails.setId(id);
            return jobPostingRepository.save(jobPostingDetails);
        } else {
            return null;
        }
    }

    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }
}

