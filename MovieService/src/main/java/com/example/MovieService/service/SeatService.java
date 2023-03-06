package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.SeatRepository;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.exception.SeatNotFoundException;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepo;

	public List<Seats> getSeats(Integer showId, String time) {
		List<Seats> seats = seatRepo.getSeats(showId, time);
		if (seats.isEmpty()) {
			throw new SeatNotFoundException("Seats not found with showId: " + showId + " and time: " + time);
		}
		return seats;
	}

	public Seats getSeatsById(Integer seatId) {
		return seatRepo.findById(seatId).orElseThrow(() -> new SeatNotFoundException("No Seat found with seatId = " + seatId));
	}

}
