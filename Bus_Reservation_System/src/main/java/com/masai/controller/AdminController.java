package com.masai.controller;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.AdminService;

@RestController("/admin")
@EnableWebSecurity
public class AdminController {

	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
}
