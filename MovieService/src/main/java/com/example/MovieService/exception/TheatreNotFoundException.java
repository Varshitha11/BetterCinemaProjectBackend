package com.example.MovieService.exception;

public class TheatreNotFoundException  extends Exception{

	private String message;
	
	public TheatreNotFoundException() {}

	public TheatreNotFoundException(String message) {
		super(message);
		

	}


}
