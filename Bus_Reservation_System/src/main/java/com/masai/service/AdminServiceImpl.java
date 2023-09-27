package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.AdminRepository;
import com.masai.repository.BusRepository;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	private BusRepository busRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository,BusRepository busRepository) {
		
		this.adminRepository =adminRepository;
		this.busRepository =busRepository;
	}
}
