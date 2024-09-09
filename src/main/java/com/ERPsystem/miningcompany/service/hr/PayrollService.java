package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Payroll;
import com.ERPsystem.miningcompany.Repository.hr.PayrollRepository;
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
    public Optional<Payroll> getPayrollById(Long id) {
        return payrollRepository.findById(id);
    }

    public Payroll updatePayroll(Long id, Payroll payrollDetails) {
        if (payrollRepository.existsById(id)) {
            payrollDetails.setId(id);
            return payrollRepository.save(payrollDetails);
        } else {
            return null;
        }
    }

    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
