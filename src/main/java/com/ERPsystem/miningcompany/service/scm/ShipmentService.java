package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Shipment;
import com.ERPsystem.miningcompany.Repository.scm.ShipmentRepository;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id " + id));
    }

    public Shipment updateShipment(Long id, Shipment shipment) {
        if (shipmentRepository.existsById(id)) {
            shipment.setId(id);
            return shipmentRepository.save(shipment);
        } else {
            throw new ResourceNotFoundException("Shipment not found with id " + id);
        }
    }

    public void deleteShipment(Long id) {
        if (shipmentRepository.existsById(id)) {
            shipmentRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Shipment not found with id " + id);
        }
    }

}
