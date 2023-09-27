package com.masai.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.UserService;

@RestController("/user")
@EnableWebSecurity
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
}
