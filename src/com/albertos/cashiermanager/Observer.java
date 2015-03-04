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
public interface Observer {

    public void update(Date date);

    public void update(String cashier);
}