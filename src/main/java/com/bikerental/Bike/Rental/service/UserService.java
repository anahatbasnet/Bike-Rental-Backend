package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.dto.UserRegisterationDto;
import com.bikerental.Bike.Rental.entity.User;

public interface UserService {
    User save(UserRegisterationDto registerationDto );
}
