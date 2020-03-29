package com.tutorials.exceptions;

public class UserNotFoundException extends Exception {

	private String errorMessage;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8848063206351644888L;

	public UserNotFoundException() {
	}

	public UserNotFoundException(Exception e) {
		super(e);
	}

	public UserNotFoundException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public UserNotFoundException(Exception e, String errorMessage) {
		super(e);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
