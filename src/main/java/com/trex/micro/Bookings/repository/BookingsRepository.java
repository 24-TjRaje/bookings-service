package com.trex.micro.Bookings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trex.micro.Bookings.entity.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Integer> {
    
}
