/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ExportLineOpsTest {

    public ExportLineOpsTest() {
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
     * Test of addExportLine method, of class ExportLineOps.
     */
    @Test
    public void testAddExportLine() throws Exception {
        System.out.println("addExportLine");
        ExportLine exportLine = null;
        ExportLineOps.addExportLine(exportLine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExportLineById method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLineById() throws Exception {
        System.out.println("getExportLineById");
        int id = 0;
        ExportLine expResult = null;
        ExportLine result = ExportLineOps.getExportLineById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExportLinesByExport method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLinesByExport() {
        System.out.println("getExportLinesByExport");
        Clients e = null;
        List expResult = null;
        List result;
        try {
            result = ExportLineOps.getExportLinesByClient(e);
             assertEquals(expResult, result);
        } catch (Exception ex) {
            Logger.getLogger(ExportLineOpsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExportLine method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLine() throws Exception {
        System.out.println("getExportLine");
        List expResult = null;
        List result = ExportLineOps.getExportLine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editExportLine method, of class ExportLineOps.
     */
    @Test
    public void testEditExportLine() {
        System.out.println("editExportLine");
        Clients exp = null;
        ExportLine exportLine = null;
        int sent = 0;
        int sold = 0;
        float price = 0.0F;
        try {
            ExportLineOps.editExportLine(exp, exportLine, sent, sold, price);
        } catch (Exception ex) {
            Logger.getLogger(ExportLineOpsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}