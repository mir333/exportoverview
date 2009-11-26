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
        try {
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
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public static List<Invoice> getInvoicesFromClient(Clients c) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Invoice> list = new ArrayList<Invoice>();
            Query q = em.createQuery("select i from Invoice i where i.client= :client order by i.id asc");
            q.setParameter("client", c);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Invoice> getInvoices() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Invoice> list = new ArrayList<Invoice>();
            Query q = em.createQuery("select i from Invoice i order by i.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<InvoiceLine> getInvoiceLinesForInvoice(Invoice inv) throws Exception{
       try {
            EntityManager em = emFactory.createEntityManager();
            List<InvoiceLine> list = new ArrayList<InvoiceLine>();
            Query q = em.createQuery("select dl from DeliveryLine dl where dl.document= :doc order by dl.id asc");
            q.setParameter("doc", inv);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void addInvoiceLine(InvoiceLine il) throws Exception {
           try {
            EntityManager em = emFactory.createEntityManager();
            Invoice inv = (Invoice) il.getDocument();
            inv.getDocumentLine().add(il);
            em.getTransaction().begin();
            em.persist(il);
            em.merge(inv);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
