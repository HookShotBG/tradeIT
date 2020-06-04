package com.tradeit.tradeitinman.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	private String vorname;
	private String nachname;
	private String identitaetskartennr;
	private double guthaben;
	private Date geburtsdatum;

	//do cardinality
	private String zahlungsinformation;

	@OneToMany
	private List<Aktienhandel> aktienhandel;

	@ManyToMany
	private List<Adresse> adresse;

	public User() {
	}



	public User(String vorname, String nachname, String identitaetskartennr, int guthaben, Date geburtsdatum, String zahlungsinformation, List<Aktienhandel> aktienhandel, List<Adresse> adresse) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.identitaetskartennr = identitaetskartennr;
		this.guthaben = guthaben;
		this.geburtsdatum = geburtsdatum;
		this.zahlungsinformation = zahlungsinformation;
		this.aktienhandel = aktienhandel;
		this.adresse = adresse;
	}

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
	public double getGuthaben() {
		return guthaben;
	}
	public void setGuthaben(double guthaben) {
		this.guthaben = guthaben;
	}
	public Date getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getZahlungsinformation() {
		return zahlungsinformation;
	}

	public void setZahlungsinformation(String zahlungsinformation) {
		zahlungsinformation = zahlungsinformation;
	}

	public List<Aktienhandel> getAktienhandel() {
		return aktienhandel;
	}

	public void setAktienhandel(List<Aktienhandel> aktienhandel) {
		this.aktienhandel = aktienhandel;
	}

	public List<Adresse> getAdresse() {return adresse;	}
	public void setAdresse(List<Adresse> adresse) {this.adresse = adresse;}
}
