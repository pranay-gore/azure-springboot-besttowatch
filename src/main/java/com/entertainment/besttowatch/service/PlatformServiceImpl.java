package com.entertainment.besttowatch.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entertainment.besttowatch.exception.ResourceNotFoundException;
import com.entertainment.besttowatch.model.Platform;
import com.entertainment.besttowatch.repository.PlatformRepository;

@Service
public class PlatformServiceImpl implements PlatformService{
	
	@Autowired
	private PlatformRepository platformRepository;

	@Override
	public Platform createPlatform(Platform platform) {
		return platformRepository.save(platform);
	}

	@Override
	public Platform updatePlatform(Integer id, Platform platform) {
		Optional<Platform> platformFromDB = platformRepository.findById(id);
		if(platformFromDB.isPresent()) {
			platform.setId(platformFromDB.get().getId());
			return platformRepository.save(platform);
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

	@Override
	public List<Platform> getAllPlatforms() {
		return platformRepository.findAll();
	}

	@Override
	public Platform getPlatformById(Integer id) {
		Optional<Platform> platformFromDB = platformRepository.findById(id);
		if(platformFromDB.isPresent()) {
			return platformFromDB.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id:"+ id);
		}
	}

}
