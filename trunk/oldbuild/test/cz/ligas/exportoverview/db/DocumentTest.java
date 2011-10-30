package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class DocumentTest {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
    public DocumentTest() {
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
     * Test of getId method, of class Document.
     */

    @Test
    public void deliveryTest() {
        System.out.println("Delivery");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = em.find(Clients.class, 1);
        System.err.println(kl1);
        Delivery d = new Delivery();
        d.setClient(kl1);
        d.setTotal(12);
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

      @Test
    public void getDeliveryTest() {
        System.out.println("getDeliveryTest");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Delivery pc = em.find(Delivery.class, 1);
        assertTrue("null object Delivery", pc!=null);
        System.err.println(pc.toString());
        em.close();
    }

    @Test
    public void invoiceTest() {
        System.out.println("Invoice");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = em.find(Clients.class, 1);
        System.err.println(kl1);

        Invoice i = new Invoice();
        i.setClient(kl1);
        i.setTotal(12);
        em.persist(i);
        em.getTransaction().commit();
        em.close();
    }
          @Test
    public void getInvoiceTest() {
        System.out.println("getInvoiceTest");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Invoice inv = em.find(Invoice.class, 2);
        assertTrue("null object Invoice", inv!=null);
        System.err.println(inv.toString());
        em.close();
    }

       @Test
    public void documentInherTest() {
        System.out.println("documentInherTest");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = em.find(Clients.class, 1);
        assertTrue("null object Clinet", kl1!=null);
        System.err.println(kl1);

        Document d = new Delivery();
        Document i = new Invoice();
        d.setClient(kl1);
        d.setTotal(12);
        i.setClient(kl1);
        i.setTotal(12);
        em.persist(d);
        em.persist(i);
        em.getTransaction().commit();
        em.close();
    }
}
