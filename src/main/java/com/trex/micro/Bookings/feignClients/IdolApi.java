package com.trex.micro.Bookings.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trex.micro.Bookings.entity.Idols;

@FeignClient(value = "IDOL-SERVICE/idols")
public interface IdolApi {

     @GetMapping("/{id}")
    public ResponseEntity<Idols> getIdolsById(@PathVariable Integer id);
    
}
