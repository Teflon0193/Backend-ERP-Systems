package com.ERPsystem.miningcompany.Repository.project;

import com.ERPsystem.miningcompany.Entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
