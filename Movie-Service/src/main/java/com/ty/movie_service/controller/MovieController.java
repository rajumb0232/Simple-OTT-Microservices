package com.ty.movie_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.movie_service.dao.MovieDao;
import com.ty.movie_service.entity.Movie;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieDao movieDao;
	
	@PostMapping
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieDao.saveMovie(movie);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Movie> getMovieByGenre(@PathVariable String genre){
		return movieDao.getMovieByGenre(genre);
	}
	
	@GetMapping("/movieId/{movieId}")
	public Movie getMovie(@PathVariable int movieId) {
		return movieDao.getMovieById(movieId);
	}
}
