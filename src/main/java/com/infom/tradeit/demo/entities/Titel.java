package com.infom.tradeit.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Titel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTitel;
	
	private String name;
	private int valor;
	private String isin;
	private String symbol;
	private String currency;
	
	//do cardinality
	private Long idBoersenplatz;
	//do cardinality
	private Long idArt;
	//do cardinality
	private Long idSektor;
	
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
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
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
	public Long getIdBoersenplatz() {
		return idBoersenplatz;
	}
	public void setIdBoersenplatz(Long idBoersenplatz) {
		this.idBoersenplatz = idBoersenplatz;
	}
	public Long getIdArt() {
		return idArt;
	}
	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}
	public Long getIdSektor() {
		return idSektor;
	}
	public void setIdSektor(Long idSektor) {
		this.idSektor = idSektor;
	}

	
	
}
