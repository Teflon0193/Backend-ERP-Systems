package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.MinePlan;
import com.ERPsystem.miningcompany.Repository.production.MinePlanRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MinePlanService {
    @Autowired
    private MinePlanRepository minePlanRepository;

    public MinePlan createMinePlan(MinePlan minePlan) {
        return minePlanRepository.save(minePlan);
    }

    public MinePlan getMinePlanById(Long id) {
        return minePlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mine plan not found with id " + id));
    }

    public Iterable<MinePlan> getAllMinePlans() {
        return minePlanRepository.findAll();
    }

    public MinePlan updateMinePlan(Long id, MinePlan updatedMinePlan) {
        if (minePlanRepository.existsById(id)) {
            updatedMinePlan.setId(id);
            return minePlanRepository.save(updatedMinePlan);
        } else {
            throw new ResourceNotFoundException("Mine plan not found with id " + id);
        }
    }

    public void deleteMinePlan(Long id) {
        if (minePlanRepository.existsById(id)) {
            minePlanRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Mine plan not found with id " + id);
        }
    }



}
