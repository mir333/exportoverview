/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Invoice;
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
            clients.getInvoices().add(invoice);
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

}
