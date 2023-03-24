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

	public Screen getScreenFromShow(Integer showId) throws ScreenNotFoundException {
		Screen screen = screenRepo.getScreenFromShow(showId);
		if (screen == null) {
			throw new ScreenNotFoundException("no screen found with showId: " + showId);
		}
		return screen;
	}

}
