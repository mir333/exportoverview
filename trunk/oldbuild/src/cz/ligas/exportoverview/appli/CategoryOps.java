/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.ProductCategory;
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
public class CategoryOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addCategory(ProductCategory category) throws Exception {
            EntityManager em = emFactory.createEntityManager();
            category.setProductInCat(1);
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
            em.close();
    }

     public static List<ProductCategory> getCategories() throws Exception {
            EntityManager em = emFactory.createEntityManager();
            List<ProductCategory> list = new ArrayList<ProductCategory>();
            Query q = em.createQuery("select pc from ProductCategory pc order by pc.categoryCode asc");
            list = q.getResultList();
            em.close();
            return list;
    }
}
