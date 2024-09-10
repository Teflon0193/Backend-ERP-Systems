package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Employee;
import com.ERPsystem.miningcompany.Repository.hr.EmployeeRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        if (employeeRepository.existsById(id)) {
            employeeDetails.setId(id);
            return employeeRepository.save(employeeDetails);
        } else {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }
    }
}
