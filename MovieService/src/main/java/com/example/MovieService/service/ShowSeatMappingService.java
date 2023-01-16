package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.BookingRepository;
import com.example.MovieService.Repo.PaymentRepository;
import com.example.MovieService.Repo.SeatRepository;
import com.example.MovieService.Repo.ShowRepository;
import com.example.MovieService.Repo.ShowSeatMappingRepo;
import com.example.MovieService.entity.Booking;
import com.example.MovieService.entity.Payment;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.entity.Show;
import com.example.MovieService.entity.ShowSeatMapping;

@Service
public class ShowSeatMappingService {

	@Autowired
	private ShowSeatMappingRepo showSeatRepo;
	
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private ShowRepository showRepo;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	
	public  String checkIfSeaEmpty(Integer seatId) {
		ShowSeatMapping showSeatMapping = showSeatRepo.findBySeatId(seatId);
		if(showSeatMapping.getStatus().equals( "available")) {
			return "available";
		}
		return "notavailable";
	}
	
	public Payment bookSeat(Integer seatId,Integer showId) {
		ShowSeatMapping showSeatMapping = showSeatRepo.getById(seatId);
		Seats seat = new Seats();
		try {
		showSeatRepo.setSeatById(seatId);
		showSeatMapping.setStatus("notavailable");

		} catch(Exception e) {
			showSeatMapping.setStatus("available");

		}
 		
		showSeatRepo.save(showSeatMapping);
		
		double Amount = 0;
		
		Show show = showRepo.getMovieByShow(showId);
		Payment payment = new Payment();
		
		Booking booking = new Booking();
		booking.setNumberOfSeats(seatId);
		booking.setStatus("booked");
		bookingRepo.save(booking);
	
		
		Amount += showSeatMapping.getPrice();
		Amount = Amount + 100;
		
		payment.setAmount(Amount);
		payment.setBooking(booking);
		paymentRepo.save(payment);
	
		return payment;
		
		
	}
	
	public ShowSeatMapping findBySeatId(Integer seatId) {
		return showSeatRepo.findBySeatId(seatId);
	}

}
