package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "select * from user_table,booking where user_table.user_name = booking.user_id and booking.user_id =: userName", nativeQuery = true)
	List<Booking> findByUserName(String userName);
	
	@Query(value = "select * from bookings where user_id = :userName", nativeQuery = true)
	List<Booking> findBookings(String userName);

}
