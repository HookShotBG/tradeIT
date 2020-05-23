package com.infom.tradeit.demo.entities;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

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
	private String idAdresse;
	//do cardinality
	private String zahlungsinformation;

	@OneToMany
	private List<Aktienhandel> aktienhandel;

	public User() {
	}


	public User(String vorname, String nachname, String identitaetskartennr, int guthaben, Date geburtsdatum, String idAdresse, String zahlungsinformation, List<Aktienhandel> aktienhandel) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.identitaetskartennr = identitaetskartennr;
		this.guthaben = guthaben;
		this.geburtsdatum = geburtsdatum;
		this.idAdresse = idAdresse;
		this.zahlungsinformation = zahlungsinformation;
		this.aktienhandel = aktienhandel;
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
	public String getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(String idAdresse) {
		this.idAdresse = idAdresse;
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
}
