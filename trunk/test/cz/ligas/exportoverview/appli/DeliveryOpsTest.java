/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class DeliveryOpsTest {

    public DeliveryOpsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDeliveriesFromClient method, of class DeliveryOps.
     */
    @Test
    public void testGetDeliveriesFromClient() throws Exception {
        System.out.println("getDeliveriesFromClient");
        Clients c = null;
        List expResult = null;
        List result = DeliveryOps.getDeliveriesFromClient(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveries method, of class DeliveryOps.
     */
    @Test
    public void testGetDeliveries() throws Exception {
        System.out.println("getDeliveries");
        List expResult = null;
        List result = DeliveryOps.getDeliveries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}