package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MovieService.Repo.ScreenRepository;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Screen;

@Service
public class ScreenService {
	
	@Autowired
	private ScreenRepository screenRepo;
	
	 public List<Screen> getScreenFromTheatre(Integer theatreId){
		 List<Screen> screen = screenRepo.getScreensFromTheatre(theatreId);
		 return screen;
	 }

	 public Screen getScreenFromShowIdAndTime(Integer showid,String time){
		 Screen screen = screenRepo.getScreenFromShowIdAndTime(showid, time);
		 return screen;
	 }
}
