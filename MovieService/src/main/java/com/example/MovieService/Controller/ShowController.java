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
import com.example.MovieService.service.ShowService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class ShowController {

	@Autowired
	private ShowService showService;
	
	Logger logger = (Logger) LoggerFactory.getLogger(ShowController.class);

	
	@GetMapping("/getShowsFromMovieid/{movieid}")
	 public List<Show> getShowsFromMovieid(@PathVariable("movieid") int movieid){
		 List<Show> shows = showService.getShowsFromMovieid(movieid);
		 
		 logger.info("---------shows fetched for movieid:" +movieid + "------------" );
		 
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	
	@GetMapping("/getShowFromMovieTheatreTime/{movieid}/{theatreId}")
	 public List<Show> getShowsFromMovieidAndTheatreId(@PathVariable("movieid") int movieid,@PathVariable("theatreId") int theatreId){
		 List<Show> shows = showService.getShowsFromMovieidAndTheatreId(movieid, theatreId);
		 
		 logger.info("---------shows fetched for movieid:" +movieid + "theatreId:" +theatreId +"------------" );
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	
	
	@GetMapping("/getShowFromMovieTheatreTime/{movieid}/{theatreId}/{time}")
	 public List<Show> getShowFromMovieTheatreTime(@PathVariable("movieid") int movieid,@PathVariable("theatreId") Integer theatreId, @PathVariable("time") String time){
		 List<Show> shows = showService.getShowsFromMovieTheatreTime(movieid, time, theatreId);
		 
		 logger.info("---------shows fetched for movieid:" +movieid + "theatreId:" +theatreId + "time:" +time +"------------" );
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	
	@GetMapping("/shows/{showid}")
	public Show getShowById(@PathVariable Integer showid) {
		return showService.getShowById(showid);
	}
	
	
}
