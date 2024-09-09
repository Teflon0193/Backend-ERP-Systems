package com.ERPsystem.miningcompany.Repository.environmental;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentalIncidentRepository extends JpaRepository<EnvironmentalIncident, Long> {
}
