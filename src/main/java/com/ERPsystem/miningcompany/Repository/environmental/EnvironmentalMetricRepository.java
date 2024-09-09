package com.ERPsystem.miningcompany.Repository.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalMetricRepository extends JpaRepository<EnvironmentalMetric, Long> {
}
