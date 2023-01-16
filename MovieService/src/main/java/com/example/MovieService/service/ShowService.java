package com.example.MovieService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.ShowRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Show;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
	 public List<Show>  getShowsFromMovieid(Integer movieid){
		 List<Show> shows = showRepository.getShowsFromMovieid(movieid) ;
		 return shows;
	 }
	 
	 public List<Show>  getShowsFromMovieidAndTheatreId(Integer movieid,Integer theatreId){
		 List<Show> shows = showRepository.getShowsFromMovieAndTheatre(movieid, theatreId);
		 return shows;
	 }
	 

	 public List<Show>  getShowsFromMovieTheatreTime(Integer movieid,String time,Integer theatreId){
		 List<Show> shows = showRepository.getShowsFromMovieTheatreTime(movieid, theatreId, time);
		 return shows;
	 }
	 
	 public Show getMovieFromShowId(Integer showid) {
		 return showRepository.getMovieByShow(showid);
	 }
	 
	 public Show getMovieById(Integer showid) {
			return showRepository.findById(showid).get();
		}

}
