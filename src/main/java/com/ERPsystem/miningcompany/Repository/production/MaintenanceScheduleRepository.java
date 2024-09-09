package com.ERPsystem.miningcompany.Repository.production;

import com.ERPsystem.miningcompany.Entity.production.MaintenanceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceScheduleRepository extends JpaRepository<MaintenanceSchedule, Long> {
}
