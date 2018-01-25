package com.edsonj.eoh.service;


import com.edsonj.eoh.entity.Cic;

public interface CicService {
	
	Cic saveCic(Cic cic);
	
	Cic findCicById(Long cicId);

}
