package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;
import com.masai.model.Feedback;
import com.masai.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
