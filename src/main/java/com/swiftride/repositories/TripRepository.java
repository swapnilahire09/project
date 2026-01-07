package com.swiftride.repositories;

import com.swiftride.entities.Trip;
import com.swiftride.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findByPassengerId(long passengerId);

    List<Trip> findByDriverId(long driverId);

    List<Trip> findByStatus(String status);

    List<Trip> findByStatusAndCreatedAtBefore(TripStatus status, LocalDateTime time);
}
