package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FeedbackDoesNotExistException;
import com.masai.exception.ReservationDoesNotExistException;
import com.masai.exception.UserDoesNotExistException;
import com.masai.model.Bus;
import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.User;
import com.masai.repository.FeedbackRepository;
import com.masai.repository.ReservationRepository;
import com.masai.repository.RouteRepository;
import com.masai.repository.UserRepository;

import jakarta.validation.Valid;

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

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		 Optional<User> op = userRepository.findById(userId);
		 return op.orElseThrow(()->new UserDoesNotExistException("User does not exist with given User Id: "+userId));
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = userRepository.findAll();
		if(userList.size()==0)throw new UserDoesNotExistException("Users does not exists!");
		return userList;
	}

	@Override
	public User addNewUser(@Valid User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(@Valid User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = userRepository.findById(userId).get();
		if(user==null)throw new UserDoesNotExistException("User does not exist with given User Id: "+userId);
		userRepository.deleteById(userId);
		return user;
	}
	
	//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

	@Override
	public Reservation addNewReservation(@Valid Reservation reservation) {
		// TODO Auto-generated method stub
		User user = reservation.getUser();
		List<Reservation> reservationList = user.getReservation();
		reservationList.add(reservation);
		user.setReservation(reservationList);
		
		Bus bus = reservation.getBus();
		List<Reservation> busReservationList = bus.getReservation();
		busReservationList.add(reservation);
		bus.setReservation(busReservationList);
		
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation updateReservation(@Valid Reservation reservation) {
		// TODO Auto-generated method stub
	 return reservationRepository.save(reservation);
	}

	@Override
	public Reservation deleteReservation(Integer reservationId) {
		// TODO Auto-generated method stub
		Reservation reservation = reservationRepository.findById(reservationId).get();
		if(reservation==null)throw new ReservationDoesNotExistException("Reservation not found for given reservation id: "+reservationId);
		reservationRepository.deleteById(reservationId);
		return reservation;
	}

	@Override
	public Reservation getReservationById(Integer reservationId) {
		// TODO Auto-generated method stub
		 Optional<Reservation> op = reservationRepository.findById(reservationId);
		return op.orElseThrow(()->new ReservationDoesNotExistException("Reservation not found for given reservation id: "+reservationId)); 
	}

	@Override
	public List<Reservation> getAllReservationForUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).get();
		if(user==null)throw new UserDoesNotExistException("User does not exist with given User Id: "+userId);
		
		return user.getReservation();
	}
	
	@Override
	public List<Reservation> getAllReservationByDate(LocalDate date) {
		// TODO Auto-generated method stub
		List<Reservation> list = reservationRepository.findAllByReservationDate(date);
		if(list.size()==0)throw new ReservationDoesNotExistException("Reservations not exist for date: "+date.toString());
		return list;
	}
	
	
	//+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

	@Override
	public Feedback addNewFeedback(@Valid Feedback feedback) {
		// TODO Auto-generated method stub
		
		User user = feedback.getUser();
		List<Feedback> userFeedbackList = user.getFeedback();
		userFeedbackList.add(feedback);
		user.setFeedback(userFeedbackList);
		
		Bus bus = feedback.getBus();
		List<Feedback> busFeedbackList = bus.getFeedback();
		busFeedbackList.add(feedback);
		bus.setFeedback(busFeedbackList);
		
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback updateFeedback(@Valid Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(feedback);
	}

	@Override
	public Feedback getFeedbackById(Integer feedbackId) {
		// TODO Auto-generated method stub
		Optional<Feedback> op = feedbackRepository.findById(feedbackId);
		return op.orElseThrow(()->new FeedbackDoesNotExistException("feedback not exist with given feedbackId :"+feedbackId));
	}

	@Override
	public List<Feedback> getAllFeedbackForUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).get();
		if(user==null)throw new UserDoesNotExistException("User does not exist with given User Id: "+userId);
		
		return user.getFeedback();
	}

}
