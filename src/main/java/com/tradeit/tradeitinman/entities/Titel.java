package com.tradeit.tradeitinman.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Titel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTitel;
	
	private String name;
	private int valor;
	private String symbol;
	private String currency;

	//foreign keys
	@ManyToOne
	private Boersenplatz boersenplatz;

	@ManyToOne
	private Sektor sektor;

	@ManyToOne
	private Art art;

	@OneToMany
	private List<Preis> preis;

	public Titel(){

	}

	public Titel(String name, int valor, String symbol, String currency, Boersenplatz boersenplatz, Sektor sektor, Art art, List<Preis> preis) {
		this.name = name;
		this.valor = valor;
		this.symbol = symbol;
		this.currency = currency;
		this.boersenplatz = boersenplatz;
		this.sektor = sektor;
		this.art = art;
		this.preis = preis;
	}

	public Long getIdTitel() {
		return idTitel;
	}
	public void setIdTitel(Long idTitel) {
		this.idTitel = idTitel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boersenplatz getBoersenplatz() {
		return boersenplatz;
	}

	public void setBoersenplatz(Boersenplatz boersenplatz) {
		this.boersenplatz = boersenplatz;
	}

	public Sektor getSektor() {
		return sektor;
	}

	public void setSektor(Sektor sektor) {
		this.sektor = sektor;
	}

	public Art getArt() {
		return art;
	}

	public void setArt(Art art) {
		this.art = art;
	}

	public List<Preis> getPreis() {
		return preis;
	}

	public void setPreis(List<Preis> preis) {
		this.preis = preis;
	}
}
