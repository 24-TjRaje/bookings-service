package com.trex.micro.Bookings.service;

import java.util.List;

import com.trex.micro.Bookings.entity.Bookings;

public interface BookingsService {
    
    public Bookings getBookingsById(Integer id);
    
    public List<Bookings> getBookings();

    public Bookings saveBookings(Bookings Bookings);

    public Bookings updateBookings(Bookings Bookings);

    public Integer deleteBookings(Integer id);
}
