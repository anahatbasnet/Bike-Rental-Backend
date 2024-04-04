package com.bikerental.Bike.Rental.dao;

import com.bikerental.Bike.Rental.entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<OurUsers,Integer> {
    Optional<OurUsers> findByEmail(String email);

    boolean existsByEmail(String email);
}
