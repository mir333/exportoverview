package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.DeliveryLine;
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
            EntityManager em = emFactory.createEntityManager();
            java.util.Date today = new java.util.Date();
            delivery.setEditDate(new java.sql.Date(today.getTime()));
            Clients clients = delivery.getClient();
            clients.getDocuments().add(delivery);
            em.getTransaction().begin();
            em.persist(delivery);
            em.merge(clients);
            em.getTransaction().commit();
            em.close();
    }

    public static List<Delivery> getDeliveriesFromClient(Clients c) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            List<Delivery> list = new ArrayList<Delivery>();
            Query q = em.createQuery("select d from Delivery d where d.client= :client order by d.id asc");
            q.setParameter("client", c);
            list = q.getResultList();
            em.close();
            return list;
    }

    public static List<Delivery> getDeliveries() throws Exception {
            EntityManager em = emFactory.createEntityManager();
            List<Delivery> list = new ArrayList<Delivery>();
            Query q = em.createQuery("select d from Delivery d order by d.id asc");
            list = q.getResultList();
            em.close();
            return list;
    }

    public static List<DeliveryLine> getDeliveriesLinesForDelivery(Delivery deliv) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            List<DeliveryLine> list = new ArrayList<DeliveryLine>();
            Query q = em.createQuery("select dl from DeliveryLine dl where dl.document= :doc order by dl.id asc");
            q.setParameter("doc", deliv);
            list = q.getResultList();
            em.close();
            return list;
    }

    public static void addDeliveryLine(DeliveryLine dl) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            Delivery delivery = (Delivery) dl.getDocument();
            delivery.getDocumentLine().add(dl);
            em.getTransaction().begin();
            em.persist(dl);
            em.merge(delivery);
            em.getTransaction().commit();
            em.close();
    }

    public static DeliveryLine getDeliveryLineById(int id) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            DeliveryLine dl = em.find(DeliveryLine.class, id);
            em.close();
            return dl;
    }

    public static void editDeliveryLine(DeliveryLine dl, int amount, float price) throws Exception {
            float total = amount * price;
            int id = dl.getDocument().getId();
            EntityManager em = emFactory.createEntityManager();
            Delivery d = em.find(Delivery.class, id);
            dl.setAmount(amount);
            dl.setPrice(price);
            dl.setTotal(total);
            em.getTransaction().begin();
            em.merge(dl);
            em.merge(d);
            em.getTransaction().commit();
            em.close();
    }

    public static void deleteItems(List<Integer> seletedDocs) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            for (int id : seletedDocs) {
                DeliveryLine dl = em.find(DeliveryLine.class, id);
                em.remove(dl);
            }
            em.getTransaction().commit();
            em.close();
    }
}
