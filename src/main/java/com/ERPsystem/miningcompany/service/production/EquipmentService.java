package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.Equipment;
import com.ERPsystem.miningcompany.Repository.production.EquipmentRepository;
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

    public Optional<Equipment> getEquipmentById(Long id) {
        return equipmentRepository.findById(id);
    }

    public Equipment updateEquipment(Long id, Equipment equipmentDetails) {
        if (equipmentRepository.existsById(id)) {
            equipmentDetails.setId(id);
            return equipmentRepository.save(equipmentDetails);
        } else {
            return null;
        }
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }
}
