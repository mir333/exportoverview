/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Export;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author xligas
 */
public class ExportOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addExport(Export export) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            java.util.Date today = new java.util.Date();
            export.setEditDate(new java.sql.Date(today.getTime()));
            Clients clients = export.getClient();
            clients.getExports().add(export);
            em.getTransaction().begin();
            em.persist(export);
            em.merge(clients);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    public static List<Export> getExportsFromClient(Clients c) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Export> list = new ArrayList<Export>();
            Query q = em.createQuery("select e from Export e where e.client= :client order by e.id asc");
            q.setParameter("client", c);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Export> getExports() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Export> list = new ArrayList<Export>();
            Query q = em.createQuery("select e from Export e order by e.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void recalculateExport(Export exp) {
        int total = 0;
        int totalSold = 0;
        int totalSent = 0;
        float totalSendValue = 0;
        try {
            List<ExportLine> ls = ExportLineOps.getExportLinesByExport(exp);
            for (ExportLine el : ls) {
                total += el.getTotal();
                totalSendValue += el.getSentPrice();
                totalSent += el.getSent();
                totalSold += el.getSold();
            }

            exp.setTotal(total);
            exp.setTotalSendValue(totalSendValue);
            exp.setTotalSent(totalSent);
            exp.setTotalSold(totalSold);
            java.util.Date today = new java.util.Date();
            exp.setEditDate(new java.sql.Date(today.getTime()));
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.merge(exp);
            em.getTransaction().commit();
            em.close();
        } catch (Exception ex) {
            Logger.getLogger(ExportOps.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
