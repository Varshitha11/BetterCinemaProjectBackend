package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
	
	@Query(value = "  select *from shows,screen,theatre,movie where shows.screenid_fk =screen.screen_id and screen.thscid_fk = theatre.theatre_id and shows.movie_id= movie.id and theatre.theatre_id=:theatreId and movie.id=:movieId", nativeQuery = true)
	List<Show> getShowsByMovieAndTheatre(@Param("movieId") Integer movieId, @Param("theatreId") Integer theatreId);

	@Query(value = "  select *from shows,screen,theatre,movie where shows.screenid_fk =screen.screen_id and screen.thscid_fk = theatre.theatre_id and shows.movie_id= movie.id and theatre.theatre_id=:theatreId and movie.id=:movieId and shows.time=:time", nativeQuery = true)	
	List<Show> getShowsByMovieTheatreAndTime(@Param("movieId") Integer movieId, @Param("theatreId") Integer theatreId,
			@Param("time") String time);

}
