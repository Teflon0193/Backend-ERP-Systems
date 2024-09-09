package com.ERPsystem.miningcompany.Repository.scm;

import com.ERPsystem.miningcompany.Entity.scm.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
