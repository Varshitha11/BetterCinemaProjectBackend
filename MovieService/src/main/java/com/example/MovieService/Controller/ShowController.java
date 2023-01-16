package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Show;
import com.example.MovieService.service.ShowService;

@CrossOrigin(origins = "*")
@RestController
public class ShowController {

	@Autowired
	private ShowService showService;
	
	@GetMapping("/getShowsFromMovieid/{movieid}")
	 public List<Show> getShowsFromMovieid(@PathVariable("movieid") int movieid){
		 List<Show> shows = showService.getShowsFromMovieid(movieid);
		 
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	@GetMapping("/getShowFromMovieTheatreTime/{movieid}/{theatreId}")
	 public List<Show> getShowsFromMovieidAndTheatreId(@PathVariable("movieid") int movieid,@PathVariable("theatreId") int theatreId){
		 List<Show> shows = showService.getShowsFromMovieidAndTheatreId(movieid, theatreId);
		 
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	
	@GetMapping("/getShowFromMovieTheatreTime/{movieid}/{theatreId}/{time}")
	 public List<Show> getShowFromMovieTheatreTime(@PathVariable("movieid") int movieid,@PathVariable("theatreId") Integer theatreId, @PathVariable("time") String time){
		 List<Show> shows = showService.getShowsFromMovieTheatreTime(movieid, time, theatreId);
		 
		 return shows.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	@GetMapping("/getMovieFromShow/{showid}")
	public Show getMovie(@PathVariable int showid) {
		Show show = showService.getMovieFromShowId(showid);
		 return show;
	}
	
	@GetMapping("/shows/{showid}")
	public Show getShowById(@PathVariable Integer showid) {
		return showService.getMovieById(showid);
	}
	
	
}
