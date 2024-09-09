package com.ERPsystem.miningcompany.Repository.finance;

import com.ERPsystem.miningcompany.Entity.finance.GeneralLedger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GeneralLedgerRepository extends JpaRepository<GeneralLedger, Long> {
}
