package com.edsonj.eoh.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.edsonj.eoh.entity.Party;
import com.edsonj.eoh.service.EntityService;

@RunWith(MockitoJUnitRunner.class)
public class EntityServiceImplTest {
		
	@Mock
	private EntityService entityService;
	
	@Mock
	private Party party;

	@Before
	public void setUp() {
		when(entityService.saveEntity(party)).thenReturn(party);
	}
	
	@Test
	public void shouldSaveAndReturnTheSavedPartyRecord() {
		Party result = entityService.saveEntity(party);
		assertEquals(party, result);
		verify(entityService, times(1) ).saveEntity(party);
	}
}
