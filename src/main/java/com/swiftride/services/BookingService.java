package com.swiftride.services;

import com.swiftride.dtos.BookingRequest;
import com.swiftride.entities.Cab;
import com.swiftride.entities.Trip;
import com.swiftride.enums.TripStatus;
import com.swiftride.repositories.CabRepository;
import com.swiftride.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private TripRepository tripRepository;

    @Transactional
    public Trip createBookingRequest(BookingRequest request) {

        Trip trip = new Trip();
        trip.setPassengerId(request.getPassengerId());
        trip.setStatus(TripStatus.REQUESTED);

        return tripRepository.save(trip);
    }
    @Transactional
    public Trip acceptBooking(long tripId) {

        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        if (trip.getStatus() != TripStatus.REQUESTED) {
            throw new RuntimeException("Trip is not in REQUESTED state");
        }

        Cab cab = cabRepository.findFirstByIsAvailableTrue()
                .orElseThrow(() -> new RuntimeException("No drivers available"));

        // assign cab
        cab.setAvailable(false);
        cabRepository.save(cab);

        trip.setDriverId(cab.getDriverId());
        trip.setStatus(TripStatus.ACCEPTED);

        return tripRepository.save(trip);
    }

    @Transactional
    public Trip cancelBooking(long id){
        Trip trip=tripRepository.findById((id)).orElseThrow(()->new RuntimeException("Trip not found"));
        if(trip.getStatus()==TripStatus.CANCELLED ||trip.getStatus()==TripStatus.COMPLETED) throw new RuntimeException("Trip cannot be cancelled");
        trip.setStatus(TripStatus.CANCELLED);
        Cab cab=cabRepository.findBydriverId(trip.getDriverId());
        cab.setAvailable(true);
        cabRepository.save(cab);
        return tripRepository.save(trip);
    }

}
