package com.tradeit.tradeitinman.entities;

import java.util.Date;

public class Trade {

    String titel;
    String user;
    Date datum;
    int invested;
    int take_profit;
    int stop_loss;
    double preis;
    Long units;
    double current;
    double currentPreis;
    String calcChange;

    public Trade(){}

    public Trade(String titel, String user, Date datum, int invested, int take_profit, int stop_loss, double preis, Long units, double current, double currentPreis, String calcChange) {
        this.titel = titel;
        this.user = user;
        this.datum = datum;
        this.invested = invested;
        this.take_profit = take_profit;
        this.stop_loss = stop_loss;
        this.preis = preis;
        this.units = units;
        this.current = current;
        this.currentPreis = currentPreis;
        this.calcChange = calcChange;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getInvested() {
        return invested;
    }

    public void setInvested(int invested) {
        this.invested = invested;
    }

    public int getTake_profit() {
        return take_profit;
    }

    public void setTake_profit(int take_profit) {
        this.take_profit = take_profit;
    }

    public int getStop_loss() {
        return stop_loss;
    }

    public void setStop_loss(int stop_loss) {
        this.stop_loss = stop_loss;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getCurrentPreis() {
        return currentPreis;
    }

    public void setCurrentPreis(double currentPreis) {
        this.currentPreis = currentPreis;
    }

    public void setCalcChange(String c){
        this.calcChange = c;
    }
    public String getCalcChange(){
        return calcChange;
    }
}
