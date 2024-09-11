package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Supplier;
import com.ERPsystem.miningcompany.Repository.scm.SupplierRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + id));
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        if (supplierRepository.existsById(id)) {
            supplier.setId(id);
            return supplierRepository.save(supplier);
        } else {
            throw new ResourceNotFoundException("Supplier not found with id " + id);
        }
    }

    public void deleteSupplier(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Supplier not found with id " + id);
        }
    }

}
