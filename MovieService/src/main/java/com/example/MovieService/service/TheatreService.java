package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.TheatreRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Theatre;


@Service
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	

	public List<Theatre> getAllTheatres() {
		return theatreRepository.findAll();
	}

	
	public Theatre addTheatres(Theatre theatre) {
		return theatreRepository.save(theatre);
		
	}
	
	public Theatre getTheatreById(Integer id) {
		return theatreRepository.findById(id).get();
	}
	
	 public List<Theatre> getTheatreFromMovieid(Integer movieid){
		 List<Theatre> theatre = theatreRepository.getTheatreFromMovies(movieid);
		 return theatre;
	 }

}
