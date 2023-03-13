package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Show;
import com.example.MovieService.exception.ShowNotFoundException;
import com.example.MovieService.service.ShowService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class ShowController {

	@Autowired
	private ShowService showService;

	Logger logger = (Logger) LoggerFactory.getLogger(ShowController.class);

	
	@GetMapping("/getShowsByMovieTheatreAndTime/{movieId}/{theatreId}")
	public List<Show> getShowsByMovieAndTheatre(@PathVariable("movieId") int movieId,
			@PathVariable("theatreId") int theatreId) throws ShowNotFoundException {
		
		List<Show> shows = showService.getShowsByMovieAndTheatre(movieId, theatreId);
		logger.info("---------shows fetched for movieId: " + movieId + " theatreId: " + theatreId + "------------");
		return shows.stream().collect(Collectors.toSet()).stream().toList();
	}
	

	@GetMapping("/getShowsByMovieTheatreAndTime/{movieId}/{theatreId}/{time}")
	public List<Show> getShowsByMovieTheatreAndTime(@PathVariable("movieId") int movieId,
			@PathVariable("theatreId") Integer theatreId, @PathVariable("time") String time) {
		
		List<Show> shows = showService.getShowsByMovieTheatreAndTime(movieId, time, theatreId);
		logger.info("---------shows fetched for movieid: " + movieId + " theatreId: " + theatreId + " time: " + time
				+ "------------");
		return shows.stream().collect(Collectors.toSet()).stream().toList();
	}

}
