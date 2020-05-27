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

    @GetMapping("/dataloader1")
    List<Aktienhandel> dataload1(){

        String str="2020-03-31";
        Date sff=Date.valueOf(str);//converting string into sql date

        String str2="2020-04-01";
        Date sff1=Date.valueOf(str);//converting string into sql date


        //hier müssten .save mehtoden rein mit @autowired
        Preis p = new Preis(100, sff, sff1);
        List<Preis> pl = new ArrayList<Preis>();
        pl.add(p);

        str="2020-04-01";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-02";
        sff1=Date.valueOf(str);//converting string into sql date


        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        p = new Preis(100, sff, sff1);
        pl.add(p);
        str="2020-04-02";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-03";
        sff1=Date.valueOf(str2);//converting string into sql date
        p = new Preis(100.9, sff,sff1);
        pl.add(p);
        str="2020-04-03";
        sff=Date.valueOf(str2);//converting string into sql date

        str2="2020-04-04";
        sff1=Date.valueOf(str);//converting string into sql date
        p = new Preis(89.55, sff, sff1);
        pl.add(p);
        str="2020-04-04";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-05";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(86.63, sff, sff1);
        pl.add(p);
        str="2020-04-05";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-06";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(81.40, sff, sff1);
        pl.add(p);
        str="2020-04-06";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-07";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(96.15, sff, sff1);
        pl.add(p);
        str="2020-04-07";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-08";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(107.20, sff, sff1);
        pl.add(p);
        str="2020-04-08";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-09";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(115.90, sff, sff1);
        pl.add(p);
        str="2020-04-09";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-10";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.19, sff, sff1);
        pl.add(p);
        str="2020-04-10";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-11";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(141, sff, sff1);
        pl.add(p);
        str="2020-04-11";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-12";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(146, sff, sff1);
        pl.add(p);
        str="2020-04-12";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-13";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.30, sff, sff1);
        pl.add(p);
        str="2020-04-13";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-14";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(129.25, sff, sff1);
        pl.add(p);
        str="2020-04-14";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-15";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(118.17, sff, sff1);
        pl.add(p);
        str="2020-04-15";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-16";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(123.78, sff, sff1);
        pl.add(p);
        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-17";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(122.15, sff, sff1);
        pl.add(p);
        str="2020-04-17";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-18";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(114, sff, sff1);
        pl.add(p);
        str="2020-04-18";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-19";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(180, sff, sff1);
        pl.add(p);
        Boersenplatz b = new Boersenplatz("SIX Stock X", "SIX", "Switzerland");
        Sektor s = new Sektor("Technologie");
        Art a = new Art("Verschiedenes", "Technik");

        Aktie aktie = new Aktie("Microsoft", 10002, "MSFT", "CHF", b, s, a, pl, "CH5949181045");

        akr.save(aktie);

        User u = new User("dani", "el", "asdfasdf**", 10000, new Date(2001100800), "Dickinson", "sadfZahl", new ArrayList<Aktienhandel>());

        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date
        Aktienhandel akh = new Aktienhandel((long) 5.333, 1000, 5, sff, 25, 125, aktie, u);

        akhr.save(akh);

        return akhr.findAll();
    }

    @GetMapping("/dataloader2")
    List<Aktienhandel> dataload2(){

        String str="2020-01-31";
        Date sff=Date.valueOf(str);//converting string into sql date

        String str2="2020-04-01";
        Date sff1=Date.valueOf(str);//converting string into sql date


        //hier müssten .save mehtoden rein mit @autowired
        Preis p = new Preis(80, sff, sff1);
        List<Preis> pl = new ArrayList<Preis>();
        pl.add(p);

        str="2020-04-01";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-02";
        sff1=Date.valueOf(str);//converting string into sql date


        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        p = new Preis(81, sff, sff1);
        pl.add(p);
        str="2020-04-02";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-03";
        sff1=Date.valueOf(str2);//converting string into sql date
        p = new Preis(85, sff,sff1);
        pl.add(p);
        str="2020-04-03";
        sff=Date.valueOf(str2);//converting string into sql date

        str2="2020-04-04";
        sff1=Date.valueOf(str);//converting string into sql date
        p = new Preis(89.55, sff, sff1);
        pl.add(p);
        str="2020-04-04";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-05";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(86.63, sff, sff1);
        pl.add(p);
        str="2020-04-05";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-06";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(81.40, sff, sff1);
        pl.add(p);
        str="2020-04-06";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-07";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(96.15, sff, sff1);
        pl.add(p);
        str="2020-04-07";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-08";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(112.20, sff, sff1);
        pl.add(p);
        str="2020-04-08";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-09";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(115.90, sff, sff1);
        pl.add(p);
        str="2020-04-09";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-10";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.19, sff, sff1);
        pl.add(p);
        str="2020-04-10";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-11";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(140, sff, sff1);
        pl.add(p);
        str="2020-04-11";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-12";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(146, sff, sff1);
        pl.add(p);
        str="2020-04-12";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-13";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.30, sff, sff1);
        pl.add(p);
        str="2020-04-13";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-14";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(129.25, sff, sff1);
        pl.add(p);
        str="2020-04-14";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-15";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(200, sff, sff1);
        pl.add(p);
        str="2020-04-15";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-16";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(180.85, sff, sff1);
        pl.add(p);
        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-17";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(164.20, sff, sff1);
        pl.add(p);
        str="2020-04-17";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-18";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(114, sff, sff1);
        pl.add(p);
        str="2020-04-18";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-19";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(125, sff, sff1);
        pl.add(p);
        Boersenplatz b = new Boersenplatz("SIX Stock X", "SIX", "Switzerland");
        Sektor s = new Sektor("Technologie");
        Art a = new Art("Verschiedenes", "Technik");

        Aktie aktie = new Aktie("APPLE", 10002, "APPL", "CHF", b, s, a, pl, "CH1243456789");

        akr.save(aktie);

        User u = new User("ryan", "test", "asdfasdf**", 10000, new Date(2001100800), "Dickinson", "abcd", new ArrayList<Aktienhandel>());

        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date
        Aktienhandel akh = new Aktienhandel((long) 5.333, 1500, 6, sff, 100, 180, aktie, u);

        akhr.save(akh);

        return akhr.findAll();
    }


}
