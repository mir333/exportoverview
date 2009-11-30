/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class DeliveryOpsTest {

    public DeliveryOpsTest() {
    }

    /**
     * Test of getDeliveriesFromClient method, of class DeliveryOps.
     */
    @Test
    public void testGetDeliveriesFromClient() throws Exception {
        System.out.println("getDeliveriesFromClient");
        Clients c = new Clients();
        c.setId(1);
        List result = DeliveryOps.getDeliveriesFromClient(c);
        assertTrue("list is pmpty", result.size() != 0);
    }

    /**
     * Test of getDeliveries method, of class DeliveryOps.
     */
    @Test
    public void testGetDeliveries() throws Exception {
        System.out.println("getDeliveries");
        List result = DeliveryOps.getDeliveries();
        assertTrue("list is pmpty", result.size() != 0);
    }


    @Test
    public void testEditDeliveryLine() throws Exception {
        System.out.println("EditDeliveryLine");
        
    }
}
