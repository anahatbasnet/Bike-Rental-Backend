package com.bikerental.Bike.Rental.dao;

import com.bikerental.Bike.Rental.entity.RentedBikes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentedDao extends JpaRepository<RentedBikes,Integer> {
}
