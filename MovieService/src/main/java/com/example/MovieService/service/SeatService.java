package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.SeatRepository;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.exception.BussinessException;
import com.example.MovieService.exception.NoSuchElementException;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepo;

	public List<Seats> getSeats(Integer showid, String time) {
		List<Seats> seats = seatRepo.getSeats(showid, time);
		if (seats.isEmpty()) {
			throw new BussinessException("Seats not found with showid:" + showid + " and time:" + time);
		}
		return seats;
	}

	public Seats getSeatsById(Integer seatId) {
		return seatRepo.findById(seatId).orElseThrow(() -> new NoSuchElementException("No Seat with id =" + seatId));
	}

}
