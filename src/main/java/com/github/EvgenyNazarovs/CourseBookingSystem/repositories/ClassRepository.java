package com.github.EvgenyNazarovs.CourseBookingSystem.repositories;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Course, Long> {
}
