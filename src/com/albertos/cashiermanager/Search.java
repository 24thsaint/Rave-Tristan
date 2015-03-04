/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albertos.cashiermanager;

import com.albertos.controllers.CashierJpaController;
import com.albertos.controllers.EMFactory;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lyn
 */
public class Search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        SearchFrame searchFrame = new SearchFrame();
        CashierJpaController cjc = new CashierJpaController(EMFactory.getEmf());

        Cashier cashier = new Cashier();
        cashier.setCashierName("Tristan");
        cashier.setLoginDate(new Date());
        Thread.sleep(5000);
        cashier.setLogoutDate(new Date());
        Cashier cashier1 = new Cashier();
        Thread.sleep(5000);
        cashier1.setCashierName("Quim");
        cashier1.setLoginDate(new Date());
        Thread.sleep(10000);
        cashier1.setLogoutDate(new Date());

        cjc.create(cashier);
        cjc.create(cashier1);
        for (Cashier c : cjc.findCashierEntities()) {
            System.out.println(c.getCashierName());
            System.out.println(c.getLoginDate());
            System.out.println(c.getLogoutDate());
        }

//        ----- Create database entries
//        Cashier cashier = new Cashier();
//        cashier.setCashierName("Rave");
//        cashier.setLoginDate(new Date());
//        Thread.sleep(5000);
//        cashier.setLogoutDate(new Date());
//        
//        Thread.sleep(2000);
//        
//        Cashier cashier2 = new Cashier();
//        cashier2.setCashierName("Steven");
//        cashier2.setLoginDate(new Date());
//        Thread.sleep(5000);
//        cashier2.setLogoutDate(new Date());
//        
//        cjc.create(cashier);
//        cjc.create(cashier2);
//        
//        System.out.println("Cashiers created!");
//         ---- end creation
        // retrieval of entries -------
        List<Cashier> cashiers = cjc.findCashierEntities();

        for (Cashier c : cashiers) {
            searchFrame.addEntry(c);
        }
        // ---- end retrieval

        searchFrame.show();
    }
}
