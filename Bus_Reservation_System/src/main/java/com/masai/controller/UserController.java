package com.masai.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController("/user")
@EnableWebSecurity
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//services related to user account------------------>
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User>getUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>>getAllUser(){
		
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User>addNewUser(@Valid @RequestBody User user){
		
		return new ResponseEntity<User>(userService.addNewUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User>updateUser(@Valid @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<User>deleteUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<User>(userService.deleteUserById(userId), HttpStatus.OK);
	}
	
	//<------------------------------------------------------------------->
	
	//services related to reservations--------------------------------------->
	
	@PostMapping("/users/reservations")
	public ResponseEntity<Reservation>addNewReservation(@Valid @RequestBody Reservation reservation){
		
		return new ResponseEntity<Reservation>(userService.addNewReservation(reservation), HttpStatus.CREATED);
	}
	
	@PutMapping("/users/reservations")
	public ResponseEntity<Reservation>updateReservation(@Valid @RequestBody Reservation reservation){
		
		return new ResponseEntity<Reservation>(userService.updateReservation(reservation), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/reservations/{reservationsId}")
	public ResponseEntity<Reservation>deleteReservation(@PathVariable Integer reservationId){
		
		return new ResponseEntity<Reservation>(userService.deleteReservation(reservationId), HttpStatus.OK);
	}
	
	@GetMapping("/users/reservations/{reservationsId}")
	public ResponseEntity<Reservation>getReservationById(@PathVariable Integer reservationId){
		
		return new ResponseEntity<Reservation>(userService.getReservationById(reservationId), HttpStatus.OK);
	}
	
	@GetMapping("/users/reservations/{userId}")
	public ResponseEntity<List<Reservation>>getAllReservationForUser(@PathVariable Integer userId){
		
		return new ResponseEntity<List<Reservation>>(userService.getAllReservationForUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/users/reservations/{date}")
	public ResponseEntity<List<Reservation>>getAllReservationByDate(@PathVariable LocalDate date){
		
		return new ResponseEntity<List<Reservation>>(userService.getAllReservationByDate(date), HttpStatus.OK);
	}
	
	//<----------------------------------------------------------------------------------->
	
	//services related to feedback---------------------------------------------------------->
	
	@PostMapping("/users/feedbacks")
	public ResponseEntity<Feedback>addNewFeedback(@Valid @RequestBody Feedback feedback){
		
		return new ResponseEntity<Feedback>(userService.addNewFeedback(feedback), HttpStatus.CREATED);
	}
	
	@PutMapping("/users/feedbacks")
	public ResponseEntity<Feedback>updateFeedback(@Valid @RequestBody Feedback feedback){
		
		return new ResponseEntity<Feedback>(userService.updateFeedback(feedback), HttpStatus.OK);
	}
	
	@GetMapping("/users/feedbacks/{feedbackId}")
	public ResponseEntity<Feedback>getFeedbackById(@PathVariable Integer feedbackId){
		
		return new ResponseEntity<Feedback>(userService.getFeedbackById(feedbackId), HttpStatus.OK);
	}
	
	@GetMapping("/users/feedbacks/{userId}")
	public ResponseEntity<List<Feedback>>getAllFeedbackForUser(@PathVariable Integer userId){
		
		return new ResponseEntity<List<Feedback>>(userService.getAllFeedbackForUser(userId), HttpStatus.OK);
	}
	
	
}
