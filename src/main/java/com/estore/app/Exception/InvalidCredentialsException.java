package com.estore.app.Exception;

public class InvalidCredentialsException extends RuntimeException{

	private String message ;

	
	public InvalidCredentialsException(String message)
	{
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

}
