package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.model.Role;
import com.masai.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository =roleRepository;
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(name).get();
	}
	
	
}
