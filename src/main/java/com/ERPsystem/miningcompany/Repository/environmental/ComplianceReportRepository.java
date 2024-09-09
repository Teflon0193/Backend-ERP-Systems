package com.ERPsystem.miningcompany.Repository.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.ComplianceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceReportRepository extends JpaRepository<ComplianceReport, Long> {
}
