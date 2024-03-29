package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.TheatreRepository;
import com.example.MovieService.entity.Theatre;
import com.example.MovieService.exception.TheatreNotFoundException;

@Service
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;

	public List<Theatre> getAllTheatres() throws TheatreNotFoundException {
		List<Theatre> theatres = theatreRepository.findAll();
		if (theatres.isEmpty()) {
			throw new TheatreNotFoundException("Hey theatres list is empty");
		}
		return theatres;
	}

	public Theatre getTheatreById(Integer theatreId) throws TheatreNotFoundException {
		return theatreRepository.findById(theatreId)
				.orElseThrow(() -> new TheatreNotFoundException("No such theatre with id = " + theatreId));

	}

	public List<Theatre> getTheatreByMovieId(Integer movieId) throws TheatreNotFoundException {
		List<Theatre> theatre = theatreRepository.getTheatreByMovieId(movieId);
		System.out.println(theatre.size());
		if (theatre.isEmpty()) {
			throw new TheatreNotFoundException("no theatre found with movieid = " + movieId);
		}
		return theatre;
	}

}
