package com.example.MovieService.Repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {
	
	public List<Movies> findByTitle(String title);
	
	@Query(value = "SELECT * FROM movie,show,screen,theatre where movie.id = show.movie_id and show.screenid_fk = screen.screen_id and screen.thscid_fk = theatre.theatre_id and theatre.theatre_id =:theatreId",nativeQuery = true)
	List<Movies> getMoviesFromTheatre(@Param("theatreId") Integer theatreId);
	
	@Query(value = " SELECT * FROM movie,show where movie.id = show.movie_id and show.time=:time", nativeQuery=true)
	List<Movies> findMovieByTime(String time);
	
	@Query(value= "SELECT * FROM movie,show where show.movie_id=movie.id and show.show_id =:showid ", nativeQuery = true)
    Movies getMoviesByShowIdAndTime(@Param("showid") Integer showid);

}
