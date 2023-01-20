package com.example.MovieService.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieService.entity.Screen;
import com.example.MovieService.service.ScreenService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class ScreenContoller {

	@Autowired
	private ScreenService screenService;
	
	Logger logger = (Logger) LoggerFactory.getLogger(ScreenContoller.class);

	
	@GetMapping("/getScreensFromTheatre/{theatreId}")
	 public List<Screen> getScreenFromTheatre(@PathVariable("theatreId") int theatreId){
		 List<Screen> screen = screenService.getScreenFromTheatre(theatreId);
		 
		 logger.info("---------screen fetched theatreId:" + theatreId + "------------");
		 return screen.stream().collect(Collectors.toSet()).stream().toList();
	 }
	
	@GetMapping("/getScreenFromShowIdAndTime/{showid}/{time}")
	 public Screen getScreenFromShowIdAndTime(@PathVariable("showid") int showid , @PathVariable("time") String time){
		
		logger.info("---------screen fetched with showid:" + showid + " and time:" +time);
		  return screenService.getScreenFromShowIdAndTime(showid, time);
		 
	 }
}
