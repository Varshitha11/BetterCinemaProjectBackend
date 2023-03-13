package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer> {

	@Query(value = "  select * from shows,screen where shows.screenid_fk = screen.screen_id and shows.show_id =:showId", nativeQuery = true)
	Screen getScreenFromShow(@Param("showId") Integer showId);

}
