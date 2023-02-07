package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.ScreenRepository;
import com.example.MovieService.entity.Screen;
import com.example.MovieService.exception.BussinessException;

@Service
public class ScreenService {

	@Autowired
	private ScreenRepository screenRepo;

	public List<Screen> getScreenFromTheatre(Integer theatreId) {
		List<Screen> screen = screenRepo.getScreensFromTheatre(theatreId);
		if (screen.isEmpty()) {
			throw new BussinessException("no Screen found with theatreid:" + theatreId);
		}
		return screen;
	}

	public Screen getScreenFromShowIdAndTime(Integer showid, String time) {
		Screen screen = screenRepo.getScreenFromShowIdAndTime(showid, time);
		if (screen == null) {
			throw new NullPointerException("no screen found with showid:" + showid + " and time :" + time);
		}
		return screen;
	}

}
