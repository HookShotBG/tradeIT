package com.infom.tradeit.demo.restcontroller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.infom.tradeit.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.infom.tradeit.demo.repositories.TitelRepository;


/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */
@RestController
public class TitelRestController {
	@Autowired
	private TitelRepository titelRepository;

	@GetMapping("/stocky")
	List<Titel> generateData() {
		Preis p = new Preis(100, new Date(1999093), new Date(421341234));
		List<Preis> pl = new ArrayList<Preis>();
		pl.add(p);
		p = new Preis(100, new Date(421341234), new Date(512341234));
		pl.add(p);
		Boersenplatz b = new Boersenplatz("SIX Stock X", "SIX", "Switzerland");
		Sektor s = new Sektor("Technologie");
		Art a = new Art("Diverses", "Penisman");

		Aktie aktie = new Aktie("Microsoft", 1001, "MSFT", "CHF", b, s, a, pl, "XXX0010");
		Aktie bktie = new Aktie("Teslik", 1001, "MSFT", "CHF", b, s, a, pl, "XXX0010");
		Aktie cktie = new Aktie("ONeSW", 1001, "MSFT", "CHF", b, s, a, pl, "XXX0010");

		return titelRepository.findAll();
	}

	@RequestMapping(value = "/markets/titel", method = RequestMethod.GET)
	public ResponseEntity<List<Titel>> getTitels() {
		// Alle Karten aus dem Repository laden und der cards-Variable zuweisen
		List<Titel> titel = titelRepository.findAllByOrderByName();
		// Wenn die Liste Einträge enthält...
		if (titel != null && !titel.isEmpty()) {
			// ... dann diese als Body zurückgeben
			return new ResponseEntity(titel, HttpStatus.OK);
		} else {
			// ... ansonsten ResourceNotFoundException (404)
			return new ResponseEntity(HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/stocks")
	List<Titel> allTitel() {
		return titelRepository.findAll();
	}

	@PostMapping("/stocks")
	Titel newTitel(@RequestBody Titel newTitel) {
		return titelRepository.save(newTitel);
	}

	// Single stock
	@GetMapping("/stocks/{id}")
	Titel singleTitel(@PathVariable Long id) {
		return titelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find Titel" + id));
	}

}