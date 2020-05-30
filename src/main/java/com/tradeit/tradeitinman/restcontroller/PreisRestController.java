package com.tradeit.tradeitinman.restcontroller;

import com.tradeit.tradeitinman.entities.Preis;
import com.tradeit.tradeitinman.repositories.PreisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preis")
public class PreisRestController {

    @Autowired
    private PreisRepository pr;

    //adding preis with object from parameters
    @RequestMapping(value = "/secure/{preisId}", method = {RequestMethod.GET, RequestMethod.PUT})
    public Optional<Preis> addNewValueToPreis(@PathVariable long preisId, @RequestBody Preis preis){
        pr.findById(preisId).map(
                preisObject -> {
                    preisObject.setValid_until(preis.getValid_until());
                    preisObject.setValid_from(preis.getValid_from());
                    preisObject.setPreis(preis.getPreis());
                    preisObject.setTitel(preis.getTitel());
                    return pr.save(preisObject);
                }
        ).orElseGet(()->{
            preis.setIdPreis(preisId);
            return pr.save(preis);}
        );
        return pr.findById(preisId);
    }

    //add preis to the last titel
    @RequestMapping(value="/{preis}", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Preis> addNewPreisToLastTitel(@PathVariable int preis){
        //getting all just to get titel of the latest one
        List<Preis> pl = pr.findAll();
        //using default values (just selecting the titel -> bc i dont want it as parameter)
        Preis p = new Preis();
        p.setPreis(preis);
        p.setValid_from(pl.get(pl.size()-1).getValid_until());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(pl.get(pl.size()-1).getValid_until());
        c.add(Calendar.DATE, 1);
        p.setValid_until(c.getTime());

        p.setTitel(pl.get(pl.size()-1).getTitel());

        p.getTitel().getPreis().add(p);

        pr.save(p);
        return pr.findAll();
    }
}
