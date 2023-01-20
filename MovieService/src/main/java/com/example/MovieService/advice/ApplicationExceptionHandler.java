package com.example.MovieService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.MovieService.exception.BussinessException;
import com.example.MovieService.exception.EmptyInputException;
import com.example.MovieService.exception.ErrorResponse;
import com.example.MovieService.exception.NoSuchElementException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = NoSuchElementException.class)
	public @ResponseBody ErrorResponse handleException(NoSuchElementException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}

	@ExceptionHandler(value = EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = BussinessException.class)
	public ResponseEntity<String> handleBussinessException(BussinessException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = NullPointerException.class)
	public @ResponseBody ErrorResponse handleNullPointerException(NullPointerException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	

}
