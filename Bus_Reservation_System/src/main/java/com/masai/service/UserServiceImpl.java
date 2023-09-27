package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.FeedbackRepository;
import com.masai.repository.ReservationRepository;
import com.masai.repository.RouteRepository;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private FeedbackRepository feedbackRepository;
	private ReservationRepository reservationRepository;
	private RouteRepository routeRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, FeedbackRepository feedbackRepository,
			ReservationRepository reservationRepository, RouteRepository routeRepository) {
		super();
		this.userRepository = userRepository;
		this.feedbackRepository = feedbackRepository;
		this.reservationRepository = reservationRepository;
		this.routeRepository = routeRepository;
	}
	
	
}
