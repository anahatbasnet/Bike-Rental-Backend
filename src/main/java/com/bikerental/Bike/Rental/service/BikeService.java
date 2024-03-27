package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.entity.Bike;
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
    public Bike addBike(Bike bike){
        return bikeDao.save(bike);
    }
public Bike updateBike(int id , Bike updatedBike){
        Optional<Bike> optionalBike = bikeDao.findById(id);
if(optionalBike.isPresent()){
    Bike existingBike = optionalBike.get();
    existingBike.setBikeName(updatedBike.getBikeName());
    existingBike.setBikeDetails(updatedBike.getBikeDetails());
    existingBike.setPricePerHour(updatedBike.getPricePerHour());
    existingBike.setImageUrl(updatedBike.getImageUrl());
return bikeDao.save(existingBike);
}
return null;
}
public void deleteBike(int id){
        bikeDao.deleteById(id);
}
}
