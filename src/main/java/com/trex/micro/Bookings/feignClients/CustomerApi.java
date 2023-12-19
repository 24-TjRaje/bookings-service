package com.trex.micro.Bookings.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trex.micro.Bookings.entity.Customers;

@FeignClient(value = "CUSTOMER-SERVICE/customers")
public interface CustomerApi {
    
    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id);
}
