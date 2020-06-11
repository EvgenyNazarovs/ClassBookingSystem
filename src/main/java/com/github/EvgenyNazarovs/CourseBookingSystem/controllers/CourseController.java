package com.github.EvgenyNazarovs.CourseBookingSystem.controllers;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    ResponseEntity<List<Course>> getCourses(
            @RequestParam(name = "starRating", required = false) Double starRating,
            @RequestParam(name = "customerName", required = false) String customerName
    ) {
        if (starRating != null) {
            return new ResponseEntity<>(courseRepository.findByStarRating(starRating), HttpStatus.OK);
        }
        if (customerName != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
