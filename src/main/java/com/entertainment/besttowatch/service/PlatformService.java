package com.entertainment.besttowatch.service;

import java.util.List;
import com.entertainment.besttowatch.model.Platform;

public interface PlatformService {
	
	Platform createPlatform(Platform platform);

	Platform updatePlatform(Integer id, Platform platform);

	List<Platform> getAllPlatforms();

	Platform getPlatformById(Integer id);

}
