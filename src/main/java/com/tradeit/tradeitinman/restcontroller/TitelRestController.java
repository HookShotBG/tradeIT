package com.tradeit.tradeitinman.restcontroller;


import com.tradeit.tradeitinman.entities.*;
import com.tradeit.tradeitinman.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */
@RestController
public class TitelRestController {
	@Autowired
	private TitelRepository titelRepository;

	@Autowired
    private AktienRepository aktienRepository;

	@GetMapping("/stocks")
    List<Titel> getAllStocks(){
        return titelRepository.findAll();
    }

    @GetMapping("/stockX")
    List<Aktie> getAll(){
        return aktienRepository.findAll();
    }

	@GetMapping("/stocky")
	List<Aktie> generateData() {

	    System.out.println("sadfasl");

		Preis p = new Preis(100, new Date(1999093), new Date(421341234));
		List<Preis> pl = new ArrayList<Preis>();
		pl.add(p);
		p = new Preis(100, new Date(421341234), new Date(512341234));
		pl.add(p);
		Boersenplatz b = new Boersenplatz("Nasdaq", "NASDQ", "USA");
		Sektor s = new Sektor("Technologie");
		Art a = new Art("Technologie", "Some random things");
        Aktie aktie = new Aktie("Microsoft", 1001, "MSFT", "CHF", b, s, a, pl, "XXX0010");

        p = new Preis(312, new Date(1999093), new Date(421341234));
        pl = new ArrayList<Preis>();
        pl.add(p);
        p = new Preis(108, new Date(421341234), new Date(512341234));
        pl.add(p);

		Aktie bktie = new Aktie("Teslik", 1001, "MSFT", "CHF", b, s, a, pl, "XXX0010");

        p = new Preis(1234, new Date(1999093), new Date(421341234));
        pl = new ArrayList<Preis>();
        pl.add(p);
        p = new Preis(9000, new Date(421341234), new Date(512341234));
        pl.add(p);

		Aktie cktie = new Aktie("mr fakes cookie monster shop", 1012, "MFCMS", "USD", b, s, a, pl, "XNXX");


		aktienRepository.save(aktie);
		aktienRepository.save(bktie);
		aktienRepository.save(cktie);

		return aktienRepository.findAll();
	}

	@RequestMapping(value = "/XXXXXX", method = RequestMethod.GET)
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

	/*
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
	}*/

}