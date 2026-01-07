package com.swiftride.services;

import com.swiftride.entities.User;
import com.swiftride.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> createUser(User user){
        System.out.println("🔥 Service called");
        User newUser=userRepository.save(user);
        System.out.println("🔥 after repo called");
        return ResponseEntity.ok((newUser));
    }
    public ResponseEntity<Optional<User>> deleteUser(Long id){
        Optional<User> user=userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    public ResponseEntity<Optional<User>> getUserById(long id){
        Optional<User> user= userRepository.findById(id);
        return ResponseEntity.ok(user);
    }
    public ResponseEntity<User> updateUser(long id, User user){
        User existUser=userRepository.findById(id).orElseThrow(()->new RuntimeException("Resource Not Found"));
        existUser.setName(user.getName());
        existUser.setRole(user.getRole());
        User user1=userRepository.save(existUser);
        return ResponseEntity.ok(user1);
    }
}
