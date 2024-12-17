package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Attendance;
import com.ERPsystem.miningcompany.Entity.hr.Employee;
import com.ERPsystem.miningcompany.Repository.hr.AttendanceRepository;
import com.ERPsystem.miningcompany.Repository.hr.EmployeeRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    // Retrieve all employees with their attendance records
    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    // create an attendance record
    public Attendance addAttendance(Attendance attendance, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found!"));
        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }


    public Attendance updateAttendance(Long attendanceId, Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + attendanceId));

        // Update fields
        existingAttendance.setDate(updatedAttendance.getDate());
        existingAttendance.setShift(updatedAttendance.getShift());
        existingAttendance.setStartTime(updatedAttendance.getStartTime());
        existingAttendance.setRequiredTime(updatedAttendance.getRequiredTime());
        existingAttendance.setActualTime(updatedAttendance.getActualTime());
        existingAttendance.setLateStatus(updatedAttendance.getLateStatus());

        return attendanceRepository.save(existingAttendance);
    }


    public void deleteAttendance(Long attendanceId) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + attendanceId));
        attendanceRepository.delete(attendance);
    }
}
