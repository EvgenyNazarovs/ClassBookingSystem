package com.github.EvgenyNazarovs.CourseBookingSystem.controllers;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "bookingCourseName", required = false) String bookingCourseName,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (town != null && bookingCourseName != null && age != null) {
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, town, bookingCourseName), HttpStatus.OK);
        }
        if (town != null && bookingCourseName != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, bookingCourseName), HttpStatus.OK);
        }
        if (bookingCourseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(bookingCourseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping

}
