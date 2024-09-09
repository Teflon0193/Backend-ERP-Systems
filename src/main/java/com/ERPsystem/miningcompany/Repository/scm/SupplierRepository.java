package com.ERPsystem.miningcompany.Repository.scm;

import com.ERPsystem.miningcompany.Entity.scm.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
