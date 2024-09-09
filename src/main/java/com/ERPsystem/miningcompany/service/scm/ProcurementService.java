package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Procurement;
import com.ERPsystem.miningcompany.Repository.scm.ProcurementRepository;
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

    public Optional<Procurement> getProcurementById(Long id) {
        return procurementRepository.findById(id);
    }

    public Procurement updateProcurement(Long id, Procurement procurement) {
        if (procurementRepository.existsById(id)) {
            procurement.setId(id);
            return procurementRepository.save(procurement);
        }
        return null;
    }

    public void deleteProcurement(Long id) {
        procurementRepository.deleteById(id);
    }

}
