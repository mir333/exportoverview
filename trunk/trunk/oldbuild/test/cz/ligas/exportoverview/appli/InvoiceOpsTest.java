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
public class InvoiceOpsTest {

    public InvoiceOpsTest() {
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
     * Test of getInvoicesFromClient method, of class InvoiceOps.
     */
    @Test
    public void testGetInvoicesFromClient() throws Exception {
        System.out.println("getInvoicesFromClient");
        Clients c = null;
        List expResult = null;
        List result = InvoiceOps.getInvoicesFromClient(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoices method, of class InvoiceOps.
     */
    @Test
    public void testGetInvoices() throws Exception {
        System.out.println("getInvoices");
        List expResult = null;
        List result = InvoiceOps.getInvoices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}