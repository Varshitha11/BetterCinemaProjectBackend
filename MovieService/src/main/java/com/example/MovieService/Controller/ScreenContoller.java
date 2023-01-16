package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Screen;
import com.example.MovieService.service.ScreenService;

@CrossOrigin(origins = "*")
@RestController
public class ScreenContoller {

	@Autowired
	private ScreenService screenService;
	
	@GetMapping("/getScreensFromTheatre/{theatreId}")
	 public List<Screen> getScreenFromTheatre(@PathVariable("theatreId") int theatreId){
		 List<Screen> screen = screenService.getScreenFromTheatre(theatreId);
		 
		 return screen.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	@GetMapping("/getScreenFromShowIdAndTime/{showid}/{time}")
	 public Screen getScreenFromShowIdAndTime(@PathVariable("showid") int showid , @PathVariable("time") String time){
		  return screenService.getScreenFromShowIdAndTime(showid, time);
		 
	 }
}
