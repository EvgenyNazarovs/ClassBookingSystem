package com.github.EvgenyNazarovs.CourseBookingSystem;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
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



}
