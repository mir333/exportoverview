/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author xligas
 */
public class ExportLineOps {
 private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addExportLine(ExportLine exportLine) throws Exception {
        exportLine.setSentPrice(exportLine.getPrice()*exportLine.getSent());
        exportLine.setTotal(exportLine.getSent()+exportLine.getSold());
        Clients clients = exportLine.getClient();
        clients.getExportLines().add(exportLine);
        try {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(exportLine);
            em.merge(clients);
            em.getTransaction().commit();
            em.close();
            ClientOps.recalculateExportedProducts(clients);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static ExportLine getExportLineById(int id) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            ExportLine c = em.find(ExportLine.class, id);
            em.close();
            return c;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<ExportLine> getExportLinesByClient(Clients c)throws Exception{
                try {
            EntityManager em = emFactory.createEntityManager();
            List<ExportLine> list = new ArrayList<ExportLine>();
            Query q = em.createQuery("select el from ExportLine el where el.client=:client  order by el.id asc");
            q.setParameter("client", c);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception exc) {
            throw new Exception(exc);
        }

    }

    public static List<ExportLine> getExportLine() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<ExportLine> list = new ArrayList<ExportLine>();
            Query q = em.createQuery("select el from ExportLine el order by el.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void editExportLine(Clients client,ExportLine exportLine, int sent,int sold,float price) throws Exception {
        exportLine.setPrice(price);
        exportLine.setSent(exportLine.getSent()+sent-sold);
        exportLine.setSold(exportLine.getSold()+sold);
        exportLine.setSentPrice(exportLine.getPrice()*exportLine.getSent());
        exportLine.setTotal(exportLine.getSent()+exportLine.getSold());
        for (int i = 0; i < client.getExportLines().size(); i++) {
            ExportLine el = client.getExportLines().get(i);
            if(el.getId()==exportLine.getId()){
                client.getExportLines().set(i, el);
            }
        }
        try {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.merge(exportLine);
            em.merge(client);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
