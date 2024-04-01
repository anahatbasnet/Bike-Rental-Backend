package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.Constant.ResponseCode;
import com.bikerental.Bike.Rental.dto.Response;
import com.bikerental.Bike.Rental.entity.Bike;
import com.bikerental.Bike.Rental.dao.BikeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeDao bikeDao;

    public Response<List<Bike>> getAllBikes() {
        try {
            List<Bike> bikes = bikeDao.findAll();
            return Response.<List<Bike>>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Bikes successfully retrieved.")
                    .data(bikes)
                    .build();
        } catch (Exception ex) {
            return Response.<List<Bike>>builder()
                    .responseCode(ResponseCode.ERROR)
                    .responseMessage("Error fetching bikes.")
                    .data(new ArrayList<>())
                    .build();
        }
    }

    public Response<Bike> getBikeById(int id) {
        Optional<Bike> optionalBike = bikeDao.findById(id);

        if (optionalBike.isPresent()) {
            return Response.<Bike>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Bike fetched successfully.")
                    .data(optionalBike.get())
                    .build();
        } else {
            return Response.<Bike>builder()
                    .responseCode(ResponseCode.ERROR)
                    .responseMessage("Bike with provided id not found.")
                    .data(new Bike())
                    .build();
        }
    }

    public Response<Bike> addBike(Bike bike) {
        try {
            Bike savedBike = bikeDao.save(bike);
            return Response.<Bike>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Bike added successfully.")
                    .data(savedBike)
                    .build();
        } catch (Exception ex) {
            return Response.<Bike>builder()
                    .responseCode(ResponseCode.ERROR)
                    .responseMessage("Error adding bike.")
                    .data(null)
                    .build();
        }
    }

    public Response<Bike> updateBike(int id, Bike updatedBike) {
        try {
            Optional<Bike> optionalBike = bikeDao.findById(id);
            if (optionalBike.isPresent()) {
                Bike existingBike = optionalBike.get();
                existingBike.setBikeName(updatedBike.getBikeName());
                existingBike.setBikeDetails(updatedBike.getBikeDetails());
                existingBike.setPricePerHour(updatedBike.getPricePerHour());
                existingBike.setImageUrl(updatedBike.getImageUrl());

                Bike savedBike = bikeDao.save(existingBike);
                return Response.<Bike>builder()
                        .responseCode(ResponseCode.SUCCESS)
                        .responseMessage("Bike updated successfully.")
                        .data(savedBike)
                        .build();
            } else {
                return Response.<Bike>builder()
                        .responseCode(ResponseCode.ERROR)
                        .responseMessage("Bike with provided id not found.")
                        .data(null)
                        .build();
            }
        } catch (Exception ex) {
            return Response.<Bike>builder()
                    .responseCode(ResponseCode.ERROR)
                    .responseMessage("Error updating bike.")
                    .data(null)
                    .build();
        }
    }

    public Response<Void> deleteBike(int id) {
        try {
            bikeDao.deleteById(id);
            return Response.<Void>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Bike deleted successfully.")
                    .data(null)
                    .build();
        } catch (Exception ex) {
            return Response.<Void>builder()
                    .responseCode(ResponseCode.ERROR)
                    .responseMessage("Error deleting bike.")
                    .data(null)
                    .build();
        }
    }
}
