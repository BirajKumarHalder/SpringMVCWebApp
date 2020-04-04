package com.tutorials.models;

public class User {

	private String userId;
	private String userName;
	private String userRole;
	private String userEmail;
	private String userContact;

	public User() {
	}

	public User(String userId, String userName, String userRole, String userEmail, String userContact) {
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.userEmail = userEmail;
		this.userContact = userContact;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + ", userEmail="
				+ userEmail + ", userContact=" + userContact + "]";
	}

}
