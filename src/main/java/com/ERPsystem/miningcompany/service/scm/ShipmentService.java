package com.ERPsystem.miningcompany.service.scm;

import com.ERPsystem.miningcompany.Entity.scm.Shipment;
import com.ERPsystem.miningcompany.Repository.scm.ShipmentRepository;
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

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Shipment updateShipment(Long id, Shipment shipment) {
        if (shipmentRepository.existsById(id)) {
            shipment.setId(id);
            return shipmentRepository.save(shipment);
        }
        return null;
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

}
