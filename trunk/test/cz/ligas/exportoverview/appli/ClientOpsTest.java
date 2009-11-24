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
public class ClientOpsTest {

    public ClientOpsTest() {
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
     * Test of addClient method, of class ClientOps.
     */
    @Test
    public void testAddClient() throws Exception {
        System.out.println("addClient");
        Clients client = new Clients();
        client.setClientName("fero");
        client.setClientAddress("fdsfs");
        client.setClientPhone("111111");
        ClientOps.addClient(client);
        
    }

    /**
     * Test of getClients method, of class ClientOps.
     */
    @Test
    public void testGetClients() throws Exception {
        System.out.println("getClients");
        List result = ClientOps.getClients();
        assertTrue("empty categorys",result.size()!=0);
        System.out.println("list length = " + result.size());
    }

}