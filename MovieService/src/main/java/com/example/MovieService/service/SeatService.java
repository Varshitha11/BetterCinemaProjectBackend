package com.example.MovieService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MovieService.Repo.SeatRepository;
import com.example.MovieService.Repo.ShowSeatMappingRepo;
import com.example.MovieService.entity.Movies;
import com.example.MovieService.entity.Seats;
import com.example.MovieService.entity.ShowSeatMapping;

@Service
public class SeatService {
      
	@Autowired
	private SeatRepository seatRepo;
	
	@Autowired
	private ShowSeatMappingRepo showSeatRepo;
	
	public List<Seats> getSeats(Integer showid,String time){
		List<Seats> seats = seatRepo.getSeats(showid,time);
		return seats;
		
		
	}
	
	public Seats getSeatsById(Integer seatId) {
		return seatRepo.findById(seatId).get();
	}
	
/*	public  String checkIfSeaEmpty(Integer seatId) {
		Seats seat = seatRepo.getById(seatId);
		ShowSeatMapping showseat = new ShowSeatMapping();
		if(showseat.getStatus()=="available") {
			return "available";
		}
		return "notavailable";
	}
	
	public 	void bookSeat(Integer seatId) {
		seatRepo.bookSeat(seatId);
		
		ShowSeatMapping showseat = showSeatRepo.getById(seatId);
		showseat.setStatus("notavailable");	
	}
	*/

}
