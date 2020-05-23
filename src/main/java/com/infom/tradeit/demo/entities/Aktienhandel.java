package com.infom.tradeit.demo.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Aktienhandel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAktienhandel;

	private Long units;
	private int invested;
	private int transaktionskosten;
	private Date datum;
	private int stop_loss;
	private int take_profit;

	//foreignkeys
	@ManyToOne
	private Titel titel;

	@ManyToOne
	private User user;

	public Aktienhandel(){}

	public Aktienhandel(Long units, int invested, int transaktionskosten, Date datum, int stop_loss, int take_profit, Titel titel, User user) {
		this.units = units;
		this.invested = invested;
		this.transaktionskosten = transaktionskosten;
		this.datum = datum;
		this.stop_loss = stop_loss;
		this.take_profit = take_profit;
		this.titel = titel;
		this.user = user;
	}

	public Long getIdAktienhandel() {
		return idAktienhandel;
	}

	public void setIdAktienhandel(Long idAktienhandel) {
		this.idAktienhandel = idAktienhandel;
	}

	public Long getUnits() {
		return units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	public int getInvested() {
		return invested;
	}

	public void setInvested(int invested) {
		this.invested = invested;
	}

	public int getTransaktionskosten() {
		return transaktionskosten;
	}

	public void setTransaktionskosten(int transaktionskosten) {
		this.transaktionskosten = transaktionskosten;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getStop_loss() {
		return stop_loss;
	}

	public void setStop_loss(int stop_loss) {
		this.stop_loss = stop_loss;
	}

	public int getTake_profit() {
		return take_profit;
	}

	public void setTake_profit(int take_profit) {
		this.take_profit = take_profit;
	}


	public Titel getTitel() {
		return titel;
	}

	public void setTitel(Titel titel) {
		this.titel = titel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
