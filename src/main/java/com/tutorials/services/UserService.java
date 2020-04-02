package com.tutorials.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorials.models.User;
import com.tutorials.repositories.AuthRepo;
import com.tutorials.repositories.UserRepo;

public class UserService {

	@Autowired
	private AuthRepo authRepo;
	@Autowired
	private UserRepo userRepo;

	public boolean validateCredentials(String userId, String password) {
		return authRepo.validateCredentials(userId, password);
	}

	public User retrieveUserDetails(String userId) {
		return userRepo.retrieveUserDetails(userId);
	}
}
