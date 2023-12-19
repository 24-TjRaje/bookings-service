package com.trex.micro.Bookings.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
import com.trex.micro.Bookings.config.RestClientConfig;
import com.trex.micro.Bookings.entity.Bookings;
import com.trex.micro.Bookings.entity.Customers;
import com.trex.micro.Bookings.entity.Idols;
import com.trex.micro.Bookings.exception.BookingsException;
import com.trex.micro.Bookings.feignClients.CustomerApi;
import com.trex.micro.Bookings.feignClients.IdolApi;
import com.trex.micro.Bookings.repository.BookingsRepository;

@Transactional
@Service
public class BookingsServiceImplementation implements BookingsService {

    
    @Autowired
    private BookingsRepository cR;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerApi customerApi;

    @Autowired
    private IdolApi idolApi;

    @Override
    public Bookings getBookingsById(Integer id) {

        Bookings response = cR.findById(id).orElseThrow( () -> new BookingsException("No Bookings found with id : " +id));
        return processIdolsAndCustomers(response);

    }

    @Override
    public List<Bookings> getBookings() {

        List<Bookings> responseList = cR.findAll();
        List<Bookings> processedList = responseList
                                        .stream()
                                        .map(i -> processIdolsAndCustomers(i))
                                        .collect(Collectors.toList());
        return processedList;
   
    }

    @Override
    public Bookings saveBookings(Bookings Bookings) {
        return cR.save(Bookings);
    }

    @Override
    public Bookings updateBookings(Bookings Bookings) {

         Boolean doesExist = cR.existsById(Bookings.getBookingId());

         return doesExist ? cR.save(Bookings) : null;
    }

    @Override
    public Integer deleteBookings(Integer id) {
        
        cR.deleteById(id);
        return id;
    }

    private Bookings processIdolsAndCustomers(Bookings response) {

        // Customers customer = restTemplate.getForObject(
        //     "http://CUSTOMER-SERVICE/customers/" + response.getCustomerId(), Customers.class);

        // Idols idol = restTemplate.getForObject(
        //     "http://IDOL-SERVICE/idols/" + response.getIdolId(), Idols.class);
        ResponseEntity<Customers> customer = customerApi.getCustomerById(response.getCustomerId());
        ResponseEntity<Idols> idol = idolApi.getIdolsById(response.getIdolId());
        response.setCustomer(customer.getBody());
        response.setIdol(idol.getBody());

        return response;
    }

    
}
