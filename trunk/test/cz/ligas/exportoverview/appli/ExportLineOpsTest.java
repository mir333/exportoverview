/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import cz.ligas.exportoverview.db.Products;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class ExportLineOpsTest {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public ExportLineOpsTest() {
    }

    /**
     * Test of addExportLine method, of class ExportLineOps.
     */
    @Test
    public void testAddExportLine() throws Exception {
        System.out.println("addExportLine");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Products prod = em.find(Products.class, 1);
        assertTrue("Product is empty", prod != null);
        Clients kl1 = em.find(Clients.class, 1);
        assertTrue("Client is empty", kl1 != null);
        ExportLine el = new ExportLine();
        el.setProd(prod);
        el.setSent(3);
        el.setSold(4);

        kl1.getExportLines().add(el);
        el.setClient(kl1);
        ExportLineOps.addExportLine(el);
    }

    /**
     * Test of getExportLineById method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLineById() throws Exception {
        System.out.println("getExportLineById");
        int id = 1;
        ExportLine result = ExportLineOps.getExportLineById(id);
        assertTrue("field is empty", result != null);
    }

    /**
     * Test of getExportLine method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLine() throws Exception {
        System.out.println("getExportLine");
        List result = ExportLineOps.getExportLine();
        assertTrue("field is empty", result != null);
    }

    /**
     * Test of editExportLine method, of class ExportLineOps.
     */
    @Test
    public void testEditExportLine() {
        System.out.println("editExportLine");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients c = em.find(Clients.class, 1);
        assertTrue("klient is null", c != null);
        em.getTransaction().commit();
        em.close();
        int sent = 4;
        int sold = 5;
        double price = 1000.0;
        try {
            List result = ExportLineOps.getExportLinesByClient(c);
            assertTrue("list is empty", result.size() != 0);
            ExportLine expln = (ExportLine) result.get(0);
            ExportLineOps.editExportLine(expln, sent, sold, price);
        } catch (Exception ex) {
            Logger.getLogger(ExportLineOpsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getExportLinesByClient method, of class ExportLineOps.
     */
    @Test
    public void testGetExportLinesByClient() throws Exception {
        System.out.println("getExportLinesByClient");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = em.find(Clients.class, 1);
        assertTrue("klient is null", kl1 != null);
        List result = ExportLineOps.getExportLinesByClient(kl1);
        assertTrue("list is empty", result.size() != 0);
        em.getTransaction().commit();
        em.close();
    }
}
