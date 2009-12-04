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
    }

    public static List<Products> getProducts() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<Products> list = new ArrayList<Products>();
        Query q = em.createQuery("select p from Products p order by p.productCode asc");
        list = q.getResultList();
        em.close();
        return list;
    }
}
