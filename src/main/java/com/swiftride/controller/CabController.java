package com.swiftride.controller;

import com.swiftride.entities.Cab;
import com.swiftride.services.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/cabs")
public class CabController {
    @Autowired
    private CabService cabService;

    @PostMapping
    public ResponseEntity<Cab> createCab(@RequestBody Cab cab) {
        return cabService.createCab(cab);
    }

    @GetMapping
    public ResponseEntity<List<Cab>> getAllCabs() {
        return cabService.getAllCabs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cab> getCabById(@PathVariable long id) {
        return cabService.getCabById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cab> updateCab(
            @PathVariable long id,
            @RequestBody Cab cab) {
        return cabService.updateCab(id, cab);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCab(@PathVariable long id) {
        return cabService.deleteCab(id);
    }
    // GET available cabs
    @GetMapping("/available")
    public ResponseEntity<List<Cab>> getAvailableCabs() {
        return cabService.getAvailableCabs();
    }

    // UPDATE availability
    @PutMapping("/{id}/availability")
    public ResponseEntity<Cab> updateAvailability(
            @PathVariable long id,
            @RequestParam boolean available) {
        return cabService.updateCabAvailability(id, available);
    }
}
