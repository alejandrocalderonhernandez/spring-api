package com.debuggeando_ideas.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.debuggeando_ideas.entity.RecordCompanyEntity;
import com.debuggeando_ideas.repository.RecordCompanyRepository;
import com.debuggeando_ideas.service.IRecordCompanyService;

@Service
@Transactional
public class RecordCompanyImpl implements IRecordCompanyService {
	
	@Autowired
	private RecordCompanyRepository repository;

	@Override
	public Set<RecordCompanyEntity> getAll() {
		Set<RecordCompanyEntity> response = new HashSet<>();
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public RecordCompanyEntity save(RecordCompanyEntity entity) {
		return this.repository.save(entity);
	}

}
