package com.edsonj.eoh;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.edsonj.eoh.entity.Cic;
import com.edsonj.eoh.entity.Party;

public class ObjectCreationTest {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String applicationUrl = "http://localhost:8082/cic/2";
		Cic cic = new Cic("Email", "Notify", "Edson is leaving for EOH", "Assignment", new Date());
		Party party = new Party("Edson Jengwa", "edson.jengwa@gmail.com");
		cic.setEntity(party);
		//ResponseEntity<Cic> response = restTemplate.postForEntity(applicationUrl, cic, Cic.class);
		ResponseEntity<Cic> response = restTemplate.getForEntity(applicationUrl, Cic.class);
		System.out.println(response);
	}

}
