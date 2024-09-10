package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.JobPosting;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {
    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
        return ResponseEntity.status(201).body(createdJobPosting);  // Created status with job posting
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);  // OK status with job postings list
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobPostingById(@PathVariable Long id) {
        try {
            JobPosting jobPosting = jobPostingService.getJobPostingById(id);
            return ResponseEntity.ok(jobPosting);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        try {
            JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPostingDetails);
            return ResponseEntity.ok(updatedJobPosting);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJobPosting(@PathVariable Long id) {
        try {
            jobPostingService.deleteJobPosting(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

}

