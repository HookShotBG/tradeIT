package com.tradeit.tradeitinman.dataloader;

import com.tradeit.tradeitinman.entities.*;
import com.tradeit.tradeitinman.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Dataloader {

    @Autowired
    ArtRepository ar;

    @Autowired
    BoersenplatzRepository br;

    @Autowired
    PreisRepository pr;

    @Autowired
    SektorRepository sr;

    @Autowired
    TitelRepository tr;

    @Autowired
    AktienhandelRepository akhr;

    @Autowired
    AktienRepository akr;

    public Dataloader(){

    }

    @GetMapping("/dataloader")
    List<Aktienhandel> dataload(){

        //hier müssten .save mehtoden rein mit @autowired
        Preis p = new Preis(100, new Date(1999093), new Date(421341234));
        List<Preis> pl = new ArrayList<Preis>();
        pl.add(p);
        p = new Preis(100, new Date(1589068800), new Date(1989068800));
        pl.add(p);
        p = new Preis(100.9, new Date(1989068800), new Date(1989999800));
        pl.add(p);
        p = new Preis(89.55, new Date(1989999800), new Date(2000000000));
        pl.add(p);
        p = new Preis(86.63, new Date(2000100800), new Date(2001000000));
        pl.add(p);
        p = new Preis(81.40, new Date(2001100800), new Date(2020040100));
        pl.add(p);
        p = new Preis(96.15, new Date(2020040100), new Date(2020040110));
        pl.add(p);
        p = new Preis(107.20, new Date(2020040120), new Date(2120040000));
        pl.add(p);
        p = new Preis(115.90, new Date(2120040120), new Date(2120040000));
        pl.add(p);
        p = new Preis(135.19, new Date(2120040120), new Date(2120042000));
        pl.add(p);
        p = new Preis(141, new Date(2120042001), new Date(2120052000));
        pl.add(p);
        p = new Preis(146, new Date(2120052001), new Date(2140052000));
        pl.add(p);
        p = new Preis(135.30, new Date(2140052001), new Date(2147052000));
        pl.add(p);
        p = new Preis(129.25, new Date(2147052001), new Date(2147452000));
        pl.add(p);
        p = new Preis(118.17, new Date(2147452001), new Date(2147482000));
        pl.add(p);
        p = new Preis(123.78, new Date(2147482001), new Date(2147483000));
        pl.add(p);
        p = new Preis(122.15, new Date(2147483001), new Date(2147483600));
        pl.add(p);
        p = new Preis(114, new Date(2147483601), new Date(2147483640));
        pl.add(p);
        p = new Preis(180, new Date(2147483641), new Date(2147483647));
        pl.add(p);
        Boersenplatz b = new Boersenplatz("SIX Stock X", "SIX", "Switzerland");
        Sektor s = new Sektor("Technologie");
        Art a = new Art("Verschiedenes", "Technik");

        Aktie aktie = new Aktie("TradeIT", 4999, "TRIT", "CHF", b, s, a, pl, "CH5949181045");

        akr.save(aktie);

        User u = new User("dani", "el", "asdfasdf**", 10000, new Date(2001100800), "Dickinson", "sadfZahl", new ArrayList<Aktienhandel>());

        Aktienhandel akh = new Aktienhandel((long) 5.333, 1000, 5, new Date(100000), 25, 125, aktie, u);

        akhr.save(akh);

        return akhr.findAll();
    }

}
