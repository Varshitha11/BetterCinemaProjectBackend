package com.example.MovieService.exception;

public class BussinessException extends RuntimeException {

	private String message;

	public BussinessException() {
	}

	public BussinessException(String message) {
		super(message);
		this.message = message;

	}
}
