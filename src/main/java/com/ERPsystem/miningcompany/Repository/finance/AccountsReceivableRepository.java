package com.ERPsystem.miningcompany.Repository.finance;

import com.ERPsystem.miningcompany.Entity.finance.AccountsReceivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsReceivableRepository  extends JpaRepository<AccountsReceivable, Long> {
}
