package com.example.MovieService.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MovieService.entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

	public List<Movies> findByTitle(String title);

	@Query(value = "SELECT * FROM movie,shows,screen,theatre where movie.id = shows.movie_id and shows.screenid_fk = screen.screen_id and screen.thscid_fk = theatre.theatre_id and theatre.theatre_id =:theatreId", nativeQuery = true)
	List<Movies> getMoviesByTheatre(@Param("theatreId") Integer theatreId);

	@Query(value = " SELECT * FROM movie,shows where movie.id = shows.movie_id and shows.time=:time", nativeQuery = true)
	List<Movies> findMovieByTime(String time);
}
