package com.edsonj.eoh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonj.eoh.entity.Party;
import com.edsonj.eoh.service.EntityService;

@Service
public class EntityServiceImpl implements EntityService {
	
	@Autowired
	private EntityService entityService;

	@Override
	public Party saveEntity(Party party) {
		return entityService.saveEntity(party);
	}

}
