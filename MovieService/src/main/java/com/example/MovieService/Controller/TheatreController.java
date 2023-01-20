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
		
		 logger.info("---------Theatres Added succesfully------------" );
		return addTheatre;
	}
	
	
	@GetMapping("/getAllTheatres")
	public List<Theatre> getAllTheatres(){
		logger.info("---------All Theatres fetched------------");
		return theatreService.getAllTheatres();
	}
	

	@GetMapping("/theatre/{id}")
	public Theatre getTheatreById(@PathVariable Integer id) {
		logger.info("---------theatre fetched with id:" + id + "------------");
		return theatreService.getTheatreById(id);
	}
	
	
	@GetMapping("/getTheatreFromMovieId/{movieid}")
	 public List<Theatre> getMoviesFromTheatre(@PathVariable("movieid") int movieid){
		 List<Theatre> theatre = theatreService.getTheatreFromMovieid(movieid);
		 logger.info("-----------theatre fetched by movieid:" + movieid + "----------");
		 return theatre.stream().collect(Collectors.toSet()).stream().toList();
	 }
}
