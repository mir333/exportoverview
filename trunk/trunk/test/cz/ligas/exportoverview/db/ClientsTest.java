package cz.ligas.exportoverview.db;

import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author miro
 */
public class ClientsTest {

    public ClientsTest() {
    }

    @Test
    public void createClientTest(){
        System.out.println("createClientTest");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
         em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = new Clients();
        kl1.setClientName("fero");
        kl1.setClientAddress("fdsfs");
        kl1.setClientPhone("111111");
        System.err.println("klient " + kl1.toString());
        Clients kl2 = new Clients();
        kl2.setClientName("jozo");
        kl2.setClientAddress("fdsfs");
        kl2.setClientPhone("2222");
        System.err.println("klient " + kl2.toString());
        em.persist(kl2);
        em.persist(kl1);
        em.getTransaction().commit();
        em.close();
    }
}