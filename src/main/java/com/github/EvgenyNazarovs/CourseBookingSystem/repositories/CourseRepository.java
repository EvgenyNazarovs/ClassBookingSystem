package com.github.EvgenyNazarovs.CourseBookingSystem.repositories;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStarRating(double starRating);
    List<Course> findByBookingsCustomerName(String name);
}
