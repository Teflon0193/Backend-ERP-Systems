package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
