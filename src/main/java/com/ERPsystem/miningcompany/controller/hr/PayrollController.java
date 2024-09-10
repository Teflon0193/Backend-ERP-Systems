package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.Payroll;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;

    @PostMapping
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll createdPayroll = payrollService.createPayroll(payroll);
        return ResponseEntity.status(201).body(createdPayroll);  // Created status with payroll
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return ResponseEntity.ok(payrolls);  // OK status with payrolls list
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayrollById(@PathVariable Long id) {
        try {
            Payroll payroll = payrollService.getPayrollById(id);
            return ResponseEntity.ok(payroll);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayroll(@PathVariable Long id, @RequestBody Payroll payrollDetails) {
        try {
            Payroll updatedPayroll = payrollService.updatePayroll(id, payrollDetails);
            return ResponseEntity.ok(updatedPayroll);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayroll(@PathVariable Long id) {
        try {
            payrollService.deletePayroll(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

}
