package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>{
    
	@Query(value = " SELECT *FROM movie join show ON movie.id = show.movie_id where show.movie_id =:movieid" , nativeQuery = true)
	List<Show> getShowsFromMovieid(@Param("movieid")   Integer movieid);
	
	@Query(value = "  select *from show,screen,theatre,movie where show.screenid_fk =screen.screen_id and screen.thscid_fk = theatre.theatre_id and show.movie_id= movie.id and theatre.theatre_id=:theatreId and movie.id=:movieid" , nativeQuery = true)
    List<Show> getShowsFromMovieAndTheatre(@Param("movieid")   Integer movieid, @Param("theatreId") Integer theatreId);
	
	@Query(value = "  select *from show,screen,theatre,movie where show.screenid_fk =screen.screen_id and screen.thscid_fk = theatre.theatre_id and show.movie_id= movie.id and theatre.theatre_id=:theatreId and movie.id=:movieid and show.time=:time" , nativeQuery = true)
    List<Show> getShowsFromMovieTheatreTime(@Param("movieid")   Integer movieid, @Param("theatreId") Integer theatreId,  @Param("time") String time);
	
	@Query(value =" select *from movie ,show where show.show_id=:showid", nativeQuery = true)
	Show getMovieByShow(@Param("showid") Integer showid);
	
	
	
}
