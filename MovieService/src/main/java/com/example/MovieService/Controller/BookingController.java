package com.example.MovieService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.MovieService.entity.Booking;
import com.example.MovieService.entity.User;
import com.example.MovieService.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/user/{userName}/booking")
	public ResponseEntity<List<Booking>> getBookingsOfUser(@PathVariable("username") String userName) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity("http://localhost:8082/api/user/{userName}", User.class);
		List<Booking> results = bookingService.getBookings(userName);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

}
