package com.estore.app.Exception;

public class AuthenticationException extends RuntimeException {

	private  String message ;

	public AuthenticationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
