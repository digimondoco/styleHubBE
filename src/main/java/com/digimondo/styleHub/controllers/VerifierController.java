package com.digimondo.styleHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digimondo.styleHub.entities.PhoneNumberToken;
import com.digimondo.styleHub.entities.User;
import com.digimondo.styleHub.services.PhoneNumberVerifierService;
import com.digimondo.styleHub.services.UserService;

@RestController
public class VerifierController {

	@Autowired
	private PhoneNumberVerifierService phoneNumberVerifierService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/verify/{token}")
	public boolean verifyToken(@PathVariable String  token) {
		return phoneNumberVerifierService.isValidToken(token);
	}
	
	@PostMapping("register/{phoneNumber}")
	public String registerUser(@PathVariable String phoneNumber) {
		User user = new User();
		user.setPhoneNumber(phoneNumber);
		user.setValidated(true);
		userService.insertUser(user);
		PhoneNumberToken phoneNumberToken = phoneNumberVerifierService.generateToken(user);
	    return phoneNumberToken.getToken();
	}
}
