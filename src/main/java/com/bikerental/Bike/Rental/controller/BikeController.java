package com.bikerental.Bike.Rental.controller;

import com.bikerental.Bike.Rental.Bike;
import com.bikerental.Bike.Rental.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bikes")
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
}
