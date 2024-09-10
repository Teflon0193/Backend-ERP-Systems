package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.JobPosting;
import com.ERPsystem.miningcompany.Repository.hr.JobPostingRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
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

    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobPosting not found with id " + id));
    }

    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        if (jobPostingRepository.existsById(id)) {
            jobPostingDetails.setId(id);
            return jobPostingRepository.save(jobPostingDetails);
        } else {
            throw new ResourceNotFoundException("JobPosting not found with id " + id);
        }
    }

    public void deleteJobPosting(Long id) {
        if (jobPostingRepository.existsById(id)) {
            jobPostingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("JobPosting not found with id " + id);
        }
    }
}

