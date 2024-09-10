package com.ERPsystem.miningcompany.service.production;

import com.ERPsystem.miningcompany.Entity.production.QualityControl;
import com.ERPsystem.miningcompany.Repository.production.QualityControlRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QualityControlService {
    @Autowired
    private QualityControlRepository qualityControlRepository;

    public QualityControl createQualityControl(QualityControl qualityControl) {
        return qualityControlRepository.save(qualityControl);
    }

    public QualityControl getQualityControlById(Long id) {
        return qualityControlRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quality control record not found with id " + id));
    }

    public Iterable<QualityControl> getAllQualityControls() {
        return qualityControlRepository.findAll();
    }

    public void deleteQualityControl(Long id) {
        if (qualityControlRepository.existsById(id)) {
            qualityControlRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Quality control record not found with id " + id);
        }
    }

    public QualityControl updateQualityControl(Long id, QualityControl updatedQualityControl) {
        if (qualityControlRepository.existsById(id)) {
            updatedQualityControl.setId(id);
            return qualityControlRepository.save(updatedQualityControl);
        } else {
            throw new ResourceNotFoundException("Quality control record not found with id " + id);
        }
    }

}
