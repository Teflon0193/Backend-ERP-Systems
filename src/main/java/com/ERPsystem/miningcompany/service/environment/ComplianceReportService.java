package com.ERPsystem.miningcompany.service.environment;

import com.ERPsystem.miningcompany.Entity.environmental.ComplianceReport;
import com.ERPsystem.miningcompany.Repository.environmental.ComplianceReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceReportService {
    @Autowired
    private ComplianceReportRepository complianceReportRepository;

    public List<ComplianceReport> getAllComplianceReports() {
        return complianceReportRepository.findAll();
    }

    public Optional<ComplianceReport> getComplianceReportById(Long id) {
        return complianceReportRepository.findById(id);
    }

    public ComplianceReport createComplianceReport(ComplianceReport complianceReport) {
        return complianceReportRepository.save(complianceReport);
    }

    public ComplianceReport updateComplianceReport(Long id, ComplianceReport complianceReportDetails) {
        ComplianceReport complianceReport = complianceReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComplianceReport not found for this id :: " + id));

        complianceReport.setReportName(complianceReportDetails.getReportName());
        complianceReport.setReportDate(complianceReportDetails.getReportDate());
        complianceReport.setContent(complianceReportDetails.getContent());

        return complianceReportRepository.save(complianceReport);
    }

    public void deleteComplianceReport(Long id) {
        ComplianceReport complianceReport = complianceReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ComplianceReport not found for this id :: " + id));

        complianceReportRepository.delete(complianceReport);
    }

}

