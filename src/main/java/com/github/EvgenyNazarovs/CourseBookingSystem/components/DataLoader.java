package com.github.EvgenyNazarovs.CourseBookingSystem.components;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() { }

    public void run(ApplicationArguments args) {

        Course reactCourse = new Course("React", "Glasgow", 4.5);
        courseRepository.save(reactCourse);

        Course javaCourse  = new Course("Java", "Inverness", 4.0);
        courseRepository.save(javaCourse);

        Booking booking1 = new Booking("20-06-2020", reactCourse);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("18-06-2020", reactCourse);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-07-2020", javaCourse);
        bookingRepository.save(booking3);

    }

}
