package com.example.MovieService.exception;

public class MovieNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public MovieNotFoundException() {
	}

	public MovieNotFoundException(String message) {
		super(message);
		

	}
}
