package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.DeliveryLine;
import cz.ligas.exportoverview.db.DocumentLine;
import cz.ligas.exportoverview.db.DocumentLine;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.ArrayList;
import java.util.Iterator;
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
        int number = UtilityOps.getDeliveryCount();
        delivery.setDocNumber(number+1);
        Clients clients = delivery.getClient();
        clients.getDocuments().add(delivery);
        em.getTransaction().begin();
        em.persist(delivery);
        em.merge(clients);
        em.getTransaction().commit();
        em.close();
    }

    public static Delivery getDeliveryById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Delivery dl = em.find(Delivery.class, id);
        em.close();
        return dl;
    }

    public static void editDelivery(Delivery delivery, float total) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        java.util.Date today = new java.util.Date();
        delivery.setEditDate(new java.sql.Date(today.getTime()));
        delivery.setTotal(total);
        em.getTransaction().begin();
        em.merge(delivery);
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
        Query q = em.createQuery("select dl from DeliveryLine dl where dl.document= :doc order by dl.prod.productCode asc");
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

        ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                dl.getProd().getId(), dl.getDocument().getClient().getId());
        if (exportLine == null) {
            ExportLine el = new ExportLine();
            el.setClient(dl.getDocument().getClient());
            el.setProd(dl.getProd());
            el.setPrice(dl.getPrice());
            el.setSent(dl.getAmount());
            el.setSold(0);
            ExportLineOps.addExportLine(el);
        } else {
            ExportLineOps.editExportLine(exportLine, dl.getAmount(), 0, dl.getPrice());
        }
        recalculateDelivery(delivery);
    }

    public static DeliveryLine getDeliveryLineById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        DeliveryLine dl = em.find(DeliveryLine.class, id);
        em.close();
        return dl;
    }

    public static void editDeliveryLine(DeliveryLine dl, int am, float price) throws Exception {
        int amount = am + dl.getAmount();
        float total = amount * price;
        int id = dl.getDocument().getId();
        EntityManager em = emFactory.createEntityManager();
        Delivery d = em.find(Delivery.class, id);
        dl.setAmount(amount);
        dl.setPrice(price);
        dl.setTotal(total);
        //TODO: it's mayby necessary to del tiem fotm deliverys via loop
        em.getTransaction().begin();
        em.merge(dl);
        em.merge(d);
        em.getTransaction().commit();
        em.close();
        ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                dl.getProd().getId(), dl.getDocument().getClient().getId());
        ExportLineOps.editExportLine(exportLine, am, 0, dl.getPrice());
        recalculateDelivery(d);
    }

    public static void deleteItems(List<Integer> seletedDocs, int did) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Delivery d = em.find(Delivery.class, did);
        for (Iterator<DocumentLine> it = d.getDocumentLine().iterator(); it.hasNext();) {
            DocumentLine dl = it.next();
            for (Iterator<Integer> it1 = seletedDocs.iterator(); it1.hasNext();) {
                int i = it1.next();
                if (dl.getId() == i) {
                    ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                            dl.getProd().getId(), dl.getDocument().getClient().getId());
                    ExportLineOps.editExportLine(exportLine, -dl.getAmount(), 0, dl.getPrice());
                    em.remove(dl);
                    it.remove();
                    it1.remove();
                    break;
                }
            }
        }
        em.merge(d);
        em.getTransaction().commit();
        em.close();
        recalculateDelivery(d);
    }

    public static void recalculateDelivery(Delivery del) throws Exception {
        float total = 0L;
        del = getDeliveryById(del.getId());
        for (DocumentLine docl : del.getDocumentLine()) {
            total += docl.getTotal();
        }
        editDelivery(del, total);
    }
}
