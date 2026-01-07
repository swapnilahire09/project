package com.swiftride.repositories;

import com.swiftride.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();
    Optional<User> findByUsername(String username);
}
