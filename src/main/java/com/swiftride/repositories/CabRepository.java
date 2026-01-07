package com.swiftride.repositories;

import com.swiftride.entities.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab,Long> {
    List<Cab> findByIsAvailableTrue();
    Optional<Cab> findFirstByIsAvailableTrue();
    Cab findBydriverId(long id);
}

