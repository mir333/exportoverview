package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author xligas
 */
public class ExportLineOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addExportLine(ExportLine exportLine) throws Exception {
        exportLine.setSentPrice(exportLine.getPrice() * exportLine.getSent());
        exportLine.setTotal(exportLine.getSent() + exportLine.getSold());
        Clients clients = exportLine.getClient();
        clients.getExportLines().add(exportLine);
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(exportLine);
        em.merge(clients);
        em.getTransaction().commit();
        em.close();
        ClientOps.recalculateExportedProducts(clients);
    }

    public static ExportLine getExportLineById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        ExportLine c = em.find(ExportLine.class, id);
        em.close();
        return c;
    }

    public static List<ExportLine> getExportLinesByClient(Clients c) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<ExportLine> list = new ArrayList<ExportLine>();
        Query q = em.createQuery("select el from ExportLine el where el.client=:client  order by el.prod.productCode asc");
        q.setParameter("client", c);
        list = q.getResultList();
        em.close();
        return list;
    }

    public static List<ExportLine> getExportLine() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<ExportLine> list = new ArrayList<ExportLine>();
        Query q = em.createQuery("select el from ExportLine el order by el.prod.productCode asc");
        list = q.getResultList();
        em.close();
        return list;
    }

    public static void editExportLine(ExportLine exportLine, int sent, int sold, float price) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Clients client = em.find(Clients.class, exportLine.getClient().getId());
        exportLine.setPrice(price);
        exportLine.setSent(exportLine.getSent() + sent - sold);
        exportLine.setSold(exportLine.getSold() + sold);
        exportLine.setSentPrice(exportLine.getPrice() * exportLine.getSent());
        exportLine.setTotal(exportLine.getSent() + exportLine.getSold());
        for (int i = 0; i < client.getExportLines().size(); i++) {
            ExportLine el = client.getExportLines().get(i);
            if (el.getId() == exportLine.getId()) {
                client.getExportLines().set(i, el);
            }
        }
        em.getTransaction().begin();
        em.merge(exportLine);
        em.merge(client);
        em.getTransaction().commit();
        em.close();
    }

    static ExportLine getExportLineByProductId(int pid,int cid) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        try {
            Query q = em.createQuery("select el from ExportLine el where el.prod.id=:productId and el.client.id=:clientId order by el.prod.productCode asc");
            q.setParameter("productId", pid);
            q.setParameter("clientId", cid);
            ExportLine el = (ExportLine) q.getSingleResult();
            return el;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            em.close();
        }
    }
}
