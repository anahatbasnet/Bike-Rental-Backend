package com.bikerental.Bike.Rental.dao;

import com.bikerental.Bike.Rental.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BikeDao extends JpaRepository<Bike, Integer> {
}
