package com.digimondo.styleHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digimondo.styleHub.entities.User;
import com.digimondo.styleHub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User insertUser(User user) {
		return userRepository.save(user);
	}

}
