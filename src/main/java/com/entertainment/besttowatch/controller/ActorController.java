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
import com.entertainment.besttowatch.model.Actor;
import com.entertainment.besttowatch.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@GetMapping
	public ResponseEntity<List<Actor>> getAllActors() {
		return ResponseEntity.ok().body(actorService.getAllActors());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Actor> getActor(@PathVariable Integer id) {
		return ResponseEntity.ok().body(actorService.getActorById(id));	
	}
	
	@PostMapping
	public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {
		return ResponseEntity.ok().body(actorService.createActor(actor));
	}

}
