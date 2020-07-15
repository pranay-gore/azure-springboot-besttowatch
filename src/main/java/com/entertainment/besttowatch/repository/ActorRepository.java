package com.entertainment.besttowatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entertainment.besttowatch.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
