package com.entertainment.besttowatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entertainment.besttowatch.model.Movie;
import com.entertainment.besttowatch.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok().body(movieService.getAllMovies());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Integer id) {
		return ResponseEntity.ok().body(movieService.getMovieById(id));	
	}
	
	@PostMapping
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(movieService.createMovie(movie));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> UpdateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
		Movie movieFromDB = movieService.getMovieById(id);
		if(movieFromDB != null) {
			movie.setId(movieFromDB.getId());
		}
		return ResponseEntity.ok().body(movieService.createMovie(movie));
	}
}
