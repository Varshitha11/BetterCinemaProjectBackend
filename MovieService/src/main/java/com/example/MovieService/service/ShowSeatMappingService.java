package com.example.MovieService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.BookingRepository;
import com.example.MovieService.Repo.PaymentRepository;
import com.example.MovieService.Repo.ShowRepository;
import com.example.MovieService.Repo.ShowSeatMappingRepo;
import com.example.MovieService.entity.Booking;
import com.example.MovieService.entity.Payment;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.entity.Show;
import com.example.MovieService.entity.ShowSeatMapping;
import com.example.MovieService.exception.MovieNotFoundException;
import com.example.MovieService.exception.SeatNotFoundException;

@Service
public class ShowSeatMappingService {

	@Autowired
	private ShowSeatMappingRepo showSeatRepo;

	@Autowired
	private ShowRepository showRepo;

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private PaymentRepository paymentRepo;

	public String checkIfSeaEmpty(Integer seatId) {
		ShowSeatMapping showSeatMapping = showSeatRepo.findBySeatId(seatId);
		if (showSeatMapping.getStatus().equals("available")) {
			return "available";
		}
		return "notavailable";
	}

	public Payment bookSeat(Integer seatId, Integer showId) {
		ShowSeatMapping showSeatMapping = showSeatRepo.getById(seatId);
		try {
			showSeatRepo.setSeatById(seatId);
			showSeatMapping.setStatus("notavailable");

		} catch (Exception e) {
			showSeatMapping.setStatus("available");

		}

		showSeatRepo.save(showSeatMapping);

		double amount = 0;

		Show show = showRepo.findById(showId).get();
		Payment payment = new Payment();

		Booking booking = new Booking(); // booking.setNumberOfSeats(seatId);
		booking.setStatus("booked");
		bookingRepo.save(booking);

		amount += showSeatMapping.getPrice();

		payment.setAmount(amount);
		payment.setBooking(booking);
		paymentRepo.save(payment);

		return payment;

	}

	public ShowSeatMapping findBySeatId(Integer seatId) throws SeatNotFoundException {
		ShowSeatMapping showSeat = showSeatRepo.findBySeatId(seatId);
		if(showSeat == null) {
			throw new SeatNotFoundException("no seat found with seatId: " + seatId);
		}
		return showSeat;
	}

}
