package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.DocumentLine;
import cz.ligas.exportoverview.db.Invoice;
import cz.ligas.exportoverview.db.InvoiceLine;
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
public class InvoiceOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addInvoice(Invoice invoice) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        java.util.Date today = new java.util.Date();
        invoice.setEditDate(new java.sql.Date(today.getTime()));
        int number = UtilityOps.getInvoiceCount()+1;
        invoice.setDocNumber(number);
        Clients clients = invoice.getClient();
        clients.getDocuments().add(invoice);
        em.getTransaction().begin();
        em.persist(invoice);
        em.merge(clients);
        em.getTransaction().commit();
        em.close();
        UtilityOps.setInvoiceCount(number);
    }

    public static Invoice getInvoiceById(int id) {
        EntityManager em = emFactory.createEntityManager();
        Invoice il = em.find(Invoice.class, id);
        em.close();
        return il;
    }

    public static void editInvoice(Invoice invoice, float total) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        java.util.Date today = new java.util.Date();
        invoice.setEditDate(new java.sql.Date(today.getTime()));
        invoice.setTotal(total);
        em.getTransaction().begin();
        em.merge(invoice);
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
        Query q = em.createQuery("select il from InvoiceLine il where il.document= :doc order by il.prod.productCode asc");
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
        ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                il.getProd().getId(), il.getDocument().getClient().getId());
        if (exportLine == null) {
            ExportLine el = new ExportLine();
            el.setClient(il.getDocument().getClient());
            el.setProd(il.getProd());
            el.setPrice(il.getPrice());
            el.setSent(-il.getAmount());
            el.setSold(il.getAmount());
            ExportLineOps.addExportLine(el);
        } else {
            ExportLineOps.editExportLine(exportLine, 0, il.getAmount(), il.getPrice());
        }
        recalculateInvoice(inv);
    }

    public static InvoiceLine getInvoiceLineById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        InvoiceLine il = em.find(InvoiceLine.class, id);
        em.close();
        return il;
    }

    public static void editInvoiceLine(InvoiceLine il, int am, float price) throws Exception {
        int amount = am + il.getAmount();
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
        ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                il.getProd().getId(), il.getDocument().getClient().getId());
        ExportLineOps.editExportLine(exportLine, 0, am, il.getPrice());
        recalculateInvoice(i);
    }

    public static void deleteItems(List<Integer> seletedDocs, int iid) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Invoice inv = em.find(Invoice.class, iid);
        for (Iterator<DocumentLine> it = inv.getDocumentLine().iterator(); it.hasNext();) {
            DocumentLine dl = it.next();
            for (Iterator<Integer> it1 = seletedDocs.iterator(); it1.hasNext();) {
                int i = it1.next();
                if (dl.getId() == i) {
                    ExportLine exportLine = ExportLineOps.getExportLineByProductId(
                            dl.getProd().getId(), dl.getDocument().getClient().getId());
                    ExportLineOps.editExportLine(exportLine, 0, -dl.getAmount(), dl.getPrice());
                    em.remove(dl);
                    it.remove();
                    it1.remove();
                    break;
                }
            }
        }
        em.merge(inv);
        em.getTransaction().commit();
        em.close();
        recalculateInvoice(inv);
    }

    public static void recalculateInvoice(Invoice inv) throws Exception {
        float total = 0L;
        inv = getInvoiceById(inv.getId());
        for (DocumentLine docl : inv.getDocumentLine()) {
            total += docl.getTotal();
        }
        editInvoice(inv, total);
        ClientOps.editClientSoldTotal(inv.getClient().getId(),total);
    }
}
