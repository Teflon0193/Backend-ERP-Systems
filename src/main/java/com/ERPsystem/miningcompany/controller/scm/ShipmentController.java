package com.ERPsystem.miningcompany.controller.scm;

import com.ERPsystem.miningcompany.Entity.scm.Shipment;
import com.ERPsystem.miningcompany.controller.ResourceNotFoundException;
import com.ERPsystem.miningcompany.service.scm.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        Shipment createdShipment = shipmentService.createShipment(shipment);
        return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return new ResponseEntity<>(shipments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShipmentById(@PathVariable Long id) {
        try {
            Shipment shipment = shipmentService.getShipmentById(id);
            return ResponseEntity.ok(shipment);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShipment(@PathVariable Long id, @RequestBody Shipment shipment) {
        try {
            Shipment updatedShipment = shipmentService.updateShipment(id, shipment);
            return ResponseEntity.ok(updatedShipment);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable Long id) {
        try {
            shipmentService.deleteShipment(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
