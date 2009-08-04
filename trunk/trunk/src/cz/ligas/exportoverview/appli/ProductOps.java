/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Products;
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
public class ProductOps {
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addProduct(Products product) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();


            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static Products getProductById(int id) throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            Products c = em.find(Products.class, id);
            em.close();
            return c;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static List<Products> getProducts() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Products> list = new ArrayList<Products>();
            Query q = em.createQuery("select p from Products p order by p.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
