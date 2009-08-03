/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xligas
 */
public class Main {

    public static void main(String[] args) {

        Clients c = new Clients();
        c.setClientName("Jozo");
        c.setClientAddress("stred 55, zazka");
        c.setClientPhone("7777777777");

        try {
            ClientOps.addClient(c);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
