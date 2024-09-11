package com.ERPsystem.miningcompany.controller.scm;

import com.ERPsystem.miningcompany.Entity.scm.Inventory;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.scm.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory createdInventory = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(createdInventory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventories = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInventoryById(@PathVariable Long id) {
        try {
            Inventory inventory = inventoryService.getInventoryById(id);
            return ResponseEntity.ok(inventory);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        try {
            Inventory updatedInventory = inventoryService.updateInventory(id, inventory);
            return ResponseEntity.ok(updatedInventory);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInventory(@PathVariable Long id) {
        try {
            inventoryService.deleteInventory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
