package com.github.EvgenyNazarovs.CourseBookingSystem.controllers;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name = "courseName", required = false) String courseName
    ) {
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
