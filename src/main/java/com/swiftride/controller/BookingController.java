package com.swiftride.controller;

import com.swiftride.dtos.BookingRequest;
import com.swiftride.entities.Trip;
import com.swiftride.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping()
    public ResponseEntity<Trip> createBooking(@RequestBody BookingRequest request){
        Trip trip= bookingService.createBooing(request);
        return ResponseEntity.ok(trip);
    }
}
