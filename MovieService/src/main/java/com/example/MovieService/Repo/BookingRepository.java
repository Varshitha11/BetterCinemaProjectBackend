package com.example.MovieService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
