package com.ERPsystem.miningcompany.Repository.project;

import com.ERPsystem.miningcompany.Entity.project.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
