package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Applicant;
import com.ERPsystem.miningcompany.Repository.hr.ApplicantRepository;
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

    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicant(Long id, Applicant applicantDetails) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found for this id :: " + id));

        applicant.setJobPostingId(applicantDetails.getJobPostingId());
        applicant.setName(applicantDetails.getName());
        applicant.setResume(applicantDetails.getResume());
        applicant.setStatus(applicantDetails.getStatus());

        return applicantRepository.save(applicant);
    }

    public void deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found for this id :: " + id));

        applicantRepository.delete(applicant);
    }

}
