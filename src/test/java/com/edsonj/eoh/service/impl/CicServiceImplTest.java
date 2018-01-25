package com.edsonj.eoh.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.edsonj.eoh.dao.CicDao;
import com.edsonj.eoh.dao.EntityDao;
import com.edsonj.eoh.entity.Cic;
import com.edsonj.eoh.entity.Party;
import com.edsonj.eoh.exception.BusinessValidationException;
import com.edsonj.eoh.service.CicService;

public class CicServiceImplTest {
	
	@Spy
	@InjectMocks
	private CicServiceImpl cicServiceImpl;
	
	@Mock
	private CicService cicService;
	
	@Mock
	private CicDao cicDao;

	@Mock
	private EntityDao entityDao;
	
	@Mock
	private Cic cic;
	
	@Mock
	private Party party;
	
	private static final Long PARTY_ID = 1L;
	private static final Long CIC_ID = 2L;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(cicDao.findOne(anyLong())).thenReturn(cic);
		when(cicDao.save(cic)).thenReturn(cic);
		when(entityDao.save(party)).thenReturn(party);
			
	}
	
	@Test
	public void shouldSaveAnEntityIfItExistsInTheDatabase() {
		Cic findOne = cicDao.findOne(CIC_ID);
		assertEquals(cic, findOne);
		verify(cicDao, times(1)).findOne(CIC_ID);
	}
	
	@Test
	public void shouldSaveAnEntityRecordToTheDatabaseWithTheGivenEntity() {
		when(cic.getParty()).thenReturn(party);
		when(party.getEntityId()).thenReturn(PARTY_ID);
		when(entityDao.findOne(PARTY_ID)).thenReturn(null);
		cicServiceImpl.saveCic(cic);
		verify(entityDao, times(1)).save(party);
		
	}
	
	@Test
	public void shouldSaveCicRecordToTheDatabaseWithTheGivenEntity() {
		when(cic.getParty()).thenReturn(party);
		when(party.getEntityId()).thenReturn(PARTY_ID);
		when(entityDao.findOne(PARTY_ID)).thenReturn(party);
		Cic saveCic = cicServiceImpl.saveCic(cic);
		assertEquals(cic, saveCic);
	}
	
	@Test
	public void shouldSaveEntityAssociatedWithPartyIfItDoesNotExist() {
		when(cic.getParty()).thenReturn(party);
		when(party.getEntityId()).thenReturn(null);
		when(entityDao.findOne(PARTY_ID)).thenReturn(null);
		cicServiceImpl.saveCic(cic);
		verify(entityDao, times(1)).save(party);
		
	}
	
	@Test(expected=BusinessValidationException.class)
	public void shouldThrowEcxeptionWhenEntityObjectIsNotSet() {
		when(cic.getParty()).thenReturn(null);
		cicServiceImpl.saveCic(cic);
	}

}
