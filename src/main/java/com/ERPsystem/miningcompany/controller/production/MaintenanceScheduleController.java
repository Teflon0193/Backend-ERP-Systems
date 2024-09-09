package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.MaintenanceSchedule;
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
        return ResponseEntity.ok(createdSchedule);
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceSchedule>> getAllMaintenanceSchedules() {
        List<MaintenanceSchedule> schedules = maintenanceScheduleService.getAllMaintenanceSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceSchedule> getMaintenanceScheduleById(@PathVariable Long id) {
        Optional<MaintenanceSchedule> schedule = maintenanceScheduleService.getMaintenanceScheduleById(id);
        if (schedule.isPresent()) {
            return ResponseEntity.ok(schedule.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceSchedule> updateMaintenanceSchedule(@PathVariable Long id, @RequestBody MaintenanceSchedule updatedSchedule) {
        MaintenanceSchedule schedule = maintenanceScheduleService.updateMaintenanceSchedule(id, updatedSchedule);
        if (schedule != null) {
            return ResponseEntity.ok(schedule);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenanceSchedule(@PathVariable Long id) {
        maintenanceScheduleService.deleteMaintenanceSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
