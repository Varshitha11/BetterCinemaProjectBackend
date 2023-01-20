package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.TheatreRepository;
import com.example.MovieService.entity.Theatre;
import com.example.MovieService.exception.BussinessException;
import com.example.MovieService.exception.NoSuchElementException;



@Service
public class TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	

	public List<Theatre> getAllTheatres() {
		List<Theatre> theatres = theatreRepository.findAll();
		if(theatres.isEmpty()) {
	    	throw new BussinessException("Hey theatres List is empty");
	    }
		return theatres;
	}
	

	
	public Theatre addTheatres(Theatre theatre) {
		return theatreRepository.save(theatre);
		
	}
	
	
	public Theatre getTheatreById(Integer id) {
		return theatreRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("No such Theatre with id =" +id));
	}
	
	
	 public List<Theatre> getTheatreFromMovieid(Integer movieid){
		 List<Theatre> theatre = theatreRepository.getTheatreFromMovies(movieid);
		 if(theatre.isEmpty()) {
			 throw new NoSuchElementException("no theatre found with movieid =" +movieid);
		 }
		 return theatre;
	 }

}
