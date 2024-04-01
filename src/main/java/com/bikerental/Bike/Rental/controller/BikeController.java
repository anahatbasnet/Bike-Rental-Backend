package com.bikerental.Bike.Rental.controller;

import com.bikerental.Bike.Rental.Constant.ResponseCode;
import com.bikerental.Bike.Rental.dto.Response;
import com.bikerental.Bike.Rental.entity.Bike;
import com.bikerental.Bike.Rental.service.BikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bikes")
@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("allBikes")
    public Response<List<Bike>> getAllBikes() {

        log.info("Fetching bikes.");
        return bikeService.getAllBikes();
    }

    @GetMapping("{id}")
    public Response<Bike> getBikeById(@PathVariable("id") int id) {
        return bikeService.getBikeById(id);
    }

    @PostMapping("addBike")
    public Response<Bike> addBike(@RequestBody Bike bike){
        return bikeService.addBike(bike);
    }

    @PutMapping("updateBike/{id}")
    public Response<Bike> updateBike(@PathVariable("id") int id, @RequestBody Bike bike){
        return bikeService.updateBike(id, bike);
    }

    @DeleteMapping("deleteBike/{id}")
    public void deleteBike(@PathVariable("id") int id){
        bikeService.deleteBike(id);
    }
}
