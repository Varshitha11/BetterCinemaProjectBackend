package com.example.MovieService.exception;

public class ShowNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ShowNotFoundException() {
	}

	public ShowNotFoundException(String message) {
		super(message);
		

	}
}
