package com.digimondo.styleHub.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digimondo.styleHub.entities.PhoneNumberToken;
import com.digimondo.styleHub.entities.User;
import com.digimondo.styleHub.repositories.PhoneNumberTokenRepository;

@Service
public class PhoneNumberVerifierService {

	@Autowired
	private PhoneNumberTokenRepository phoneNumberTokenRepository;

	public PhoneNumberToken generateToken(User user) {
		String token = generateUniqueToken();
		PhoneNumberToken phoneNumberToken = new PhoneNumberToken();
		phoneNumberToken.setToken(token);
		phoneNumberToken.setUser(user);
		return phoneNumberTokenRepository.save(phoneNumberToken);
	}

	public boolean isValidToken(String token) {
		PhoneNumberToken phoneNumberToken = phoneNumberTokenRepository.findByToken(token);
		if(phoneNumberToken != null) {
			User user = phoneNumberToken.getUser();
			return user.isValidated();
		}
		return false;
	}

	private String generateUniqueToken() {
		return UUID.randomUUID().toString();
	}

}
