package com.tutorials.exceptions;

public class AuthenticationException extends Exception {

	private String errorMessage;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8848063206351644888L;

	public AuthenticationException() {
	}

	public AuthenticationException(Exception e) {
		super(e);
	}

	public AuthenticationException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public AuthenticationException(Exception e, String errorMessage) {
		super(e);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
