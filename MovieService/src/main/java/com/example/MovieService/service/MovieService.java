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

	public List<Movies> getMoviesByTitle(String title){
		List<Movies> movies = movieRepo.findByTitle(title);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie with title = " + title + " found");
		}
		return movies;
	}
	

	public Movies getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}

	
	public List<Movies> getAllMovies() {
		List<Movies> movies = movieRepo.findAll();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("Hey list is empty");
		}
		return movies;
	}

	
	public Movies saveMovie(Movies movie) {

		if (movie.getTitle().isEmpty() || movie.getDescription().isEmpty() || movie.getLanguage().isEmpty()
				|| movie.getImage().isEmpty()) {
			throw new MovieNotFoundException("Input fields are empty");
		}
		return movieRepo.save(movie);
	}
	

	public List<Movies> getMoviesByTheatre(Integer theatreId) {
		List<Movies> movies = movieRepo.getMoviesByTheatre(theatreId);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie found with theatreId = " + theatreId);
		}
		return movies;
	}

	
	public List<Movies> getMoviesByTime(String time) {
		List<Movies> movies = movieRepo.findMovieByTime(time);
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("no movie found with time = " + time);
		}
		return movies;
	}

	
	public Movies getMoviesByShowAndTime(Integer showId) {
		Movies movie = movieRepo.getMoviesByShowAndTime(showId);
		if (movie == null) {
			throw new MovieNotFoundException("no movie found with showId: " + showId);
		}
		return movie;

	}

}
