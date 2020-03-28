package com.tutorials.reposetories;

import java.util.HashMap;
import java.util.Map;

public class AuthRepo {
	private static Map<String, String> authDetails = new HashMap<String, String>();

	static {
		authDetails.put("Admin", "Admin");
		authDetails.put("User", "User");
	}

	public boolean validateCredentials(String userId, String password) {
		boolean isValid = false;
		if (userId != null && password != null && password.equals(authDetails.get(userId))) {
			isValid = true;
		}
		return isValid;
	}
}
