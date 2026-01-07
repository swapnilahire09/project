package com.swiftride.services;

import com.swiftride.dtos.BookingRequest;
import com.swiftride.entities.Cab;
import com.swiftride.entities.Trip;
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
    public Trip createBooing(BookingRequest request){
        Cab cab=cabRepository.findFirstByIsAvailableTrue().orElseThrow(()->new RuntimeException("No drivers available"));
        cab.setAvailable(false);
        cabRepository.save(cab);

        Trip trip=new Trip();
        trip.setDriverId(cab.getDriverId());
        trip.setPassengerId(request.getPassengerId());
        trip.setStatus("ACCEPTED");
        return tripRepository.save(trip);
    }

}
