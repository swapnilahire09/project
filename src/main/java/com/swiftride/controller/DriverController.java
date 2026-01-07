package com.swiftride.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/driver")
public class DriverController {

    @GetMapping("/trips")
    public String driverTrips() {
        return "Driver trips";
    }
}
