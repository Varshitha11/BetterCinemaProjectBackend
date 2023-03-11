package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Theatre;
import com.example.MovieService.exception.TheatreNotFoundException;
import com.example.MovieService.service.TheatreService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class TheatreController {

	@Autowired
	private TheatreService theatreService;

	Logger logger = (Logger) LoggerFactory.getLogger(TheatreController.class);

	@PostMapping("/addTheatre")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		
		Theatre addTheatre = theatreService.addTheatres(theatre);
        logger.info("---------Theatres added succesfully------------");
		return addTheatre;
	}

	
	@GetMapping("/getAllTheatres")
	public List<Theatre> getAllTheatres() throws TheatreNotFoundException {
		
		logger.info("---------All theatres fetched------------");
		return theatreService.getAllTheatres();
	}
	

	@GetMapping("/theatre/{theatreId}")
	public Theatre getTheatreById(@PathVariable Integer theatreId) throws TheatreNotFoundException {
		
		logger.info("---------theatre fetched with theatreId:" + theatreId + "------------");
		return theatreService.getTheatreById(theatreId);
	}
	

	@GetMapping("/getTheatreByMovieId/{movieId}")
	public List<Theatre> getTheatreByMovieId(@PathVariable("movieId") int movieId) throws TheatreNotFoundException {
		
		List<Theatre> theatre = theatreService.getTheatreByMovieId(movieId);
		logger.info("-----------theatre fetched by movieId:" + movieId + "----------");
		return theatre.stream().collect(Collectors.toSet()).stream().toList();
		//return theatre;
	}

}
