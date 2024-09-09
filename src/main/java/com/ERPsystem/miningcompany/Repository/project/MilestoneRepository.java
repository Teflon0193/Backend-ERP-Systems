package com.ERPsystem.miningcompany.Repository.project;

import com.ERPsystem.miningcompany.Entity.project.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
