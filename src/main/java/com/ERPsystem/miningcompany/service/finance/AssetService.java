package com.ERPsystem.miningcompany.service.finance;

import com.ERPsystem.miningcompany.Entity.finance.Asset;
import com.ERPsystem.miningcompany.Repository.finance.AssetRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    @Autowired
    AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id " + id));
    }
    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id " + id));

        existingAsset.setAssetName(assetDetails.getAssetName());
        existingAsset.setPurchasePrice(assetDetails.getPurchasePrice());
        existingAsset.setPurchaseDate(assetDetails.getPurchaseDate());
        existingAsset.setDepreciationValue(assetDetails.getDepreciationValue());

        return assetRepository.save(existingAsset);
    }

    public void deleteAsset(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with id " + id));
        assetRepository.delete(asset);
    }
}
