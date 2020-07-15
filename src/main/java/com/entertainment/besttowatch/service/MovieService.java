package com.entertainment.besttowatch.service;

import java.util.List;

import com.entertainment.besttowatch.model.Movie;

public interface MovieService {

	Movie createMovie(Movie movie);

	Movie updateMovie(Integer id, Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieById(Integer id);
	
	List<Movie> getAllMoviesByPlatformName(String name);

}
