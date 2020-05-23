package restcontroller;

import java.util.List;

import entities.Aktienhandel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import repositories.AktienhandelRepository;

/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */

@RestController
public class AktienhandelRestController {
	@Autowired
	private AktienhandelRepository aktienRepository;

	@RequestMapping(value = "/markets/stocks", method = RequestMethod.GET)
	public ResponseEntity<List<Aktienhandel>> getAktien1() {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Aktienhandel> aktien = aktienRepository.findAllByOrderByName();
		// Wenn die Liste Einträge enthält...
		if (aktien != null && !aktien.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(aktien, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}

	}
	
	
	@RequestMapping(value = "/markets/stocks", method = RequestMethod.POST)
	public ResponseEntity<List<Aktienhandel>> getAktien2() {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Aktienhandel> aktien = aktienRepository.findAllByOrderByName();
		// Wenn die Liste Einträge enthält...
		if (aktien != null && !aktien.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(aktien, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}

	}
	
	@RequestMapping(value = "/markets/stocks", method = RequestMethod.PUT)
	public ResponseEntity<List<Aktienhandel>> getAktien() {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Aktienhandel> aktien = aktienRepository.findAllByOrderByName();
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