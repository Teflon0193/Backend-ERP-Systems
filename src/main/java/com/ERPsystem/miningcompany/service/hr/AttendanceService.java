package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Attendance;
import com.ERPsystem.miningcompany.Repository.hr.AttendanceRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found for this id :: " + id));
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found for this id :: " + id));

        attendance.setEmployeeId(attendanceDetails.getEmployeeId());
        attendance.setDate(attendanceDetails.getDate());
        attendance.setPresent(attendanceDetails.getPresent());
        attendance.setHoursWorked(attendanceDetails.getHoursWorked());

        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found for this id :: " + id));

        attendanceRepository.delete(attendance);
    }
}
