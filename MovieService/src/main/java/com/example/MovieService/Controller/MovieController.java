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
import com.example.MovieService.service.MovieService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	Logger logger = (Logger) LoggerFactory.getLogger(MovieController.class);

	@GetMapping("/movie/{title}")
	public List<Movies> getMovieByTitle(@RequestParam("title") String title) {
		logger.info("---------movie fetched title:" + title + "------------");
		return movieService.getMoviesByTitle(title);
	}
	

	@GetMapping("/movies/{id}")
	public Movies getMovieById(@PathVariable Integer id) {

		logger.info("---------movie fetched with id:" + id + "------------");
		return movieService.getMovieById(id);
	}
	

	@GetMapping("/getAllMovies")
	List<Movies> getAllMovies() {

		logger.info("---------All movies fetched------------");
		return movieService.getAllMovies();
	}
	

	@PostMapping("/addMovie")
	public Movies addMovie(@RequestBody Movies movie) {
		Movies saveMovie = movieService.saveMovie(movie);
		logger.info("-----------movie added----------");
		return saveMovie;
	}
	

	@GetMapping("/getMoviesFromTheatre/{theatreId}")
	public List<Movies> getMoviesFromTheatre(@PathVariable("theatreId") int theatreId) {

		List<Movies> movies = movieService.getMoviesFromTheatre(theatreId);

		logger.info("-----------movie fetched by theatreId:" + theatreId + "----------");
		return movies.stream().collect(Collectors.toSet()).stream().toList();
	}
	

	@GetMapping("/SearchByTime/{time}")
	public List<Movies> SearchByTime(@PathVariable("time") String time) {
		List<Movies> movies = movieService.getMoviesByTime(time);
		logger.info("-----------movie fetched by time:" + time + "----------");
		return movies.stream().collect(Collectors.toSet()).stream().toList();
	}
	

	@GetMapping("/getMoviesByShowIdAndTime/{showid}")
	public Movies getMoviesByShowIdAndTime(@PathVariable("showid") Integer showid) {
		logger.info("-----------movie fetched by showid:" + showid );
		return movieService.getMoviesByShowIdAndTime(showid);
	}

}
