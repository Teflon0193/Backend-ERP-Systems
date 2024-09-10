package com.ERPsystem.miningcompany.service.environment;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalMetric;
import com.ERPsystem.miningcompany.Repository.environmental.EnvironmentalMetricRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentalMetricService {
    @Autowired
    private EnvironmentalMetricRepository environmentalMetricRepository;

    public List<EnvironmentalMetric> getAllEnvironmentalMetrics() {
        return environmentalMetricRepository.findAll();
    }

    public EnvironmentalMetric getEnvironmentalMetricById(Long id) {
        return environmentalMetricRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalMetric not found for this id :: " + id));
    }

    public EnvironmentalMetric createEnvironmentalMetric(EnvironmentalMetric environmentalMetric) {
        return environmentalMetricRepository.save(environmentalMetric);
    }

    public EnvironmentalMetric updateEnvironmentalMetric(Long id, EnvironmentalMetric environmentalMetricDetails) {
        EnvironmentalMetric environmentalMetric = environmentalMetricRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalMetric not found for this id :: " + id));

        environmentalMetric.setMetricName(environmentalMetricDetails.getMetricName());
        environmentalMetric.setValue(environmentalMetricDetails.getValue());
        environmentalMetric.setTimestamp(environmentalMetricDetails.getTimestamp());
        environmentalMetric.setUnit(environmentalMetricDetails.getUnit());

        return environmentalMetricRepository.save(environmentalMetric);
    }

    public void deleteEnvironmentalMetric(Long id) {
        EnvironmentalMetric environmentalMetric = environmentalMetricRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalMetric not found for this id :: " + id));

        environmentalMetricRepository.delete(environmentalMetric);
    }
}
