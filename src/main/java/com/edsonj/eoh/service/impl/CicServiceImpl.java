package com.edsonj.eoh.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsonj.eoh.dao.CicDao;
import com.edsonj.eoh.dao.EntityDao;
import com.edsonj.eoh.entity.Cic;
import com.edsonj.eoh.entity.Party;
import com.edsonj.eoh.exception.BusinessValidationException;
import com.edsonj.eoh.service.CicService;

@Service
public class CicServiceImpl implements CicService {
	
	private static final Logger logger = LoggerFactory.getLogger(CicServiceImpl.class);

	@Autowired
	private CicDao cicDao;

	@Autowired
	private EntityDao entityDao;

	@Override
	public Cic saveCic(Cic cic) {
		logger.info(cic.toString());
		Party party = cic.getParty();
		if (Objects.nonNull(party)) {
			Party partyFromDatabase = null;
			partyFromDatabase = party.getEntityId() == null ? null: entityDao.findOne(party.getEntityId());
			if (Objects.isNull(partyFromDatabase)) {
				Party partyWithId = entityDao.save(party);
				cic.setEntity(partyWithId);
			}
		}else {
			throw new BusinessValidationException("Cic must always have an entity");
		}
		return cicDao.save(cic);
	}

	@Override
	public Cic findCicById(Long cicId) {
		return cicDao.findOne(cicId);
	}

}
