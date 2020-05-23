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
	
	//do cardinality
	private Long idCountry;

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

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}
	
	
}
