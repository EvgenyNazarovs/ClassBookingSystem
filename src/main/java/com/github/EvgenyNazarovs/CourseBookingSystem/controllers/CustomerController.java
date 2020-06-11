package com.github.EvgenyNazarovs.CourseBookingSystem.controllers;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> putCustomer(@PathVariable(value = "id") Long id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id).get();
        customer.setName(customerDetails.getName());
        customer.setAge(customerDetails.getAge());
        customer.setTown(customerDetails.getTown());
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }





}
