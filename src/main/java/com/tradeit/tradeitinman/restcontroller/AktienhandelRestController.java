package com.tradeit.tradeitinman.restcontroller;


import com.tradeit.tradeitinman.entities.Aktienhandel;
import com.tradeit.tradeitinman.repositories.AktienhandelRepository;
import com.tradeit.tradeitinman.repositories.PreisRepository;
import com.tradeit.tradeitinman.repositories.TitelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * 
 * REST-Controller für die Ressource Titel
 * 
 */

@RestController
public class AktienhandelRestController {
	@Autowired
	private AktienhandelRepository aktienRepository;

	@Autowired
	private TitelRepository tr;

	@Autowired
	private PreisRepository pr;

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

	@GetMapping("/portfolioDetails")
	public List<Aktienhandel> getDetail(){
		//select akh.invested, akh.datum, akh.stop_loss, akh.take_profit, t.name, p.preis from aktienhandel akh inner join  titel t on akh.titel_id_titel=t.id_titel inner join preis p on akh.datum=p.valid_from inner join titel_preis tp on tp.titel_id_titel=t.id_titel and tp.preis_id_preis=p.id_preis;
		// 3 queries needed -> to fetch Aktienhandel infos, to fetch titel infos and preis infos
		List<Aktienhandel> akr = aktienRepository.getDetailsfromAktienhandel();
		return akr;
	}

	@GetMapping("/singleAktienhandel/{id}")
	public Optional<Aktienhandel> getSingleHandel(@PathVariable(value="id") long id){
		Optional<Aktienhandel> akh = aktienRepository.findByIdAktienhandel(id);
		return akh;
	}

}