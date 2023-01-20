package com.example.MovieService.exception;

public class NoSuchElementException  extends RuntimeException{

	private String message;
	
	public NoSuchElementException() {}

	public NoSuchElementException(String message) {
		super(message);
		this.message = message;

	}


}
