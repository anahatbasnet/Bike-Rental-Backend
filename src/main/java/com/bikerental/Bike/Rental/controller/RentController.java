package com.bikerental.Bike.Rental.controller;

import com.bikerental.Bike.Rental.dto.Response;

import com.bikerental.Bike.Rental.entity.RentDetails;
import com.bikerental.Bike.Rental.service.RentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rent")
@CrossOrigin(origins = "http://localhost:5173")
@Slf4j


public class RentController {
    @Autowired
    private RentService rentService;

    @PostMapping("/userInfo")
    public Response<RentDetails> addRentdetails(@RequestBody RentDetails rentDetails){
        return rentService.addRentedUserInfo (rentDetails);
    }
    @GetMapping("/rentDetails/{id}")
    public Response<RentDetails> getRentdetailsbyId(@PathVariable("id") int id) {
        return rentService.getRentDetailsbyId(id);
    }

    @GetMapping("allRentaldetails")
    public Response<List<RentDetails>> getAllRentDetails() {

        log.info("Fetching bikes.");
        return rentService.getAllRentDetails();
    }


}
