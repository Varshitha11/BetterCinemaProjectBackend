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
import com.example.MovieService.service.ShowSeatMappingService;

@CrossOrigin(origins = "*")
@RestController
public class ShowSeatController {

	@Autowired
	private ShowSeatMappingService showSeatService;

	@PostMapping("/bookTickets/{seatId}/{showid}")
	public ResponseEntity<Object> bookTickets(@RequestBody ShowSeatMapping showseatmap,
			@PathVariable("seatId") Integer seatId, @PathVariable("showid") Integer showId) {
		if (showSeatService.checkIfSeaEmpty(seatId) == "NotAvailable") {
			return new ResponseEntity<>("Seats are filled", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(showSeatService.bookSeat(seatId, showId), HttpStatus.CREATED);
	}

	@GetMapping("/findBySeatId/{seatId}")
	public ShowSeatMapping findBySeatId(@PathVariable("seatId") Integer seatId) {
		return showSeatService.findBySeatId(seatId);

	}

}
