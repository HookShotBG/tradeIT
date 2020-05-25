package com.tradeit.tradeitinman.restcontroller;


import com.tradeit.tradeitinman.entities.Aktienhandel;
import com.tradeit.tradeitinman.repositories.AktienhandelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */

@RestController
public class AktienhandelRestController {
	@Autowired
	private AktienhandelRepository aktienRepository;

	@RequestMapping(value = "/XXXXXXX", method = RequestMethod.GET)
	public ResponseEntity<List<Aktienhandel>> getAktien() {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Aktienhandel> aktien = aktienRepository.findAll();
		// Wenn die Liste Einträge enthält...
		if (aktien != null && !aktien.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(aktien, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}

	}
}