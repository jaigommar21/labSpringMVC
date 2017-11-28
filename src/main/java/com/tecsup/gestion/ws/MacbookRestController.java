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

import com.tecsup.gestion.model.Macbook;

@RestController
public class MacbookRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MacbookRestController.class);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/book/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Macbook> getMacbbok(@PathVariable("name") String name) {
		Macbook macbook = null;

		try {
			macbook = getMacbook(name);
			logger.info(macbook.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (macbook == null)
			return new ResponseEntity<Macbook>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Macbook>(macbook, HttpStatus.OK);

	}
	
	static ArrayList<Macbook> MACBOOKS = new ArrayList<Macbook>();

	static {
		
		MACBOOKS.add(new Macbook("mbtec01",0));
		MACBOOKS.add(new Macbook("mbtec02",1));
		MACBOOKS.add(new Macbook("mbtec03",0));
		MACBOOKS.add(new Macbook("mbtec04",1));
		MACBOOKS.add(new Macbook("mbtec05",0));
		MACBOOKS.add(new Macbook("mbtec06",1));
		MACBOOKS.add(new Macbook("mbtec07",4));
		MACBOOKS.add(new Macbook("mbtec08",1));
		MACBOOKS.add(new Macbook("mbtec09",4));
		MACBOOKS.add(new Macbook("mbtec10",1));
		MACBOOKS.add(new Macbook("mbtec11",4));
		MACBOOKS.add(new Macbook("mbtec12",1));
	}
	
	
	private Macbook getMacbook(String name) {
		
		Macbook ret = null;
		
		for (Macbook item : MACBOOKS ) {
		
			if(item.getCode().equals(name)) {
				ret = item;
				break;
			}
							
		}

		
		return ret;
	}
}
