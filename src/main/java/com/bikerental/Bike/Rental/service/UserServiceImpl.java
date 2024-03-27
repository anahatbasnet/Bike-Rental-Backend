package com.bikerental.Bike.Rental.service;

import com.bikerental.Bike.Rental.dao.UserRepository;
import com.bikerental.Bike.Rental.dto.UserRegisterationDto;
import com.bikerental.Bike.Rental.entity.Role;
import com.bikerental.Bike.Rental.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegisterationDto registerationDto) {
        User user = new User(registerationDto.getFullName(), registerationDto.getEmail(),
                registerationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
}
