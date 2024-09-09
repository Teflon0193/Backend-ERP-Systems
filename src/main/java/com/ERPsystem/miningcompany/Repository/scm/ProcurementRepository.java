package com.ERPsystem.miningcompany.Repository.scm;

import com.ERPsystem.miningcompany.Entity.scm.Procurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcurementRepository extends JpaRepository<Procurement, Long> {
}
