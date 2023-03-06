package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.ScreenRepository;
import com.example.MovieService.entity.Screen;
import com.example.MovieService.exception.ScreenNotFoundException;

@Service
public class ScreenService {

	@Autowired
	private ScreenRepository screenRepo;

	public List<Screen> getScreenFromTheatre(Integer theatreId) {
		List<Screen> screen = screenRepo.getScreensFromTheatre(theatreId);
		if (screen.isEmpty()) {
			throw new ScreenNotFoundException("no Screen found with theatreId: " + theatreId);
		}
		return screen;
	}

	public Screen getScreenFromShowAndTime(Integer showId, String time) {
		Screen screen = screenRepo.getScreenFromShowAndTime(showId, time);
		if (screen == null) {
			throw new ScreenNotFoundException("no screen found with showId: " + showId + " and time : " + time);
		}
		return screen;
	}

}
