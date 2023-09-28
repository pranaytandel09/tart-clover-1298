package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.User;

import jakarta.validation.Valid;

public interface UserService {

	User getUserById(Integer userId);

	List<User> getAllUser();

	User addNewUser(@Valid User user);

	User updateUser(@Valid User user);

	User deleteUserById(Integer userId);
	
	//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

	Reservation addNewReservation(@Valid Reservation reservation);

	Reservation updateReservation(@Valid Reservation reservation);

	Reservation deleteReservation(Integer reservationId);

	Reservation getReservationById(Integer reservationId);

	List<Reservation> getAllReservationForUser(Integer userId);
	
	//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

	Feedback addNewFeedback(@Valid Feedback feedback);

	Feedback updateFeedback(@Valid Feedback feedback);

	Feedback getFeedbackById(Integer feedbackId);

	List<Feedback> getAllFeedbackForUser(Integer userId);

	List<Reservation> getAllReservationByDate(LocalDate date);

}
