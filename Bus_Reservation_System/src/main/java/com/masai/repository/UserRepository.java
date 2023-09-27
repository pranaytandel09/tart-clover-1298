package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;
import com.masai.model.Feedback;
import com.masai.model.Reservation;
import com.masai.model.Route;
import com.masai.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
