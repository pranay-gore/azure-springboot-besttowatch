package com.entertainment.besttowatch.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entertainment.besttowatch.exception.ResourceNotFoundException;
import com.entertainment.besttowatch.model.Movie;
import com.entertainment.besttowatch.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie createMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie updateMovie(Integer id, Movie movie) { 
		Optional<Movie> movieFromDB = movieRepository.findById(id);
		if(movieFromDB.isPresent()) {
			Movie movieToUpdate = movieFromDB.get();
			movie.setId(movieToUpdate.getId());
			return movieRepository.save(movie);
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Integer id) {
		Optional<Movie> movieFromDB = movieRepository.findById(id);
		if(movieFromDB.isPresent()) {
			return movieFromDB.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

	@Override
	public List<Movie> getAllMoviesByPlatformName(String name) {
		return movieRepository.findAllByPlatformNameIgnoreCase(name);
	}

}
