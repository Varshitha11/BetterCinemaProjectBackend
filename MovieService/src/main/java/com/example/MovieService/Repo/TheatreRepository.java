package com.example.MovieService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.MovieService.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	@Query(value = "SELECT theatre.* FROM movie,shows,screen,theatre where movie.id = shows.movie_id and shows.screenid_fk = screen.screen_id and screen.thscid_fk = theatre.theatre_id and movie.id=:movieId", nativeQuery = true)
	List<Theatre> getTheatreByMovieId(@Param("movieId") Integer movieId);

}
