package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.ProductionData;
import com.ERPsystem.miningcompany.Repository.production.ProductionDataRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductionDataService {
    @Autowired
    private ProductionDataRepository productionDataRepository;

    public ProductionData createProductionData(ProductionData productionData) {
        return productionDataRepository.save(productionData);
    }

    public ProductionData getProductionDataById(Long id) {
        return productionDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Production data not found with id " + id));
    }

    public Iterable<ProductionData> getAllProductionData() {
        return productionDataRepository.findAll();
    }

    public void deleteProductionData(Long id) {
        if (productionDataRepository.existsById(id)) {
            productionDataRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Production data not found with id " + id);
        }
    }

    public ProductionData updateProductionData(Long id, ProductionData updatedProductionData) {
        if (productionDataRepository.existsById(id)) {
            updatedProductionData.setId(id);
            return productionDataRepository.save(updatedProductionData);
        } else {
            throw new ResourceNotFoundException("Production data not found with id " + id);
        }
    }
}
