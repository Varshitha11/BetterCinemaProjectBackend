package com.example.MovieService.exception;

public class SeatNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public SeatNotFoundException() {
	}

	public SeatNotFoundException(String message) {
		super(message);
		

	}
}