package com.infom.tradeit.demo.restcontroller;

import java.util.List;

import com.infom.tradeit.demo.entities.Aktienhandel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.infom.tradeit.demo.repositories.AktienhandelRepository;
import sun.misc.Request;

/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */

@RestController
public class AktienhandelRestController {
	@Autowired
	private AktienhandelRepository aktienRepository;

	@RequestMapping(value = "/portfolio", method = RequestMethod.GET)
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

	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "index";
	}
}