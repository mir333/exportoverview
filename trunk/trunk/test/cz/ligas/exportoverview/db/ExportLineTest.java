package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author miro
 */
public class ExportLineTest {

    public ExportLineTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ExportLine.
     */
    @Test
    public void exportLineTest() {
        System.out.println("exportLineTest");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();

        Products pro = em.find(Products.class, 1);
        System.err.println(pro);
        Products prod = em.find(Products.class, 2);
        System.err.println(pro);

        ExportLine el = new ExportLine();
        el.setSent(6);
        el.setSold(3);
        el.setProd(pro);
        System.err.println("exp " + el.toString());
        ExportLine el2 = new ExportLine();
        el2.setProd(pro);
        el2.setSent(1);
        el2.setSold(2);
        System.err.println("exp " + el2.toString());
        ExportLine el3 = new ExportLine();
        el3.setProd(prod);
        el3.setSent(3);
        el3.setSold(4);
        System.err.println("exp " + el3.toString());


        Clients kl1 = em.find(Clients.class, 1);
        System.err.println(kl1.toString());
        Clients kl2 = em.find(Clients.class, 2);
        System.err.println(kl2.toString());

        kl1.getExportLines().add(el);
        el.setClient(kl1);
        kl2.getExportLines().add(el);
        el.setClient(kl2);
        kl1.getExportLines().add(el2);
        el2.setClient(kl1);
        kl1.getExportLines().add(el3);
        el3.setClient(kl1);

        em.persist(el);
        em.persist(el2);
        em.persist(el3);
        em.merge(kl1);
        em.merge(kl2);
        em.getTransaction().commit();
        em.close();
//
    }

}