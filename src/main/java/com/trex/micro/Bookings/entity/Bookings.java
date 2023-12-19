package com.trex.micro.Bookings.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private Integer customerId;

    private Integer idolId;

    private Integer finalPrice;

    private Integer advance;

    private Integer pending;

    private Boolean isCompleted;

    private LocalDateTime bookingDate  = LocalDateTime.now();

    @Transient
    private Customers customer;

    @Transient
    private Idols idol;


    
}
