package com.devsuperior.bds04.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.dto.EventInsertDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Transactional(readOnly = true)
	public Page<EventDTO> findAll(Pageable pageable) {
		Page<Event> page = repository.findAll(pageable);
		return page.map(x -> new EventDTO(x));
	}

	@Transactional
	public EventDTO insert(@Valid EventInsertDTO dto) {
		Event entity = new Event();
		entity.setCity(new City(dto.getCityId(), null));
		entity.setDate(dto.getDate());
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity = repository.save(entity);
		return new EventDTO(entity);
	}

}
