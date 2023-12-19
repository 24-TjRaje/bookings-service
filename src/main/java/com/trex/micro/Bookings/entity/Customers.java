package com.trex.micro.Bookings.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    
    private Integer customerId;

    private String customerName;

    private String customerPhoneNumber;

    private String customerAddress;
}
