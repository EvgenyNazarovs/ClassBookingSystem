package com.github.EvgenyNazarovs.CourseBookingSystem.repositories;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String name);
    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);
    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(int age, String town, String courseName);
}
