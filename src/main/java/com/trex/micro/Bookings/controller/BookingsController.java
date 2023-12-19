package com.trex.micro.Bookings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trex.micro.Bookings.entity.Bookings;
import com.trex.micro.Bookings.exception.BookingsException;
import com.trex.micro.Bookings.service.BookingsService;

@RestController
@RequestMapping("/bookings")
public class BookingsController {
    
      @Autowired
    private BookingsService cS;

    @GetMapping
    public ResponseEntity<List<Bookings>> getAllBookings() {

        return new ResponseEntity<List<Bookings>>(cS.getBookings(), HttpStatus.OK);
        
    }

     @GetMapping("/{id}")
    public ResponseEntity<Bookings> getBookingsById(@PathVariable Integer id) {

        return new ResponseEntity<Bookings>(cS.getBookingsById(id), HttpStatus.OK);
        
    }

     @PostMapping
    public ResponseEntity<Bookings> saveBookings(@RequestBody Bookings Bookings) {

        return new ResponseEntity<Bookings>(cS.saveBookings(Bookings), HttpStatus.CREATED);
        
    }

     @PutMapping
    public ResponseEntity<Bookings> updateBookings(@RequestBody Bookings Bookings) {
        Bookings response = cS.updateBookings(Bookings);
        if (response==null) 
            throw new BookingsException(". Cannot update! No Bookings found with id : " +Bookings.getBookingId());

        return new ResponseEntity<Bookings>(cS.updateBookings(Bookings), HttpStatus.OK);
        
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteBookings(@PathVariable Integer id) {

        return new ResponseEntity<Integer>(cS.deleteBookings(id), HttpStatus.OK);
        
    }

}
