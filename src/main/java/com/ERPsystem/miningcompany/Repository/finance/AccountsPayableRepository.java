package com.ERPsystem.miningcompany.Repository.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsPayable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsPayableRepository extends JpaRepository<AccountsPayable, Long> {
}
