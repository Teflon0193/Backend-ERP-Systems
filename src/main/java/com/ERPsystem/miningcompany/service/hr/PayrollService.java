package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Payroll;
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

    public Payroll createPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }
    public Payroll getPayrollById(Long id) {
        return payrollRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payroll not found with id " + id));
    }

    public Payroll updatePayroll(Long id, Payroll payrollDetails) {
        if (payrollRepository.existsById(id)) {
            payrollDetails.setId(id);
            return payrollRepository.save(payrollDetails);
        } else {
            throw new ResourceNotFoundException("Payroll not found with id " + id);
        }
    }

    public void deletePayroll(Long id) {
        if (payrollRepository.existsById(id)) {
            payrollRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Payroll not found with id " + id);
        }
    }
}
