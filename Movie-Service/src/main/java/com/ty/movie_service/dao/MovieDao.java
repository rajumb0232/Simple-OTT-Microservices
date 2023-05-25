package com.ty.movie_service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.movie_service.entity.Movie;
import com.ty.movie_service.repository.MovieRepository;

@Repository
public class MovieDao {
	
	@Autowired
	private MovieRepository movieRepositoy;
	
	public Movie saveMovie(Movie movie) {
		return movieRepositoy.save(movie);
	}
	
	public List<Movie> getMovieByGenre(String genre){
		Optional<List<Movie>> optional = movieRepositoy.findByMovieGenre(genre);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}

	public Movie getMovieById(int movieId) {
		Optional<Movie> optional = movieRepositoy.findById(movieId);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
}
