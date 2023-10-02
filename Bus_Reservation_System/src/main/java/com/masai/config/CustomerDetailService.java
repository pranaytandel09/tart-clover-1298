package com.masai.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.User;
import com.masai.repository.UserRepository;

@Service
public class CustomerDetailService implements UserDetailsService {

	private UserRepository userRepository;
	
	public CustomerDetailService(UserRepository userRepository) {
		this.userRepository =userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> op = userRepository.findByUsername(username);
		return op.orElseThrow(()-> new UsernameNotFoundException("user no found with given username: "+username));
	}

}
