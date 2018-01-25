package com.edsonj.eoh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edsonj.eoh.entity.Cic;
import com.edsonj.eoh.service.CicService;

@RestController
@RequestMapping(value="/cic")
public class CicController {

	@Autowired
	private CicService cicService;
	
	private static final Logger logger = LoggerFactory.getLogger(CicController.class);
	
	@RequestMapping(consumes="application/json", produces="application/json", method=RequestMethod.POST)
	public void saveCic(@RequestBody(required =true) Cic cic) {
		logger.info(cic.toString());
		cicService.saveCic(cic);
	}
	
	@RequestMapping(value="/{cidId}", method=RequestMethod.GET)
	public @ResponseBody Cic findCicById(@PathVariable("cicId") Long cicId) {
		logger.info(cicId.toString());
		return cicService.findCicById( cicId);
	}
}
