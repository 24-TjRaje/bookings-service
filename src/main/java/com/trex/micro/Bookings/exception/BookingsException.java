package com.trex.micro.Bookings.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsException extends RuntimeException {
    
    private String message;

}
