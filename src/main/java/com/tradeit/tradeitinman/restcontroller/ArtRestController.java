package com.tradeit.tradeitinman.restcontroller;

import com.tradeit.tradeitinman.entities.Art;
import com.tradeit.tradeitinman.repositories.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Art")
public class ArtRestController {

    @Autowired
    private ArtRepository ar;

    //0815 Rest Service Calls mit curl statement provided

    // curl -X GET localhost:8080/Art
    @GetMapping("")
    public List<Art> getAllArten(){
        return ar.findAll();
    }

    //curl -X POST localhost:8080/Art -H 'Content-type:application/json' -d '{"name": "Technologie", "beschreibung": "Hier kommt eine Beschreibung rein"}'
    @PostMapping("")
    public List<Art> addArt(@RequestBody Art art){
        ar.save(art);
        return ar.findAll();
    }

    //curl -X PUT localhost:8080/Art/5 -H 'Content-type:application/json' -d '{"name": "Finanzsektor", "beschreibung": "Hier kommt eine Beschreibung rein"}'
    @PutMapping("/{changeID}")
    public Optional<Art> changeArt(@PathVariable long changeID, @RequestBody Art art){
        ar.findById(changeID).map(
                artObject -> {
                    artObject.setName(art.getName());
                    artObject.setBeschreibung(art.getBeschreibung());
                    return ar.save(artObject);
                }
        ).orElseGet(()->{
            art.setIdArt(changeID);
            return ar.save(art);}
        );
        return ar.findById(changeID);
    }

    //curl -X DELETE localhost:8080/Art/2
    @DeleteMapping("/{deleteID}")
    public List<Art> deleteArt(@PathVariable long deleteID){
        ar.deleteById(deleteID);
        return ar.findAll();
    }

}
