package com.microservices.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public List<User> findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

  
}
