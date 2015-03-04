/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.cashiermanager;

import java.util.Date;

/**
 *
 * @author Lyn
 */
public class ShowCashier implements Observer {

    private String cashier;
    private Date date;
    private Subject cashiers;

    public ShowCashier(Subject cashiers) {
        this.cashiers = cashiers;
        cashiers.addObserver(this);
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void update(Date date) {
        this.date = date;
    }

    @Override
    public void update(String cashier) {
        this.cashier = cashier;
    }

    public void display() {

        System.out.println("Current cashier" + cashier);

        System.out.println("Cashier:" + date);
    }
}
