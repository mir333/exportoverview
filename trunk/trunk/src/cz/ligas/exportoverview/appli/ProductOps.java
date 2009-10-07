/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.ProductCategory;
import cz.ligas.exportoverview.db.Products;
import cz.ligas.exportoverview.db.WarehouseItem;
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
            ProductCategory products = product.getProductCategoryId();
            products.getProducts().add(product);
            em.getTransaction().begin();
            em.persist(product);
            em.merge(products);
            em.getTransaction().commit();
            em.close();
            WarehouseItem whi = new WarehouseItem();
            whi.setProductCount(0);
            whi.setProductItem(product);
            WarehouseItemOps.addWarehouseItem(whi);
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
