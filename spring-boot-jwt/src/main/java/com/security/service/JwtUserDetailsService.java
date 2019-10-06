package com.security.service;

import org.springframework.stereotype.Service;

import com.security.repository.UserRepository;

@Service
public class JwtUserDetailsService  {
	
	private final UserRepository userRepository;
	
	public JwtUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String loadUserByUsername(String username)  {
		if ("javainuse".equals(username)) {
			/*
			 * return new User("javainuse",
			 * "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new
			 * ArrayList<>());
			 */			
			System.out.println(userRepository.findByUserName(username));
			return userRepository.findByUserName(username).getPassword();
			 
		} else return null;
	}

}