package com.tradeit.tradeitinman.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Preis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPreis;
	
	private double preis;
	private Date valid_from;
	private Date valid_until;

	@JsonIgnore
	@ManyToOne
	private Titel titel;

	public Preis(){}

	public Preis(double preis, Date valid_from, Date valid_until, Titel titel) {
		this.preis = preis;
		this.valid_from = valid_from;
		this.valid_until = valid_until;
		this.titel = titel;
	}

	public Long getIdPreis() {
		return idPreis;
	}

	public void setIdPreis(Long idPreis) {
		this.idPreis = idPreis;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_until() {
		return valid_until;
	}

	public void setValid_until(Date valid_until) {
		this.valid_until = valid_until;
	}

	public Titel getTitel() {
		return titel;
	}

	public void setTitel(Titel titel) {
		this.titel = titel;
	}
}
