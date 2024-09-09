package com.ERPsystem.miningcompany.Repository.hr;

import com.ERPsystem.miningcompany.Entity.hr.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
