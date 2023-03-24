package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.BookingRepository;
import com.example.MovieService.entity.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	public List<Booking> getBookings(String userName) {
		return bookingRepo.findByUserName(userName);
	}
	

	public List<Booking> getBookingsByUserName(String userName) {
		List<Booking> booking = bookingRepo.findBookings(userName);
		return booking;
	}

}
