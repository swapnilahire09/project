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

    @PostMapping
    public ResponseEntity<Trip> createBooking(@RequestBody BookingRequest request) {
        return ResponseEntity.ok(bookingService.createBookingRequest(request));
    }
    @PutMapping("/{tripId}/accept")
    public ResponseEntity<Trip> acceptBooking(@PathVariable long tripId) {
        return ResponseEntity.ok(bookingService.acceptBooking(tripId));
    }
    @PostMapping("/{tripId}/cancel")
    public ResponseEntity<Trip> cancelBooking(@PathVariable long id){
        Trip tripDetails= bookingService.cancelBooking(id);
        return ResponseEntity.ok(tripDetails);
    }
}
