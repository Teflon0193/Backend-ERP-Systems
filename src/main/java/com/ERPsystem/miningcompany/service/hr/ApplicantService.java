package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Applicant;
import com.ERPsystem.miningcompany.Repository.hr.ApplicantRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + id));
    }

    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicant(Long id, Applicant applicantDetails) {
        Applicant existingApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + id));

        existingApplicant.setJobPostingId(applicantDetails.getJobPostingId());
        existingApplicant.setName(applicantDetails.getName());
        existingApplicant.setResume(applicantDetails.getResume());
        existingApplicant.setStatus(applicantDetails.getStatus());

        return applicantRepository.save(existingApplicant);
    }
    public void deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + id));
        applicantRepository.delete(applicant);
    }

}
