/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.cashiermanager;

/**
 *
 * @author Lyn
 */
public interface Subject {

    public void addObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
//