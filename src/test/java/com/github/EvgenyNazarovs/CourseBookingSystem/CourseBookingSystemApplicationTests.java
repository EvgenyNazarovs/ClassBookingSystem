package com.github.EvgenyNazarovs.CourseBookingSystem;

import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.BookingRepository;
import com.github.EvgenyNazarovs.CourseBookingSystem.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

//	@Test
//	public void canGetCoursesByRating() {
//
//	}



}
