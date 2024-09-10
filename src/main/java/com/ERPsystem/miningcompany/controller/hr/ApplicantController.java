package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.Applicant;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicantById(@PathVariable Long id) {
        try {
            Applicant applicant = applicantService.getApplicantById(id);
            return ResponseEntity.ok(applicant);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send the exception message
        }
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicantDetails) {
        Applicant updatedApplicant = applicantService.updateApplicant(id, applicantDetails);
        return ResponseEntity.ok(updatedApplicant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
        return ResponseEntity.noContent().build();
    }

}
