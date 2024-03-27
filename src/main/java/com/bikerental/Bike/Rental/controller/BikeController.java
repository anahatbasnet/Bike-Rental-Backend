package com.bikerental.Bike.Rental.controller;

import com.bikerental.Bike.Rental.entity.Bike;
import com.bikerental.Bike.Rental.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bikes")
@CrossOrigin(origins = "http://localhost:5173")

public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("allBikes")
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @GetMapping("{id}")
    public Bike getBikeById(@PathVariable("id") int id) {
        return bikeService.getBikeById(id);
    }

    @PostMapping("addBike")
    public Bike addBike(@RequestBody Bike bike){
        return bikeService.addBike(bike);
    }

    @PutMapping("updateBike/{id}")
    public Bike updateBike(@PathVariable("id") int id, @RequestBody Bike bike){
        return bikeService.updateBike(id, bike);
    }

    @DeleteMapping("deleteBike/{id}")
    public void deleteBike(@PathVariable("id") int id){
        bikeService.deleteBike(id);
    }
}
