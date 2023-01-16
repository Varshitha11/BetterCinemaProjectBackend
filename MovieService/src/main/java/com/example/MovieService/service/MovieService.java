package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.MovieRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Show;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	

    public List<Movies> getMoviesByTitle(String title){
    List<Movies> movies =  movieRepo.findByTitle(title);
    return movies;
    }
	
	public Movies getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}
	
	public List<Movies> getAllMovies() {
		List<Movies> movies = movieRepo.findAll();
		return movies;
	}
	
	 public Movies saveMovie(Movies movie) {
	        return movieRepo.save(movie);
	    }
	 
	 public List<Movies> getMoviesFromTheatre(Integer theatreId){
		 List<Movies> movies = movieRepo.getMoviesFromTheatre(theatreId);
		 return movies;
	 }
	 
	 public List<Movies> getMoviesByTime(String time){
			List<Movies> movies = movieRepo.findMovieByTime(time);
			return movies;
			
		}
	 
	 public Movies getMoviesByShowIdAndTime(Integer showid, String time) {
		 return movieRepo.getMoviesByShowIdAndTime(showid, time);
	 }

}
