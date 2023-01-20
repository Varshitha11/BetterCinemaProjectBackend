package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Integer>{
	

	@Query(value = "select * from screen,theatre where screen.thscid_fk = theatre.theatre_id and theatre.theatre_id=:theatreId",nativeQuery = true)
	List<Screen> getScreensFromTheatre(@Param("theatreId") Integer theatreId);

	@Query(value = "  select * from show,screen where show.screenid_fk = screen.screen_id and show.show_id =:showid and show.time =:time" ,nativeQuery = true)
    Screen getScreenFromShowIdAndTime(@Param("showid") Integer showId, @Param("time") String time);
	
	
	
}
