package com.example.MovieService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.ShowSeatMapping;
import com.example.MovieService.exception.SeatNotFoundException;
import com.example.MovieService.service.ShowSeatMappingService;

@CrossOrigin(origins = "*")
@RestController
public class ShowSeatMappingController {

	@Autowired
	private ShowSeatMappingService showSeatService;

	@PostMapping("/bookTickets/{seatId}/{showId}/{userName}")
	public ResponseEntity<Object> bookTickets(@RequestBody ShowSeatMapping showSeatMap,
			@PathVariable("seatId") Integer seatId, @PathVariable("showId") Integer showId, @PathVariable("userName") String userName) {
		
		if (showSeatService.checkIfSeaEmpty(seatId) == "NotAvailable") {
			return new ResponseEntity<>("Seats are filled", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(showSeatService.bookSeat(seatId, showId,userName), HttpStatus.CREATED);
	}
	

	@GetMapping("/findBySeatId/{seatId}")
	public ShowSeatMapping findBySeatId(@PathVariable("seatId") Integer seatId) throws SeatNotFoundException {
		return showSeatService.findBySeatId(seatId);
	}

}
