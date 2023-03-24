package com.example.MovieService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.MovieService.entity.Booking;
import com.example.MovieService.entity.User;
import com.example.MovieService.service.BookingService;

@CrossOrigin(origins = "*")
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking/{userName}")
	public List<Booking> getResults(@PathVariable String userName) {
	List<Booking> booking = bookingService.getBookingsByUserName(userName);
	return booking;
	}
}
