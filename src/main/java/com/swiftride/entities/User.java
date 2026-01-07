package com.swiftride.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(unique = true,nullable = false)
    String username;
    String password;
    String name;
    String role;
}
