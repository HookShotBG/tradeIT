package com.infom.tradeit.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boersenplatz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBoersenplatz;
	
	private String name;
	private String kuerzel;
	private String idCountry;

	public Boersenplatz(){}

	public Boersenplatz(String name, String kuerzel, String idCountry) {
		this.name = name;
		this.kuerzel = kuerzel;
		this.idCountry = idCountry;
	}

	public Long getIdBoersenplatz() {
		return idBoersenplatz;
	}

	public void setIdBoersenplatz(Long idBoersenplatz) {
		this.idBoersenplatz = idBoersenplatz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}
	
	
}
