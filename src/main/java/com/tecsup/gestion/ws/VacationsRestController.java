package com.tecsup.gestion.ws;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.gestion.model.Employee;
import com.tecsup.gestion.model.Vacation;

@RestController
public class VacationsRestController {

	private static final Logger logger = LoggerFactory.getLogger(VacationsRestController.class);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/vacation/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vacation> getEmployee(@PathVariable("username") String username) {
		Vacation vacation = null;

		try {
			vacation = getVacation(username);
			logger.info(vacation.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (vacation == null)
			return new ResponseEntity<Vacation>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Vacation>(vacation, HttpStatus.OK);

	}
	
	
	
		
	static ArrayList<Vacation> VACATIONS = new ArrayList<Vacation>();

	static {
		
		VACATIONS.add(new Vacation("jgomez",20));
		VACATIONS.add(new Vacation("gchavez",40));
		VACATIONS.add(new Vacation("mchavez",41));
		VACATIONS.add(new Vacation("cdiaz",42));
		VACATIONS.add(new Vacation("sgranados",43));
		VACATIONS.add(new Vacation("jguillermo",44));
		VACATIONS.add(new Vacation("lugarte",45));
		VACATIONS.add(new Vacation("jcamarena",46));
		VACATIONS.add(new Vacation("lquintana",47));
		VACATIONS.add(new Vacation("ccordova",48));
	}
	
	
	private Vacation getVacation(String username) {
		
		Vacation ret = null;
		
		for (Vacation item : VACATIONS ) {
		
			if(item.getUsername().equals(username)) {
				ret = item;
				break;
			}
							
		}

		
		return ret;
	}
}
