package com.github.EvgenyNazarovs.CourseBookingSystem.repositories;

import com.github.EvgenyNazarovs.CourseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
