package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.Constant.ResponseCode;
import com.bikerental.Bike.Rental.dao.RentedDao;
import com.bikerental.Bike.Rental.dto.Response;
import com.bikerental.Bike.Rental.entity.RentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class RentService {
    @Autowired
    private RentedDao rentedDao;
    public Response <List<RentDetails>> getAllRentDetails(){
        List <RentDetails> rentDetails = rentedDao.findAll();
        try{
            return Response.<List<RentDetails>>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Fetched the details successfully")
                    .data(rentDetails)
                    .build();

        }
        catch(Exception ex){
            return Response.<List<RentDetails>>builder()
                    .responseCode(ResponseCode.BAD_REQUEST)
                    .responseMessage("Failed to fetch the data")
                    .data(new ArrayList<>())
                    .build();
        }
    }
    public Response<RentDetails>  getRentDetailsbyId(int id){
        Optional <RentDetails> optionalRentDetails = rentedDao.findById(id);

            if (optionalRentDetails.isPresent()){
                return Response.<RentDetails>builder()
                        .responseCode(ResponseCode.SUCCESS)
                        .responseMessage("Data for the id fetched successfully")
                        .data(optionalRentDetails.get())
                        .build();

            }else{
                return  Response.<RentDetails>builder()
                        .responseCode(ResponseCode.BAD_REQUEST)
                        .responseMessage("Data for the id could not be fetched")
                        .data(new RentDetails())
                        .build();
            }

        }
    public Response<RentDetails> addRentedUserInfo(RentDetails rentDetails){
        try{
            RentDetails savedRentDetails = rentedDao.save(rentDetails);
            return Response.<RentDetails>builder()
                    .responseCode(ResponseCode.SUCCESS)
                    .responseMessage("Renting Successfully done")
                    .data(savedRentDetails)
                    .build();

        }
        catch (Exception ex){
            return  Response.<RentDetails>builder()
                    .responseCode(ResponseCode.BAD_REQUEST)
                    .responseMessage("Booking Unsuccessful")
                    .data(null)
                    .build();
        }

    }
    }





