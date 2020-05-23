package com.infom.tradeit.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	//do cardinality
	private Long idUser;
	//do cardinality
	private Long idTitel;

	
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdTitel() {
		return idTitel;
	}

	public void setIdTitel(Long idTitel) {
		this.idTitel = idTitel;
	}
	
	
	
	
}
