package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.entity.ShowSeatMapping;
import com.example.MovieService.service.SeatService;
import com.example.MovieService.service.ShowService;

@CrossOrigin(origins = "*")
@RestController
public class SeatController {
    
	@Autowired
	private SeatService seatService;
	
	
	@GetMapping("/getSeats/{showid}/{time}")
	public List<Seats> getSeats(@PathVariable("showid") Integer showid,@PathVariable("time") String time){
		List<Seats> seats = seatService.getSeats(showid,time);
		return seats.stream().collect(Collectors.toSet()).stream().toList();
		
	}
	
	@GetMapping("/Seats/{seatId}")
	public Seats getMovieById(@PathVariable Integer seatId) {
		return seatService.getSeatsById(seatId);
	}
/*	
	@PostMapping("/bookTicket/{seatId}")
	public ResponseEntity<Object> bookTickets(@RequestBody Seats seat,@PathVariable("seatId") Integer seatId) {
		if(seatService.checkIfSeaEmpty(seatId) == "NotAvailable") {
			return new ResponseEntity<>("Seats are filled", HttpStatus.BAD_REQUEST);
		}
		
		try {
		seatService.bookSeat(seatId);
		
		} catch(Exception e) 
		{
			 return new ResponseEntity<>(seat,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	    return new ResponseEntity<>(seat,HttpStatus.CREATED);
	}*/
}
