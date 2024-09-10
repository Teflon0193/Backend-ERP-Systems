package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.ProductionData;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.production.ProductionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/production-data")
public class ProductionDataController {
    @Autowired
    private ProductionDataService productionDataService;

    @PostMapping
    public ResponseEntity<ProductionData> createProductionData(@RequestBody ProductionData productionData) {
        ProductionData createdProductionData = productionDataService.createProductionData(productionData);
        return ResponseEntity.status(201).body(createdProductionData);  // Return status 201 (Created)
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductionDataById(@PathVariable Long id) {
        try {
            ProductionData productionData = productionDataService.getProductionDataById(id);
            return ResponseEntity.ok(productionData);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductionData>> getAllProductionData() {
        return ResponseEntity.ok(productionDataService.getAllProductionData());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductionData(@PathVariable Long id, @RequestBody ProductionData updatedProductionData) {
        try {
            ProductionData productionData = productionDataService.updateProductionData(id, updatedProductionData);
            return ResponseEntity.ok(productionData);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductionData(@PathVariable Long id) {
        try {
            productionDataService.deleteProductionData(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());  // Send not found message
        }
    }
}
