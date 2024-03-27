package com.bikerental.Bike.Rental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Integer id;
    private String bikeName;
    private String bikeDetails;
    private Double pricePerHour;
    private String imageUrl;
}
