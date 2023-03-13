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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.exception.MovieNotFoundException;
import com.example.MovieService.service.MovieService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);
	

	@GetMapping("/movie/{title}")
	public List<Movies> getMovieByTitle(@PathVariable("title") String title) throws MovieNotFoundException {

		logger.info("---movie fetched with title: " + title + "---");
		return movieService.getMoviesByTitle(title);
	}
	

	@GetMapping("/movies/{id}")
	public Movies getMovieById(@PathVariable Integer id) throws MovieNotFoundException {
		
       Movies movie = movieService.getMovieById(id);
			logger.info("---movie fetched with id: " + id + "---");
		return  movie;
	}
	

	@GetMapping("/getAllMovies")
	List<Movies> getAllMovies() throws MovieNotFoundException {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/getMoviesByTheatreId/{theatreId}")
	public List<Movies> getMoviesByTheatreId(@PathVariable("theatreId") int theatreId) throws MovieNotFoundException {

		List<Movies> movies = movieService.getMoviesByTheatre(theatreId);
		logger.info("---movie fetched by theatreId: " + theatreId + "---");
		return movies.stream().collect(Collectors.toSet()).stream().toList();
	}

	
	@GetMapping("/SearchByTime/{time}")
	public List<Movies> searchByTime(@PathVariable("time") String time) throws MovieNotFoundException {
		
		List<Movies> movies = movieService.getMoviesByTime(time);
		logger.info("-----------movie fetched by time: " + time + "----------");
		return movies.stream().collect(Collectors.toSet()).stream().toList();
	}

}
