package com.example.MovieService.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Show;
import com.example.MovieService.service.MovieService;

@CrossOrigin(origins = "*")
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	//searchByTitle
	@GetMapping("/movie/{title}")
    public List<Movies> getMovieByTitle(@RequestParam("title") String title) {
        return movieService.getMoviesByTitle(title);
    }
	
	
	//byId
	@GetMapping("/movies/{id}")
	public Movies getMovieById(@PathVariable Integer id) {
		return movieService.getMovieById(id);
	}
	
	//allMovies
	@GetMapping("/getAllMovies")
	List<Movies> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	 @PostMapping("/add")
	    public Movies addMovie(@RequestBody Movies movie) {
	        Movies saveMovie = movieService.saveMovie(movie);
	        return saveMovie;
	 }
	 
	@GetMapping("/getMoviesFromTheatre/{theatreId}")
	 public List<Movies> getMoviesFromTheatre(@PathVariable("theatreId") int theatreId){
		 List<Movies> movies = movieService.getMoviesFromTheatre(theatreId);
		 
		 return movies.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	@GetMapping("/SearchByTime/{time}")
	public List<Movies> SearchByTime(@PathVariable("time") String time){
		List<Movies> movies = movieService.getMoviesByTime(time);
		return movies.stream().collect(Collectors.toSet()).stream().toList();
		
	}
	
	@GetMapping("/getMoviesByShowIdAndTime/{showid}/{time}")
	public Movies getMoviesByShowIdAndTime(@PathVariable("showid") Integer showid, @PathVariable("time") String time) {
		return movieService.getMoviesByShowIdAndTime(showid, time);
		
	}
	 
}
