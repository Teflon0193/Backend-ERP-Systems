package com.ERPsystem.miningcompany.controller.production;

import com.ERPsystem.miningcompany.Entity.production.ProductionData;
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
        return ResponseEntity.ok(createdProductionData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductionData> getProductionDataById(@PathVariable Long id) {
        Optional<ProductionData> productionData = productionDataService.getProductionDataById(id);
        return productionData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductionData>> getAllProductionData() {
        return ResponseEntity.ok(productionDataService.getAllProductionData());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionData> updateProductionData(@PathVariable Long id, @RequestBody ProductionData updatedProductionData) {
        ProductionData productionData = productionDataService.updateProductionData(id, updatedProductionData);
        if (productionData != null) {
            return ResponseEntity.ok(productionData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductionData(@PathVariable Long id) {
        productionDataService.deleteProductionData(id);
        return ResponseEntity.noContent().build();
    }
}
