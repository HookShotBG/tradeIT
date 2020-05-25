package com.tradeit.tradeitinman.entities;

import javax.persistence.Entity;
import java.util.List;

/**
 *
 * Diese Klasse dient als erbbare Klasse -> Ein Titel wird gehandelt, dabei handelt es sich aber je nach Kauf
 * um eine Aktie, EFT, Currency. Dies wären folglich einzelne Klassen (bei dieser Umsetzung wird nur eine Klasse berücksichtigt)
 *
 * Einzig die Aktie besitzt den ISIN -> EFT's hätte beispeilsweise ein anderes Attribut.. etc.
 *
 */

@Entity
public class Aktie extends Titel{
    private String isin;

    public Aktie(){}

    public Aktie(String isin){
        this.isin=isin;
    }

    public Aktie(String name, int valor, String symbol, String currency, Boersenplatz boersenplatz, Sektor sektor, Art art, List<Preis> preis, String isin) {
        super(name, valor, symbol, currency, boersenplatz, sektor, art, preis);
        this.isin = isin;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
