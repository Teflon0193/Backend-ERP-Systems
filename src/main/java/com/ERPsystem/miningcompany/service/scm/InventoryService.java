package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Inventory;
import com.ERPsystem.miningcompany.Repository.scm.InventoryRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id " + id));
    }

    public Inventory updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setId(id);
            return inventoryRepository.save(inventory);
        } else {
            throw new ResourceNotFoundException("Inventory not found with id " + id);
        }
    }

    public void deleteInventory(Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Inventory not found with id " + id);
        }
    }

}
