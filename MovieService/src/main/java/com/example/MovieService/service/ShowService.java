package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.ShowRepository;
import com.example.MovieService.entity.Show;
import com.example.MovieService.exception.BussinessException;
import com.example.MovieService.exception.NoSuchElementException;


@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
	 public List<Show>  getShowsFromMovieid(Integer movieid){
		 List<Show> shows = showRepository.getShowsFromMovieid(movieid) ;
		 if(shows.isEmpty()) {
			 throw new BussinessException("Hey No show found for movieid: " +movieid);
		 }
		 return shows;
	 }
	 
	 public List<Show>  getShowsFromMovieidAndTheatreId(Integer movieid,Integer theatreId){
		 List<Show> shows = showRepository.getShowsFromMovieAndTheatre(movieid, theatreId);
		 if(shows.isEmpty()) {
			 throw new BussinessException("Hey No show found for movieid: " +movieid + " and theatreId:" +theatreId );
		 }
		 return shows;
	 }
	 

	 public List<Show>  getShowsFromMovieTheatreTime(Integer movieid,String time,Integer theatreId){
		 List<Show> shows = showRepository.getShowsFromMovieTheatreTime(movieid, theatreId, time);
		 return shows;
	 }

	 
	 public Show getShowById(Integer showid) {
			return showRepository.findById(showid).orElseThrow(
					() -> new NoSuchElementException("No Show found with id =" +showid));
		}

}
