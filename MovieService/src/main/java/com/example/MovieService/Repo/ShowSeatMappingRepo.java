package com.example.MovieService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.ShowSeatMapping;

import jakarta.transaction.Transactional;

@Repository
public interface ShowSeatMappingRepo extends JpaRepository<ShowSeatMapping, Integer> {

	@Query(value = " select * from showseatmapping,seats where seats.seat_id = showseatmapping.stid_fk and seats.seat_id =:seatId", nativeQuery = true)
	ShowSeatMapping findBySeatId(@Param("seatId") Integer seatId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE showseatmapping SET status = 'notavailable' WHERE showseatmapping.stid_fk =:seatId", nativeQuery = true)
	void setSeatById(@Param("seatId") Integer seatId);

}
