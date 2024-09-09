package com.ERPsystem.miningcompany.Repository.production;

import com.ERPsystem.miningcompany.Entity.production.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
