package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Delivery;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author miro
 */
public class DeliveryOps {
  private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addDelivery(Delivery delivery) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            java.util.Date today = new java.util.Date();
            delivery.setEditDate(new java.sql.Date(today.getTime()));
            Clients clients = delivery.getClient();
            clients.getDeliveries().add(delivery);
            em.getTransaction().begin();
            em.persist(delivery);
            em.merge(clients);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public static List<Delivery> getDeliveriesFromClient(Clients c) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Delivery> list = new ArrayList<Delivery>();
            Query q = em.createQuery("select d from Delivery d where d.client= :client order by e.id asc");
            q.setParameter("client", c);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Delivery> getDeliveries() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Delivery> list = new ArrayList<Delivery>();
            Query q = em.createQuery("select d from Delivery d order by d.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
