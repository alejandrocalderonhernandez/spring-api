package com.debuggeando_ideas.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.debuggeando_ideas.config.DBCacheConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.debuggeando_ideas.entity.TrackEntity;
import com.debuggeando_ideas.repository.TrackRepository;
import com.debuggeando_ideas.service.ITrackService;

@Service
@Transactional
public class TrackServiceImpl implements ITrackService {

	@Autowired
	private TrackRepository repository;

	@Override
	@Cacheable(value = DBCacheConfig.CACHE_NAME)
	public Set<TrackEntity> getAll() {
		Set<TrackEntity> response = new HashSet<>();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public TrackEntity save(TrackEntity entity) {
		return this.repository.save(entity);
	}

	@Override
	@CacheEvict(cacheNames = DBCacheConfig.CACHE_NAME, allEntries = true)
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
