package com.swiftride.services;

import com.swiftride.entities.Trip;
import com.swiftride.enums.TripStatus;
import com.swiftride.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingTimeoutService {
    @Value("${booking.timeout.seconds}")
    private long timeoutSeconds;

    @Autowired
    private TripRepository tripRepository;

    @Scheduled(fixedRate = 20000)
    public  void rejectExpiredBookings(){
        LocalDateTime expiryTime=LocalDateTime.now().minusSeconds(timeoutSeconds);
        List<Trip>trips=tripRepository.findByStatusAndCreatedAtBefore(TripStatus.REQUESTED,expiryTime);
        for (Trip i:trips){
            i.setStatus(TripStatus.REJECTED);
        }
        tripRepository.saveAll(trips);
    }
}
