package cz.ligas.exportoverview.appli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import cz.ligas.exportoverview.db.Clients;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author xligas
 */
public class ClientOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addClient(Clients client) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();


            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static Clients getClientById(int id) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            Clients c = em.find(Clients.class, id);
            em.close();
            return c;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Clients> getClients() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Clients> list = new ArrayList<Clients>();
            Query q = em.createQuery("select c from Clients c order by c.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
