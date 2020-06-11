package com.github.EvgenyNazarovs.CourseBookingSystem.components;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CustomerRepository;
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

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() { }

    public void run(ApplicationArguments args) {

        Course reactCourse = new Course("React", "Glasgow", 4.5);
        courseRepository.save(reactCourse);

        Course javaCourse  = new Course("Java", "Inverness", 4.0);
        courseRepository.save(javaCourse);

        Customer eugene = new Customer("Eugene", "Glasgow", 29);
        customerRepository.save(eugene);

        Customer tom = new Customer("Tom", "London", 34);
        customerRepository.save(tom);

        Customer craig = new Customer("Craig", "London", 35);
        customerRepository.save(craig);

        Booking booking4 = new Booking("20-06-2020", reactCourse, craig);
        bookingRepository.save(booking4);


        Booking booking1 = new Booking("20-06-2020", reactCourse, eugene);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("18-06-2020", reactCourse, tom);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-07-2020", javaCourse, eugene);
        bookingRepository.save(booking3);

    }

}
