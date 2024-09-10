package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.MaintenanceSchedule;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.production.MaintenanceScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance-schedules")
public class MaintenanceScheduleController {
    @Autowired
    private MaintenanceScheduleService maintenanceScheduleService;

    @PostMapping
    public ResponseEntity<MaintenanceSchedule> createMaintenanceSchedule(@RequestBody MaintenanceSchedule maintenanceSchedule) {
        MaintenanceSchedule createdSchedule = maintenanceScheduleService.createMaintenanceSchedule(maintenanceSchedule);
        return ResponseEntity.status(201).body(createdSchedule);  // Created status with schedule
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceSchedule>> getAllMaintenanceSchedules() {
        List<MaintenanceSchedule> schedules = maintenanceScheduleService.getAllMaintenanceSchedules();
        return ResponseEntity.ok(schedules);  // OK status with schedule list
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceScheduleById(@PathVariable Long id) {
        try {
            MaintenanceSchedule schedule = maintenanceScheduleService.getMaintenanceScheduleById(id);
            return ResponseEntity.ok(schedule);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMaintenanceSchedule(@PathVariable Long id, @RequestBody MaintenanceSchedule updatedSchedule) {
        try {
            MaintenanceSchedule schedule = maintenanceScheduleService.updateMaintenanceSchedule(id, updatedSchedule);
            return ResponseEntity.ok(schedule);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaintenanceSchedule(@PathVariable Long id) {
        try {
            maintenanceScheduleService.deleteMaintenanceSchedule(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send exception message
        }
    }
}
