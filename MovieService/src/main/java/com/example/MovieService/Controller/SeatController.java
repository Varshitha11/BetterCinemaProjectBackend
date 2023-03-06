package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Seats;
import com.example.MovieService.service.SeatService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class SeatController {

	@Autowired
	private SeatService seatService;

	Logger logger = (Logger) LoggerFactory.getLogger(SeatController.class);

	
	@GetMapping("/getSeats/{showId}/{time}")
	public List<Seats> getSeats(@PathVariable("showId") Integer showId, @PathVariable("time") String time) {

		List<Seats> seats = seatService.getSeats(showId, time);
		logger.info("-----seats fetched for showid:" + showId + " and time:" + time+"-----");
		return seats.stream().collect(Collectors.toSet()).stream().toList();
	}

	
	@GetMapping("/seats/{seatId}")
	public Seats getSeatsById(@PathVariable Integer seatId) {

		logger.info("----seats fetched for seatId: " + seatId + "---- ");
		return seatService.getSeatsById(seatId);
	}

}
