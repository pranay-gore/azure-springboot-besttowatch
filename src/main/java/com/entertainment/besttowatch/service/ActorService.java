package com.entertainment.besttowatch.service;

import java.util.List;

import com.entertainment.besttowatch.model.Actor;

public interface ActorService {

	Actor createActor(Actor actor);

	Actor updateActor(Integer id, Actor actor);

	List<Actor> getAllActors();

	Actor getActorById(Integer id);
}
