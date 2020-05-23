package com.infom.tradeit.demo.dataloader;

import com.infom.tradeit.demo.entities.*;
import com.infom.tradeit.demo.restcontroller.AktienhandelRestController;
import com.infom.tradeit.demo.restcontroller.TitelRestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Dataloader {

    public Dataloader(){
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

        User u = new User("dani", "el", "asdfasdf**", 10000, new Date(10000000), "Penisroad", "sadfZahl", new ArrayList<Aktienhandel>());

        Aktienhandel akh = new Aktienhandel((long) 5.333, 1000, 5, new Date(100000), 25, 125, aktie, u);
        Aktienhandel bkh = new Aktienhandel((long) 5.333, 1000, 5, new Date(100000), 25, 125, bktie, u);
        Aktienhandel ckh = new Aktienhandel((long) 5.333, 1000, 5, new Date(100000), 25, 125, cktie, u);

    }

}
