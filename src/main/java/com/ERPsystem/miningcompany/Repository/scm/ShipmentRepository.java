package com.ERPsystem.miningcompany.Repository.scm;

import com.ERPsystem.miningcompany.Entity.scm.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
