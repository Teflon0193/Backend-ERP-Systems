package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.Equipment;
import com.ERPsystem.miningcompany.Repository.production.EquipmentRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipment not found with id " + id));
    }

    public Equipment updateEquipment(Long id, Equipment equipmentDetails) {
        if (equipmentRepository.existsById(id)) {
            equipmentDetails.setId(id);
            return equipmentRepository.save(equipmentDetails);
        } else {
            throw new ResourceNotFoundException("Equipment not found with id " + id);
        }
    }

    public void deleteEquipment(Long id) {
        if (equipmentRepository.existsById(id)) {
            equipmentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Equipment not found with id " + id);
        }
    }
}
