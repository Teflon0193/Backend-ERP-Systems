package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.Attendance;
import com.ERPsystem.miningcompany.Entity.hr.Employee;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.AttendanceService;
import com.ERPsystem.miningcompany.service.hr.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    // Retrieve all employees with their attendance records
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendanceRecords() {
        return ResponseEntity.ok(attendanceService.getAllAttendanceRecords());
    }

    // Add a new attendance record for an employee
    @PostMapping("/{employeeId}")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance, @PathVariable Long employeeId) {
        return ResponseEntity.ok(attendanceService.addAttendance(attendance, employeeId));
    }

    // Update an existing attendance record
    @PutMapping("/{attendanceId}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long attendanceId, @RequestBody Attendance updatedAttendance) {
        Attendance attendance = attendanceService.updateAttendance(attendanceId, updatedAttendance);
        return ResponseEntity.ok(attendance);
    }

    // Delete an attendance record
    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.ok("Attendance record deleted successfully.");
    }

}
