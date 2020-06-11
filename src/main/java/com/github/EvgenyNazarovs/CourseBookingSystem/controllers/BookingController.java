package com.github.EvgenyNazarovs.CourseBookingSystem.controllers;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    ResponseEntity<List<Booking>> getBookings(
            @RequestParam(name = "date", required = false) String date
    ) {
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

}
