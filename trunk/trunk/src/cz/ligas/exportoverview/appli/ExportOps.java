/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Export;
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
public class ExportOps {
 private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addProduct(Export export) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();


            em.getTransaction().begin();
            em.persist(export);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static Export getProductById(int id) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            Export c = em.find(Export.class, id);
            em.close();
            return c;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Export> getProducts() throws Exception {
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
}
