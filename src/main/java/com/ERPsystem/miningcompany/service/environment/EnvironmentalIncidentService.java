package com.ERPsystem.miningcompany.service.environment;

import com.ERPsystem.miningcompany.Entity.environmental.EnvironmentalIncident;
import com.ERPsystem.miningcompany.Repository.environmental.EnvironmentalIncidentRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvironmentalIncidentService {
    @Autowired
    private EnvironmentalIncidentRepository environmentalIncidentRepository;

    public List<EnvironmentalIncident> getAllEnvironmentalIncidents() {
        return environmentalIncidentRepository.findAll();
    }

    public EnvironmentalIncident getEnvironmentalIncidentById(Long id) {
        return environmentalIncidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalIncident not found for this id :: " + id));
    }

    public EnvironmentalIncident createEnvironmentalIncident(EnvironmentalIncident environmentalIncident) {
        return environmentalIncidentRepository.save(environmentalIncident);
    }

    public EnvironmentalIncident updateEnvironmentalIncident(Long id, EnvironmentalIncident environmentalIncidentDetails) {
        EnvironmentalIncident environmentalIncident = environmentalIncidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalIncident not found for this id :: " + id));

        environmentalIncident.setIncidentDescription(environmentalIncidentDetails.getIncidentDescription());
        environmentalIncident.setIncidentDate(environmentalIncidentDetails.getIncidentDate());
        environmentalIncident.setStatus(environmentalIncidentDetails.getStatus());
        environmentalIncident.setCorrectiveActions(environmentalIncidentDetails.getCorrectiveActions());

        return environmentalIncidentRepository.save(environmentalIncident);
    }

    public void deleteEnvironmentalIncident(Long id) {
        EnvironmentalIncident environmentalIncident = environmentalIncidentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EnvironmentalIncident not found for this id :: " + id));

        environmentalIncidentRepository.delete(environmentalIncident);
    }
}
