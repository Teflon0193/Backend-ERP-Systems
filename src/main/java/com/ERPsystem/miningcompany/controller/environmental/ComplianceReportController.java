package com.ERPsystem.miningcompany.controller.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.ComplianceReport;
import com.ERPsystem.miningcompany.service.environment.ComplianceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance-reports")
public class ComplianceReportController {
    @Autowired
    private ComplianceReportService complianceReportService;

    @GetMapping
    public List<ComplianceReport> getAllComplianceReports() {
        return complianceReportService.getAllComplianceReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceReport> getComplianceReportById(@PathVariable Long id) {
        ComplianceReport complianceReport = complianceReportService.getComplianceReportById(id);
        return ResponseEntity.ok().body(complianceReport);
    }

    @PostMapping
    public ComplianceReport createComplianceReport(@RequestBody ComplianceReport complianceReport) {
        return complianceReportService.createComplianceReport(complianceReport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplianceReport> updateComplianceReport(@PathVariable Long id, @RequestBody ComplianceReport complianceReportDetails) {
        ComplianceReport updatedComplianceReport = complianceReportService.updateComplianceReport(id, complianceReportDetails);
        return ResponseEntity.ok(updatedComplianceReport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplianceReport(@PathVariable Long id) {
        complianceReportService.deleteComplianceReport(id);
        return ResponseEntity.noContent().build();
    }
}
