package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.MovieRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.exception.BussinessException;
import com.example.MovieService.exception.EmptyInputException;
import com.example.MovieService.exception.NoSuchElementException;


@Service
public class MovieService {
		
	@Autowired
	private MovieRepository movieRepo;
	

    public List<Movies> getMoviesByTitle(String title) {
    List<Movies> movies =  movieRepo.findByTitle(title);
    if(movies.isEmpty()) {
    	throw new BussinessException("no movie with title =" +title +"found");
    }
    return movies;
    }
	
    
    
	public Movies getMovieById(Integer id) {
		return movieRepo.findById(id).orElseThrow(
				() -> new NoSuchElementException("No Movie found with id =" +id) );	 
	}
	
	
	
	public List<Movies> getAllMovies() {
		List<Movies> movies = movieRepo.findAll();
		if(movies.isEmpty()) {
	    	throw new BussinessException("Hey List is empty");
	    }
		return movies;
	}
	
	
	
	 public Movies saveMovie(Movies movie) {
		 
		 if(movie.getTitle().isEmpty() || movie.getDescription().isEmpty() || movie.getLanguage().isEmpty() || movie.getImage().isEmpty() ){
			 throw new EmptyInputException("Input Fields are empty");
		 }
	        return movieRepo.save(movie);
	}
	 
	 
	 
	 public List<Movies> getMoviesFromTheatre(Integer theatreId){
		 List<Movies> movies = movieRepo.getMoviesFromTheatre(theatreId);
		 if(movies.isEmpty()) {
		    	throw new NoSuchElementException("no movie Found with theatreId =" +theatreId);
		    }
		 return movies;
	 }
	 
	 
	 
	 public List<Movies> getMoviesByTime(String time){
			List<Movies> movies = movieRepo.findMovieByTime(time);
			 if(movies.isEmpty()) {
			    	throw new BussinessException("no movie Found with time =" +time);
			    }
			return movies;		
		}
	 
	 
	 
	 public Movies getMoviesByShowIdAndTime(Integer showid) {
		 Movies movie = movieRepo.getMoviesByShowIdAndTime(showid);
		if(movie == null) {
			throw new NullPointerException("no movie found with showid:" +showid );
		}
		return movie;
		
	 }

}
