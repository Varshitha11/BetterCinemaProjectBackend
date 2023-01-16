package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Theatre;
import com.example.MovieService.service.TheatreService;

@CrossOrigin(origins = "*")
@RestController
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	
	@PostMapping("/addTheatre")
	public Theatre addTheatre(@RequestBody Theatre theatre) {
		Theatre addTheatre = theatreService.addTheatres(theatre);
		return addTheatre;
	}
	
	@GetMapping("/")
	public List<Theatre> getAllTheatres(){
		return theatreService.getAllTheatres();
	}

	@GetMapping("/theatre/{id}")
	public Theatre getTheatreById(@PathVariable Integer id) {
		return theatreService.getTheatreById(id);
	}
	
	@GetMapping("/getTheatreFromMovieId/{movieid}")
	 public List<Theatre> getMoviesFromTheatre(@PathVariable("movieid") int movieid){
		 List<Theatre> theatre = theatreService.getTheatreFromMovieid(movieid);
		 
		 return theatre.stream().collect(Collectors.toSet()).stream().toList();
	 }
}
