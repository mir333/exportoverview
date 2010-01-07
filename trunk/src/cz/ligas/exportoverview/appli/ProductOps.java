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
        ProductCategory products = em.find(ProductCategory.class,product.getProductCategoryId().getId());
        products.getProducts().add(product);
        products.setProductInCat(Math.max(products.getProductInCat(),products.getProducts().size())+1);
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

    public static Products getProductById(int id) {
        EntityManager em = emFactory.createEntityManager();
        Products prod = em.find(Products.class, id);
        em.close();
        return prod;
    }

    public static void editProduct(Products p) {
        EntityManager em = emFactory.createEntityManager();
        Products prod = em.find(Products.class, p.getId());
        prod.setProductCategoryId(p.getProductCategoryId());
        prod.setProductCode(p.getProductCode());
        prod.setProductDes(p.getProductDes());
        prod.setProductName(p.getProductName());
        prod.setProductPrice(p.getProductPrice());
        em.getTransaction().begin();
        em.merge(prod);
        em.getTransaction().commit();
        em.close();
    }
}
