package com.tradeit.tradeitinman.restcontroller;

import com.tradeit.tradeitinman.entities.Boersenplatz;
import com.tradeit.tradeitinman.repositories.BoersenplatzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boerse")
public class BoersenplatzRestController {
    @Autowired
    BoersenplatzRepository br;

    @GetMapping("")
    public List<Boersenplatz> getAllBoerse(){
        return br.findAllByOrderByName();
    }

    //requestmapping needed instead of postmapping because of spring boot security (csrf needs to be disabled)
    @RequestMapping(value="/{name}/{kuerzel}/{land}", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Boersenplatz> createNewBoersenplatz(@PathVariable String name, @PathVariable String kuerzel, @PathVariable String land){
        Boersenplatz b = new Boersenplatz(name, kuerzel, land);
        br.save(b);
        return br.findAllByOrderByName();
    }

    @RequestMapping(value="/createDefault", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Boersenplatz> createDefaultBoersenplatz(){
        Boersenplatz b = new Boersenplatz("SIX Stock Exchange", "SIX", "Schweiz");
        br.save(b);
        return br.findAllByOrderByName();
    }

    @RequestMapping(value="/updateDefault", method = {RequestMethod.GET, RequestMethod.PUT})
    public List<Boersenplatz> updateDefaultBoersenplatz(){
        br.findByName("SIX Stock Exchange").map(
                boersenplatz -> {
                    boersenplatz.setName("Nasdaq Stock Exchange");
                    boersenplatz.setKuerzel("Nasdaq");
                    boersenplatz.setIdCountry("USA");
                    return br.save(boersenplatz);
                }
        );
        return br.findAllByOrderByName();
    }

    @RequestMapping(value="/{updateID}/{name}/{kuerzel}/{land}", method = {RequestMethod.GET, RequestMethod.PUT})
    public List<Boersenplatz> updateBoersenplatz(@PathVariable long updateID, @PathVariable String name, @PathVariable String kuerzel, @PathVariable String land){
        br.findById(updateID).map(
                boersenplatz -> {
                    boersenplatz.setName(name);
                    boersenplatz.setKuerzel(kuerzel);
                    boersenplatz.setIdCountry(land);
                    return br.save(boersenplatz);
                }
        );
        return br.findAllByOrderByName();
    }

    //rest services for curl commands (to add objects, since its quite hard to add objects in the url) -> basically the same as above

    //curl -X POST localhost:8080/boerse/newBoerse -H 'Content-type:application/json' -d '{"name": "Hongkong Stock X", "kuerzel": "HKG", "idCountry":"China"}'
    @RequestMapping(value="/newBoerse", method = {RequestMethod.GET, RequestMethod.POST})
    Boersenplatz newBoerse(@RequestBody Boersenplatz newBoerse) {
        return br.save(newBoerse);
    }

    //curl -X PUT -i --user dani:dani localhost:8080/boerse/{updateID} -H 'Content-type:application/json' -d '{"name": "Hongkong Stock Exchange", "kuerzel": "HKG", "idCountry":"China"}'
    //due to spring security curl is not working yet properly (HTTP 302)
    @RequestMapping(value="/{updateID}", method = {RequestMethod.GET, RequestMethod.PUT})
    public List<Boersenplatz> curlUpdateBoersenplatz(@PathVariable long updateID, @RequestBody Boersenplatz newBoersenplatz){
        br.findById(updateID).map(
                boersenplatz -> {
                    boersenplatz.setName(boersenplatz.getName());
                    boersenplatz.setKuerzel(boersenplatz.getKuerzel());
                    boersenplatz.setIdCountry(boersenplatz.getIdCountry());
                    return br.save(boersenplatz);
                }
        ).orElseGet(()->{
                newBoersenplatz.setIdBoersenplatz(updateID);
                return br.save(newBoersenplatz);}
        );
        return br.findAllByOrderByName();
    }

    @RequestMapping(value="/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public List<Boersenplatz> deleteBoerse(@PathVariable long id){
        br.deleteById(id);
        return br.findAll();
    }
}
