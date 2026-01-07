package com.swiftride.entities;

import com.swiftride.enums.TripStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long passengerId;
    private long driverId;
    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private LocalDateTime createdAt;

}
