package com.example.MovieService.exception;

public class EmptyInputException extends RuntimeException{

	private String message;
	
	public EmptyInputException() {}

	public EmptyInputException(String message) {
		super(message);
		this.message = message;

	}
}
