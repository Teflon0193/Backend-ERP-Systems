package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.ProductionData;
import com.ERPsystem.miningcompany.Repository.production.ProductionDataRepository;
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

    public Optional<ProductionData> getProductionDataById(Long id) {
        return productionDataRepository.findById(id);
    }

    public Iterable<ProductionData> getAllProductionData() {
        return productionDataRepository.findAll();
    }

    public void deleteProductionData(Long id) {
        productionDataRepository.deleteById(id);
    }

    public ProductionData updateProductionData(Long id, ProductionData updatedProductionData) {
        if (productionDataRepository.existsById(id)) {
            updatedProductionData.setId(id);
            return productionDataRepository.save(updatedProductionData);
        } else {
            return null;
        }
    }
}
