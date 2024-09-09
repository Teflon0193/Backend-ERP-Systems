package com.ERPsystem.miningcompany.Repository.finance;

import com.ERPsystem.miningcompany.Entity.finance.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
}
