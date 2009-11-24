/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.WarehouseItem;
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
public class WarehouseItemOpsTest {

    public WarehouseItemOpsTest() {
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
     * Test of addWarehouseItem method, of class WarehouseItemOps.
     */
    @Test
    public void testAddWarehouseItem() throws Exception {
        System.out.println("addWarehouseItem");
        WarehouseItem warhouseItem = null;
        WarehouseItemOps.addWarehouseItem(warhouseItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWarehouseItemById method, of class WarehouseItemOps.
     */
    @Test
    public void testGetWarehouseItemById() throws Exception {
        System.out.println("getWarehouseItemById");
        long id = 0L;
        WarehouseItem expResult = null;
        WarehouseItem result = WarehouseItemOps.getWarehouseItemById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWarhouseItemByCategoryId method, of class WarehouseItemOps.
     */
    @Test
    public void testGetWarhouseItemByCategoryId() throws Exception {
        System.out.println("getWarhouseItemByCategoryId");
        int id = 0;
        List expResult = null;
        List result = WarehouseItemOps.getWarhouseItemByCategoryId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWarehouseItems method, of class WarehouseItemOps.
     */
    @Test
    public void testGetWarehouseItems() throws Exception {
        System.out.println("getWarehouseItems");
        List expResult = null;
        List result = WarehouseItemOps.getWarehouseItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editWarehouseItem method, of class WarehouseItemOps.
     */
    @Test
    public void testEditWarehouseItem() throws Exception {
        System.out.println("editWarehouseItem");
        WarehouseItem whi = null;
        int amount = 0;
        WarehouseItemOps.editWarehouseItem(whi, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}