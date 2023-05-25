package com.ty.movie_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.movie_service.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

	public Optional<List<Movie>> findByMovieGenre(String genre);

}
