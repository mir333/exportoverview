package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Invoice;
import cz.ligas.exportoverview.db.InvoiceLine;
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
public class InvoiceOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addInvoice(Invoice invoice) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        java.util.Date today = new java.util.Date();
        invoice.setEditDate(new java.sql.Date(today.getTime()));
        Clients clients = invoice.getClient();
        clients.getDocuments().add(invoice);
        em.getTransaction().begin();
        em.persist(invoice);
        em.merge(clients);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Invoice> getInvoicesFromClient(Clients c) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<Invoice> list = new ArrayList<Invoice>();
        Query q = em.createQuery("select i from Invoice i where i.client= :client order by i.id asc");
        q.setParameter("client", c);
        list = q.getResultList();
        em.close();
        return list;
    }

    public static List<Invoice> getInvoices() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<Invoice> list = new ArrayList<Invoice>();
        Query q = em.createQuery("select i from Invoice i order by i.id asc");
        list = q.getResultList();
        em.close();
        return list;
    }

    public static List<InvoiceLine> getInvoiceLinesForInvoice(Invoice inv) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<InvoiceLine> list = new ArrayList<InvoiceLine>();
        Query q = em.createQuery("select il from InvoiceLine il where il.document= :doc order by il.id asc");
        q.setParameter("doc", inv);
        list = q.getResultList();
        em.close();
        return list;
    }

    public static void addInvoiceLine(InvoiceLine il) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Invoice inv = (Invoice) il.getDocument();
        inv.getDocumentLine().add(il);
        em.getTransaction().begin();
        em.persist(il);
        em.merge(inv);
        em.getTransaction().commit();
        em.close();
    }

    public static InvoiceLine getInvoiceLineById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        InvoiceLine il = em.find(InvoiceLine.class, id);
        em.close();
        return il;
    }

    public static void editInvoiceLine(InvoiceLine il, int amount, float price) throws Exception {
        amount += il.getAmount();
        float total = amount * price;
        EntityManager em = emFactory.createEntityManager();
        Invoice i = em.find(Invoice.class, il.getDocument().getId());
        il.setAmount(amount);
        il.setPrice(price);
        il.setTotal(total);
        em.getTransaction().begin();
        em.merge(il);
        em.merge(i);
        em.getTransaction().commit();
        em.close();
    }

    public static void deleteItems(List<Integer> seletedDocs) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        for (int id : seletedDocs) {
            InvoiceLine dl = em.find(InvoiceLine.class, id);
            em.remove(dl);
        }
        em.getTransaction().commit();
        em.close();
    }
}
