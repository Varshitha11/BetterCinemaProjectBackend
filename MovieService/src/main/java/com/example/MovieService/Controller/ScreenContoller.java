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
import com.example.MovieService.exception.ScreenNotFoundException;
import com.example.MovieService.service.ScreenService;

import ch.qos.logback.classic.Logger;

@CrossOrigin(origins = "*")
@RestController
public class ScreenContoller {

	@Autowired
	private ScreenService screenService;

	Logger logger = (Logger) LoggerFactory.getLogger(ScreenContoller.class);

	@GetMapping("/getScreenFromShow/{showId}")
	public Screen getScreenFromShow(@PathVariable("showId") int showId) throws ScreenNotFoundException {

		logger.info("---------screen fetched with showId: " + showId);
		return screenService.getScreenFromShow(showId);

	}

}
