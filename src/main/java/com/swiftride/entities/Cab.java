package com.swiftride.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long driverId;
    String model;
    String License;
    String currentLocation;
    boolean isAvailable = true;
}
