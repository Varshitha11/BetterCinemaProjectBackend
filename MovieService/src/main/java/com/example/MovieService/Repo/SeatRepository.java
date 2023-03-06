package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Seats;

@Repository
public interface SeatRepository extends JpaRepository<Seats, Integer> {

	@Query(value = "SELECT * FROM shows,showseatmapping,seats where shows.show_id = showseatmapping.showid_fk  and showseatmapping.show_seat_id = seats.seat_id and shows.screenid_fk = seats.scseid__fk and shows.show_id =:showId and shows.time =:time", nativeQuery = true)
	List<Seats> getSeats(@Param("showId") Integer showId, @Param("time") String time);

}
