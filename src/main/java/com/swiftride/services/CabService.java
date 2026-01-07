package com.swiftride.services;

import com.swiftride.entities.Cab;
import com.swiftride.repositories.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabService {
    @Autowired
    private CabRepository cabRepository;

    // CREATE
    public ResponseEntity<Cab> createCab(Cab cab) {
        Cab savedCab = cabRepository.save(cab);
        return ResponseEntity.status(201).body(savedCab);
    }

    // GET ALL
    public ResponseEntity<List<Cab>> getAllCabs() {
        return ResponseEntity.ok(cabRepository.findAll());
    }

    // GET BY ID
    public ResponseEntity<Cab> getCabById(long id) {
        return cabRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    public ResponseEntity<Cab> updateCab(long id, Cab cab) {
        return cabRepository.findById(id)
                .map(existing -> {
                    existing.setModel(cab.getModel());
                    existing.setLicense(cab.getLicense());
                    existing.setCurrentLocation(cab.getCurrentLocation());
                    Cab updated = cabRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    public ResponseEntity<Void> deleteCab(long id) {
        if (!cabRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cabRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<Cab>> getAvailableCabs() {
        List<Cab> availableCabs = cabRepository.findByIsAvailableTrue();
        return ResponseEntity.ok(availableCabs);
    }

    // Optional: update availability
    public ResponseEntity<Cab> updateCabAvailability(long id, boolean isAvailable) {
        return cabRepository.findById(id)
                .map(cab -> {
                    cab.setAvailable(isAvailable);
                    return ResponseEntity.ok(cabRepository.save(cab));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
