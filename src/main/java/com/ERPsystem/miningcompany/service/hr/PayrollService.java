package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Employee;
import com.ERPsystem.miningcompany.Entity.hr.Payroll;
import com.ERPsystem.miningcompany.Repository.hr.EmployeeRepository;
import com.ERPsystem.miningcompany.Repository.hr.PayrollRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new payroll record
    public Payroll createPayroll(Payroll payroll, Long employeeId) {
        // Fetch the employee from the database
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        // Set the employee in the payroll
        payroll.setEmployee(employee);

        // Calculate the total
        payroll.setTotal(payroll.getBaseSalary() + payroll.getCommissions() - payroll.getPenalties() + payroll.getBonuses());

        // Save the payroll
        return payrollRepository.save(payroll);
    }

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }
    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found with id " + id));
    }

    // Get payroll records for a specific month
    public List<Payroll> getPayrollsByMonth(String month) {
        return payrollRepository.findByMonth(month);
    }

    // Update a payroll record
    public Payroll updatePayroll(Long id, Payroll updatedPayroll) {
        Optional<Payroll> existingPayroll = payrollRepository.findById(id);
        if (existingPayroll.isPresent()) {
            Payroll payroll = existingPayroll.get();
            payroll.setBaseSalary(updatedPayroll.getBaseSalary());
            payroll.setCommissions(updatedPayroll.getCommissions());
            payroll.setPenalties(updatedPayroll.getPenalties());
            payroll.setBonuses(updatedPayroll.getBonuses());
            payroll.setMonth(updatedPayroll.getMonth());
            payroll.setTotal(calculateTotal(updatedPayroll));
            return payrollRepository.save(payroll);
        } else {
            throw new RuntimeException("Payroll with ID " + id + " not found");
        }
    }

    // Delete a payroll record
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }

    // Helper method to calculate total
    private double calculateTotal(Payroll payroll) {
        double baseSalary = payroll.getBaseSalary() != null ? payroll.getBaseSalary() : 0.0;
        double commissions = payroll.getCommissions() != null ? payroll.getCommissions() : 0.0;
        double penalties = payroll.getPenalties() != null ? payroll.getPenalties() : 0.0;
        double bonuses = payroll.getBonuses() != null ? payroll.getBonuses() : 0.0;
        return baseSalary + commissions - penalties + bonuses;
    }
}
