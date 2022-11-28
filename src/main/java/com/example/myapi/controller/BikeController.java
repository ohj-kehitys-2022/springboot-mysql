package com.example.myapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapi.exception.ResourceNotFoundException;
import com.example.myapi.model.Bike;
import com.example.myapi.repository.BikeRepository;

@RestController
@RequestMapping("/api")
public class BikeController {
    @Autowired
    private BikeRepository bikeRepository;

    @GetMapping("/bike")
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    @GetMapping("/bike/{id}")
    public ResponseEntity<Bike> getBikeById(@PathVariable(value = "id") Long bikeId)
        throws ResourceNotFoundException {
        Bike Bike = bikeRepository.findById(bikeId)
          .orElseThrow(() -> new ResourceNotFoundException("Bike not found for this id :: " + bikeId));
        return ResponseEntity.ok().body(Bike);
    }
    
    @PostMapping("/bike")
    public Bike createBike(@RequestBody Bike Bike) {
        return bikeRepository.save(Bike);
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable(value = "id") Long bikeId,
         @RequestBody Bike BikeDetails) throws ResourceNotFoundException {
        Bike Bike = bikeRepository.findById(bikeId)
        .orElseThrow(() -> new ResourceNotFoundException("Bike not found for this id :: " + bikeId));

        Bike.setBrand(BikeDetails.getBrand());
        Bike.setColor(BikeDetails.getColor());
        final Bike updatedBike = bikeRepository.save(Bike);
        return ResponseEntity.ok(updatedBike);
    }

    @DeleteMapping("/bike/{id}")
    public Map<String, Boolean> deleteBike(@PathVariable(value = "id") Long bikeId)
         throws ResourceNotFoundException {
        Bike Bike = bikeRepository.findById(bikeId)
       .orElseThrow(() -> new ResourceNotFoundException("Bike not found for this id :: " + bikeId));

        bikeRepository.delete(Bike);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}