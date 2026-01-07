package com.swiftride.services;

import com.swiftride.entities.Trip;
import com.swiftride.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    // CREATE
    public ResponseEntity<Trip> createTrip(Trip trip) {
        Trip savedTrip = tripRepository.save(trip);
        return ResponseEntity.status(201).body(savedTrip);
    }

    // GET ALL
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripRepository.findAll());
    }

    // GET BY ID
    public ResponseEntity<Trip> getTripById(long id) {
        return tripRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    public ResponseEntity<Trip> updateTrip(long id, Trip trip) {
        return tripRepository.findById(id)
                .map(existing -> {
                    existing.setPassengerId(trip.getPassengerId());
                    existing.setDriverId(trip.getDriverId());
                    existing.setStatus(trip.getStatus());
                    Trip updatedTrip = tripRepository.save(existing);
                    return ResponseEntity.ok(updatedTrip);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    public ResponseEntity<Void> deleteTrip(long id) {
        if (!tripRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tripRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
