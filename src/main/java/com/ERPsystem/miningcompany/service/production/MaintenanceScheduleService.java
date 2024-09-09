package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.MaintenanceSchedule;
import com.ERPsystem.miningcompany.Repository.production.MaintenanceScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceScheduleService {
    @Autowired
    private MaintenanceScheduleRepository maintenanceScheduleRepository;

    public MaintenanceSchedule createMaintenanceSchedule(MaintenanceSchedule maintenanceSchedule) {
        return maintenanceScheduleRepository.save(maintenanceSchedule);
    }

    public List<MaintenanceSchedule> getAllMaintenanceSchedules() {
        return maintenanceScheduleRepository.findAll();
    }

    public Optional<MaintenanceSchedule> getMaintenanceScheduleById(Long id) {
        return maintenanceScheduleRepository.findById(id);
    }

    public MaintenanceSchedule updateMaintenanceSchedule(Long id, MaintenanceSchedule updatedSchedule) {
        if (maintenanceScheduleRepository.existsById(id)) {
            updatedSchedule.setId(id);
            return maintenanceScheduleRepository.save(updatedSchedule);
        }
        return null;
    }

    public void deleteMaintenanceSchedule(Long id) {
        maintenanceScheduleRepository.deleteById(id);
    }
}
