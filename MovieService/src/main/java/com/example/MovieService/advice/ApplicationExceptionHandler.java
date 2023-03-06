package com.example.MovieService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.MovieService.exception.MovieNotFoundException;
import com.example.MovieService.exception.ScreenNotFoundException;
import com.example.MovieService.exception.SeatNotFoundException;
import com.example.MovieService.exception.ShowNotFoundException;
import com.example.MovieService.exception.TheatreNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = TheatreNotFoundException.class)
	public ResponseEntity<String> handleTheatreNotFoundException(TheatreNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = MovieNotFoundException.class)
	public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = ScreenNotFoundException.class)
	public ResponseEntity<String> handleScreenNotFoundException(ScreenNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = SeatNotFoundException.class)
	public ResponseEntity<String> handleSeatNotFoundException(SeatNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = ShowNotFoundException.class)
	public ResponseEntity<String> handleShowNotFoundException(ShowNotFoundException ex) {

		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
