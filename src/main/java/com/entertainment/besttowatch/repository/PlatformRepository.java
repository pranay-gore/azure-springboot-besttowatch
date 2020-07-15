package com.entertainment.besttowatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entertainment.besttowatch.model.Platform;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Integer> {

}
