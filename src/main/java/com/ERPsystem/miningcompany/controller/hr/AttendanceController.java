package com.ERPsystem.miningcompany.controller.hr;

import com.ERPsystem.miningcompany.Entity.hr.Attendance;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.hr.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceService.getAllAttendances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttendanceById(@PathVariable Long id) {
        try {
            Attendance attendance = attendanceService.getAttendanceById(id);
            return ResponseEntity.ok(attendance);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send the exception message
        }
    }

    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceService.createAttendance(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendanceDetails) {
        try {
            Attendance updatedAttendance = attendanceService.updateAttendance(id, attendanceDetails);
            return ResponseEntity.ok(updatedAttendance);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send the exception message
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttendance(@PathVariable Long id) {
        try {
            attendanceService.deleteAttendance(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send the exception message
        }
    }

}
