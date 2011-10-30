/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author miro
 */
public class DocumentLineTest {

    public DocumentLineTest() {
    }

    /**
     * Test of getId method, of class DocumentLine.
     */
    @Test
    public void deliveryLineTest() {
        System.out.println("deliveryLine");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
        Products pro = em.find(Products.class, 1);
        System.err.println(pro);
        Clients kl1 = em.find(Clients.class, 1);
        System.err.println(kl1);
        Delivery del = em.find(Delivery.class, 1);
        System.err.println(del);

        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        DeliveryLine dl = new DeliveryLine();
        dl.setAmount(35);
        dl.setPrice(Double.valueOf("55.5"));
        dl.setDocument(del);
        del.getDocumentLine().add(dl);
        em.persist(dl);
        em.merge(del);
        em.getTransaction().commit();
        em.close();
    }

        @Test
    public void invioceLineTest() {
        System.out.println("invoiceLineTest");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
        Products pro = em.find(Products.class, 1);
        System.err.println(pro);

        Clients kl1 = em.find(Clients.class, 1);
        System.err.println(kl1);

        Invoice i = em.find(Invoice.class, 2);
        System.err.println(i);

        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        InvoiceLine il = new InvoiceLine();
        il.setAmount(35);
        il.setPrice(Double.valueOf("55.5"));
        il.setDocument(i);
        i.getDocumentLine().add(il);
        em.persist(il);
        em.merge(i);
        em.getTransaction().commit();
        em.close();
    }

}