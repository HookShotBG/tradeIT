package com.infom.tradeit.demo.entities;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Preis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPreis;
	
	private int preis;
	private Date valid_from;
	private Date valid_until;
	
	//do cardinality
	//@ManyToOne
	private Titel titel;

	public Preis(){}

	public Preis(int preis, Date valid_from, Date valid_until, Titel titel) {
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

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
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
