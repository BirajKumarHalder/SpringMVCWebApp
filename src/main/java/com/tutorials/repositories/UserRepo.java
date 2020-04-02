package com.tutorials.repositories;

import com.tutorials.models.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
	private static Map<String, User> userDetails = new HashMap<String, User>();

	static {
		userDetails.put("Admin",
				new User("Admin", "Jhon Doe Admin", "Admin", "john.doe.admin@email.com", "9876543210"));
		userDetails.put("User", new User("User", "Jhon Doe User", "User", "john.doe.user@email.com", "9876543210"));
	}

	public User retrieveUserDetails(String userId) {
		User user = null;
		if (userId != null) {
			user = userDetails.get(userId);
		}
		return user;
	}
}
