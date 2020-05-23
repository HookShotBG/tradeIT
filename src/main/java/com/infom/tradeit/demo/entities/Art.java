package com.infom.tradeit.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Art {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArt;
	
	private String name;
	private String beschreibung;

	public Art(){}

	public Art(String name, String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;
	}

	public Long getIdArt() {
		return idArt;
	}
	public void setIdArt(Long idArt) {
		this.idArt = idArt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	


}
