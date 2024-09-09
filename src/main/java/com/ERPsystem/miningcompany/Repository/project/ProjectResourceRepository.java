package com.ERPsystem.miningcompany.Repository.project;

import com.ERPsystem.miningcompany.Entity.project.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Long> {
}
