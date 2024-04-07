package com.bikerental.Bike.Rental.dto;

import com.bikerental.Bike.Rental.entity.Bike;
import com.bikerental.Bike.Rental.entity.OurUsers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String email;
    private String role;
    private String password;
    private List<Bike> bike;
    private OurUsers ourUsers;
    private String fullName;
    private String responseCode;


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
