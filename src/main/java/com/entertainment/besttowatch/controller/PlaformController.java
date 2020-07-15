package com.entertainment.besttowatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entertainment.besttowatch.model.Movie;
import com.entertainment.besttowatch.model.Platform;
import com.entertainment.besttowatch.service.MovieService;
import com.entertainment.besttowatch.service.PlatformService;

@RestController
@RequestMapping("/platforms")
public class PlaformController {
	
	@Autowired
	private PlatformService platformService;
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Platform>> getAllPlatforms() {
		return ResponseEntity.ok().body(platformService.getAllPlatforms());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Platform> getPlatform(@PathVariable Integer id) {
		return ResponseEntity.ok().body(platformService.getPlatformById(id));	
	}
	
	@PostMapping
	public ResponseEntity<Platform> savePlatform(@RequestBody Platform platform) {
		return ResponseEntity.ok().body(platformService.createPlatform(platform));
	}
	
	@GetMapping("/{name}/movies")
	public ResponseEntity<List<Movie>> getMoviesByPlatformName(@PathVariable String name) {
		return ResponseEntity.ok().body(movieService.getAllMoviesByPlatformName(name));	
	}

}
