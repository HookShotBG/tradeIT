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

    @GetMapping("/dataloader")
    List<Aktienhandel> dataload1(){


        Boersenplatz b = new Boersenplatz("SIX Stock X", "SIX", "Switzerland");
        Sektor s = new Sektor("Technologie");
        Art a = new Art("Verschiedenes", "Technik");

        List<Preis> pl = new ArrayList<Preis>();

        Aktie aktie = new Aktie("Microsoft", 10002, "MSFT", "CHF", b, s, a, pl, "CH5949181045");



        String str="2020-03-31";
        Date sff=Date.valueOf(str);//converting string into sql date

        String str2="2020-04-01";
        Date sff1=Date.valueOf(str);//converting string into sql date


        //hier müssten .save mehtoden rein mit @autowired
        Preis p = new Preis(100, sff, sff1, aktie);
        pl.add(p);

        str="2020-04-01";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-02";
        sff1=Date.valueOf(str);//converting string into sql date


        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        p = new Preis(100, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-02";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-03";
        sff1=Date.valueOf(str2);//converting string into sql date
        p = new Preis(100.9, sff,sff1, aktie);
        pl.add(p);
        str="2020-04-03";
        sff=Date.valueOf(str2);//converting string into sql date

        str2="2020-04-04";
        sff1=Date.valueOf(str);//converting string into sql date
        p = new Preis(89.55, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-04";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-05";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(86.63, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-05";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-06";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(81.40, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-06";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-07";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(96.15, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-07";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-08";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(107.20, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-08";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-09";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(115.90, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-09";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-10";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.19, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-10";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-11";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(141, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-11";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-12";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(146, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-12";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-13";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(135.30, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-13";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-14";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(129.25, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-14";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-15";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(118.17, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-15";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-16";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(123.78, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-17";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(122.15, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-17";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-18";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(114, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-18";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-19";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(180, sff, sff1, aktie);
        pl.add(p);

        aktie.setPreis(pl);

        akr.save(aktie);

        List<User> ul = new ArrayList<>();
        User u = new User("dani", "el", "asdfasdf**", 10000, new Date(2001100800), "sadfZahl", new ArrayList<Aktienhandel>(), new ArrayList<Adresse>());
        User xxx = new User("some", "one", "asdfasdf**", 10000, new Date(2001100800), "sadfZahl", new ArrayList<Aktienhandel>(), new ArrayList<Adresse>());
        ul.add(u);
        ul.add(xxx);
        //u und xxx leben am selben ort
        List<Adresse> adr = new ArrayList<>();
        Adresse add = new Adresse("x-strasse","8000","Zürich", ul);

        adr.add(add);

        u.setAdresse(adr);


        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date
        Aktienhandel akh = new Aktienhandel((long) 5.333, 1000, 5, sff, 25, 125, aktie, u);

        akhr.save(akh);

        return akhr.findAll();
    }

    @GetMapping("/dataloader2")
    List<Aktienhandel> dataload2(){


        Boersenplatz b = new Boersenplatz("Nasdaq", "NSDQ", "USA");
        Sektor s = new Sektor("Technologie");
        Art a = new Art("Verschiedenes", "Technik");

        List<Preis> pl = new ArrayList<Preis>();

        Aktie aktie = new Aktie("AMD", 10002, "AMD", "USD", b, s, a, pl, "US5949181045");

        String str="2020-03-31";
        Date sff=Date.valueOf(str);//converting string into sql date

        String str2="2020-04-01";
        Date sff1=Date.valueOf(str);//converting string into sql date


        //hier müssten .save mehtoden rein mit @autowired
        Preis p = new Preis(116, sff, sff1, aktie);
        pl.add(p);

        str="2020-04-01";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-02";
        sff1=Date.valueOf(str);//converting string into sql date


        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        p = new Preis(104, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-02";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-03";
        sff1=Date.valueOf(str2);//converting string into sql date
        p = new Preis(100.9, sff,sff1, aktie);
        pl.add(p);
        str="2020-04-03";
        sff=Date.valueOf(str2);//converting string into sql date

        str2="2020-04-04";
        sff1=Date.valueOf(str);//converting string into sql date
        p = new Preis(71.66, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-04";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-05";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(73.52, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-05";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-06";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(73.91, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-06";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-07";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(75.15, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-07";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-08";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(65.16, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-08";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-09";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(62.17, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-09";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-10";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(59.51, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-10";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-11";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(51, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-11";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-12";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(48, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-12";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-13";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(46.71, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-13";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-14";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(44.12, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-14";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-15";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(48.51, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-15";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-16";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(42.49, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-17";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(67.19, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-17";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-18";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(89.41, sff, sff1, aktie);
        pl.add(p);
        str="2020-04-18";
        sff=Date.valueOf(str);//converting string into sql date

        str2="2020-04-19";
        sff1=Date.valueOf(str2);//converting string into sql date

        p = new Preis(16.51, sff, sff1, aktie);
        pl.add(p);

        aktie.setPreis(pl);

        akr.save(aktie);

        List<User> ul = new ArrayList<>();
        User u = new User("daniel", "nachoman", "CH10931X0", 10000, new Date(2001100800), "Maestro", new ArrayList<Aktienhandel>(), new ArrayList<Adresse>());
        User xxx = new User("hans", "mueller", "sadfx**", 10000, new Date(2001100800), "sadfZahl", new ArrayList<Aktienhandel>(), new ArrayList<Adresse>());
        ul.add(u);
        ul.add(xxx);
        //u und xxx leben am selben ort
        List<Adresse> adr = new ArrayList<>();
        Adresse add = new Adresse("Boulevard 66","8000","Zürich", ul);

        adr.add(add);

        u.setAdresse(adr);

        str="2020-04-16";
        sff=Date.valueOf(str);//converting string into sql date
        Aktienhandel akh = new Aktienhandel((long) 5.333, 1000, 5, sff, 25, 125, aktie, u);

        akhr.save(akh);

        return akhr.findAll();
    }


}
