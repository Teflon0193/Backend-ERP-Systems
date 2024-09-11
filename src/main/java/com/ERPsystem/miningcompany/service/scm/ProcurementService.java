package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Procurement;
import com.ERPsystem.miningcompany.Repository.scm.ProcurementRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcurementService {
    @Autowired
    private ProcurementRepository procurementRepository;

    public Procurement createProcurement(Procurement procurement) {
        return procurementRepository.save(procurement);
    }

    public List<Procurement> getAllProcurements() {
        return procurementRepository.findAll();
    }

    public Procurement getProcurementById(Long id) {
        return procurementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Procurement not found with id " + id));
    }

    public Procurement updateProcurement(Long id, Procurement procurement) {
        if (procurementRepository.existsById(id)) {
            procurement.setId(id);
            return procurementRepository.save(procurement);
        } else {
            throw new ResourceNotFoundException("Procurement not found with id " + id);
        }
    }

    public void deleteProcurement(Long id) {
        if (procurementRepository.existsById(id)) {
            procurementRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Procurement not found with id " + id);
        }
    }

}
