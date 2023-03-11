package com.example.MovieService.exception;

public class ScreenNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ScreenNotFoundException() {}

	public ScreenNotFoundException(String message) {
		super(message);

	}
}
