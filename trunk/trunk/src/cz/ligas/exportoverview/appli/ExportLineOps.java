/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Export;
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
        Export exports = exportLine.getExport();
        exports.getExportedProd().add(exportLine);
        try {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(exportLine);
            em.merge(exports);
            em.getTransaction().commit();
            em.close();
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

    public static List<ExportLine> getExportLinesByExport(Export e)throws Exception{
                try {
            EntityManager em = emFactory.createEntityManager();
            List<ExportLine> list = new ArrayList<ExportLine>();
            Query q = em.createQuery("select el from ExportLine el where el.export=:ex  order by el.id asc");
            q.setParameter("ex", e);
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

    public static void editExportLine(ExportLine exportLine, int sent,int sold) throws Exception {
        exportLine.setSent(exportLine.getSent()+sent-sold);
        exportLine.setSold(exportLine.getSold()+sold);
        exportLine.setSentPrice(exportLine.getPrice()*exportLine.getSent());
        exportLine.setTotal(exportLine.getSent()+exportLine.getSold());
        try {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.merge(exportLine);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
