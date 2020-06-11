package com.github.EvgenyNazarovs.CourseBookingSystem;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canGetCoursesByRating() {
		List<Course> found = courseRepository.findByStarRating(4.5);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetBookingsByDate() {
		List<Booking> found = bookingRepository.findByDate("20-06-2020");
		assertEquals(1, found.size());
	}

	@Test
	public void canGetCustomersByBookingsCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseName("React");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCoursesByCustomersName() {
		List<Course> found = courseRepository.findByBookingsCustomerName("Eugene");
		assertEquals(2, found.size());
	}

	@Test
	public void canGetCustomersByTownAndCourse() {
		List<Customer> found = customerRepository.findByTownAndBookingsCourseName("Glasgow", "Java");
		assertEquals(1, found.size());
		assertEquals(1L, found.get(0).getId().longValue());
	}

	@Test
	public void canGetCustomersByAgeGreaterThan31AndByTownAndCourse() {
		List<Customer> found = customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(31, "London", "React");
		assertEquals(1, found.size());
	}

//	@Test
//	public void canGetCustomer() {
//		Customer customer = customerRepository.findById(1L);
//
//	}



}
