package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.ShowRepository;
import com.example.MovieService.entity.Show;
import com.example.MovieService.exception.ShowNotFoundException;


@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepository;


	public List<Show> getShowsByMovieAndTheatre(Integer movieId, Integer theatreId) throws ShowNotFoundException {
		List<Show> shows = showRepository.getShowsByMovieAndTheatre(movieId, theatreId);
		if (shows.isEmpty()) {
			throw new ShowNotFoundException("Hey No show found for movieId: " + movieId + " and theatreId: " + theatreId);
		}
		return shows;
	}

	public List<Show> getShowsByMovieTheatreAndTime(Integer movieId, String time, Integer theatreId) {
		List<Show> shows = showRepository.getShowsByMovieTheatreAndTime(movieId, theatreId, time);
		return shows;
	}
}
