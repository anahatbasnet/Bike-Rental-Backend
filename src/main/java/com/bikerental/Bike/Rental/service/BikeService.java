package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.Bike;
import com.bikerental.Bike.Rental.dao.BikeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeDao bikeDao;

    public List<Bike> getAllBikes() {
        return bikeDao.findAll();
    }

    public Bike getBikeById(int id) {
        Optional<Bike> optionalBike = bikeDao.findById(id);
        return optionalBike.orElse(null);
    }
}
