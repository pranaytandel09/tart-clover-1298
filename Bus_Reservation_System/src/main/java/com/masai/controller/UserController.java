package com.masai.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.service.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
@EnableWebSecurity
public class UserController {

	private UserService userService;
	private PasswordEncoder passwordEncoder;
	public UserController(UserService userService,PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder =passwordEncoder;
	}
	
	//services related to user account------------------>
	
	@GetMapping("/logIn")
	public ResponseEntity<User> getLoggedInCustomerDetailsHandler(Authentication auth){

		System.out.println("authentication obj: "+auth); // this Authentication object having Principle object details
		System.out.println("username: "+auth.getName());

		 User user= userService.getUserDetailsByUsername(auth.getName());

		 return new ResponseEntity<>(user, HttpStatus.ACCEPTED);


	}
	
	@GetMapping("/get_users/{userId}")
	public ResponseEntity<User>getUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/get_users")
	public ResponseEntity<List<User>>getAllUser(){
		
		return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	@PostMapping("/users_signIn")
	public ResponseEntity<User>addNewUser(@Valid @RequestBody User user){
		
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		user.setPassword(encodedPassword);
		
		return new ResponseEntity<User>(userService.addNewUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update_users")
	public ResponseEntity<User>updateUser(@Valid @RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete_users/{userId}")
	public ResponseEntity<User>deleteUserById(@PathVariable Integer userId){
		
		return new ResponseEntity<User>(userService.deleteUserById(userId), HttpStatus.OK);
	}
	
	//<------------------------------------------------------------------->
	
	//services related to reservations--------------------------------------->
	
	@PostMapping("/users/add_reservations/{userId}/{busId}")
	public ResponseEntity<Reservation>addNewReservation(@PathVariable Integer userId, @PathVariable Integer busId ,@Valid @RequestBody Reservation reservation){
		
		return new ResponseEntity<Reservation>(userService.addNewReservation(userId,busId,reservation), HttpStatus.CREATED);
	}
	
	@PutMapping("/users/update_reservations")
	public ResponseEntity<Reservation>updateReservation(@Valid @RequestBody Reservation reservation){
		
		return new ResponseEntity<Reservation>(userService.updateReservation(reservation), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/delete_reservations/{reservationId}")
	public ResponseEntity<Reservation>deleteReservation(@PathVariable Integer reservationId){
		
		return new ResponseEntity<Reservation>(userService.deleteReservation(reservationId), HttpStatus.OK);
	}
	
	@GetMapping("/users/get_reservations_by_reservationId/{reservationId}")
	public ResponseEntity<Reservation>getReservationById(@PathVariable Integer reservationId){
		
		return new ResponseEntity<Reservation>(userService.getReservationById(reservationId), HttpStatus.OK);
	}
	
	@GetMapping("/users/get_reservations_by_userId/{userId}")
	public ResponseEntity<List<Reservation>>getAllReservationForUser(@PathVariable Integer userId){
		
		return new ResponseEntity<List<Reservation>>(userService.getAllReservationForUser(userId), HttpStatus.OK);
	}
	
	@GetMapping("/users/get_reservations_by_date/{date}")
	public ResponseEntity<List<Reservation>>getAllReservationByDate(@PathVariable LocalDate date){
		
		return new ResponseEntity<List<Reservation>>(userService.getAllReservationByDate(date), HttpStatus.OK);
	}
	
	//<----------------------------------------------------------------------------------->
	
	//services related to feedback---------------------------------------------------------->
	
	@PostMapping("/users/add_feedbacks/{userId}/{busId}")
	public ResponseEntity<Feedback>addNewFeedback(@PathVariable Integer userId, @PathVariable Integer busId ,@Valid @RequestBody Feedback feedback){
		
		return new ResponseEntity<Feedback>(userService.addNewFeedback(userId,busId,feedback), HttpStatus.CREATED);
	}
	
	@PutMapping("/users/update_feedbacks")
	public ResponseEntity<Feedback>updateFeedback(@Valid @RequestBody Feedback feedback){
		
		return new ResponseEntity<Feedback>(userService.updateFeedback(feedback), HttpStatus.OK);
	}
	
	@GetMapping("/users/get_feedbacks_by_feedbackId/{feedbackId}")
	public ResponseEntity<Feedback>getFeedbackById(@PathVariable Integer feedbackId){
		
		return new ResponseEntity<Feedback>(userService.getFeedbackById(feedbackId), HttpStatus.OK);
	}
	
	@GetMapping("/users/get_feedbacks_by_userId/{userId}")
	public ResponseEntity<List<Feedback>>getAllFeedbackForUser(@PathVariable Integer userId){
		
		return new ResponseEntity<List<Feedback>>(userService.getAllFeedbackForUser(userId), HttpStatus.OK);
	}
	
	
}
