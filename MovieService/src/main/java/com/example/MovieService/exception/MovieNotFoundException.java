package com.example.MovieService.exception;

public class MovieNotFoundException extends Exception {

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
