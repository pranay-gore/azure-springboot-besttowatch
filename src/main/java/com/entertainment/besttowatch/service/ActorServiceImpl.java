package com.entertainment.besttowatch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entertainment.besttowatch.exception.ResourceNotFoundException;
import com.entertainment.besttowatch.model.Actor;
import com.entertainment.besttowatch.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
	public Actor createActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public Actor updateActor(Integer id, Actor actor) {
		Optional<Actor> actorFromDB = actorRepository.findById(id);
		if(actorFromDB.isPresent()) {
			Actor actorToUpdate = actorFromDB.get();
			actor.setId(actorToUpdate.getId());
			return actorRepository.save(actor);
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

	@Override
	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@Override
	public Actor getActorById(Integer id) {
		Optional<Actor> actorFromDB = actorRepository.findById(id);
		if(actorFromDB.isPresent()) {
			return actorFromDB.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

}
