package com.swiftride.controller;

import com.swiftride.entities.Trip;
import com.swiftride.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable long id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable long id,
            @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable long id) {
        return tripService.deleteTrip(id);
    }
}
