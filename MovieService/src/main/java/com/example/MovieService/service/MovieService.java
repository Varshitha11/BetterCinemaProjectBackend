package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.MovieRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.exception.MovieNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	public List<Movies> getMoviesByTitle(String title) throws MovieNotFoundException{
		List<Movies> movies = movieRepo.findByTitle(title);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie with title = " + title + " found");
		}
		return movies;
	}
	

	public Movies getMovieById(Integer id) throws MovieNotFoundException {
	return movieRepo.findById(id).orElseThrow(() -> new MovieNotFoundException("no movie with id = " + id + " found"));		
	}

	
	public List<Movies> getAllMovies() throws MovieNotFoundException {
		List<Movies> movies = movieRepo.findAll();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("Hey list is empty");
		}
		return movies;
	}

	public List<Movies> getMoviesByTheatre(Integer theatreId) throws MovieNotFoundException {
		List<Movies> movies = movieRepo.getMoviesByTheatre(theatreId);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie found with theatreId = " + theatreId);
		}
		return movies;
	}

	
	public List<Movies> getMoviesByTime(String time) throws MovieNotFoundException {
		List<Movies> movies = movieRepo.findMovieByTime(time);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie found with time = " + time);
		}
		return movies;
	}

}
