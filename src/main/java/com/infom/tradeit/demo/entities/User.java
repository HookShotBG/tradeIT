package com.infom.tradeit.demo.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	private String vorname;
	private String nachname;
	private String identitaetskartennr;
	private int guthaben;
	private Date geburtsdatum;
	
	//do cardinality
	private Long idAdresse;
	//do cardinality
	private Long idZahlungsinformation;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getIdentitaetskartennr() {
		return identitaetskartennr;
	}
	public void setIdentitaetskartennr(String identitaetskartennr) {
		this.identitaetskartennr = identitaetskartennr;
	}
	public int getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(int guthaben) {
		this.guthaben = guthaben;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
	public Long getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}
	public Long getIdZahlungsinformation() {
		return idZahlungsinformation;
	}
	public void setIdZahlungsinformation(Long idZahlungsinformation) {
		this.idZahlungsinformation = idZahlungsinformation;
	}
	
	
}
