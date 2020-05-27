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

	@GetMapping("/stocksY")
    List<Titel> getAllStocks(){
        return titelRepository.findAll();
    }

    @GetMapping("/stockX")
    List<Aktie> getAll(){
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

	// Single stock by id
	@GetMapping("/stocks/id/{id}")
	Titel singleTitelID(@PathVariable Long id) {
		return titelRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find Titel" + id));
	}

	// Single stock by name
	@GetMapping("/stocks/name/{name}")
	List<Titel> singleTitelName(@PathVariable String name) {
		List<Titel> t = titelRepository.findDistinctFirstByName(name);
		if(t.isEmpty() || t.size() == 0){
			return (List<Titel>) new RuntimeException("Could not find Titel" + name);
		}
		return t;
	}

	// Single stock by valor
	@GetMapping("/stocks/valor/{valor}")
	Titel singleTitelValor(@PathVariable int valor) {
		return titelRepository.findByValor(valor).orElseThrow(() -> new RuntimeException("Could not find Titel " + valor));
	}

	// Single stock by sektor
	@GetMapping("/stocks/currency")
	List<Titel> singleTitelSektor() {
		List<Titel> t = titelRepository.findAllByOrderByCurrencyAsc();
		if(t.isEmpty() || t.size() == 0){
			return (List<Titel>) new RuntimeException("Could not find Titel");
		}
		return t;
	}

	// Single stock by name which contains
	@GetMapping("/stocks/contains/{contains}")
	Titel titelwithName(@PathVariable String contains) {
		return titelRepository.findDistinctFirstByNameContaining(contains).orElseThrow(() -> new RuntimeException("Could not find Titel " + contains));
	}



}