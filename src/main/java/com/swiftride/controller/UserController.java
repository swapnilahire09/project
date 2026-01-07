package com.swiftride.controller;

import com.swiftride.entities.Trip;
import com.swiftride.entities.User;
import com.swiftride.services.TripService;
import com.swiftride.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println("🔥 controller called create");
        return userService.createUser(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id){
        System.out.println("🔥 controller called delete");
        return  userService.deleteUser(id);
    }
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println("🔥 controller called get all");
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUserById(@PathVariable long id){
        System.out.println("🔥 controller called get by id");
        return userService.getAllUsers();
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){
        System.out.println("🔥 controller called update");
        return userService.updateUser(id,user);
    }

}
