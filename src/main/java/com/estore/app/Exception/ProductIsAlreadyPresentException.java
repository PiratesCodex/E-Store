package com.estore.app.Exception;

public class ProductIsAlreadyPresentException extends RuntimeException {

	private String message;

	public ProductIsAlreadyPresentException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
