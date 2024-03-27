package com.bikerental.Bike.Rental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterationDto {
    private String fullName;
    private String email;
    private String password;
}
