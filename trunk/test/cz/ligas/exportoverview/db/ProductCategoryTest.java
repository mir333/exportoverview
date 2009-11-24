/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author miro
 */
public class ProductCategoryTest {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public ProductCategoryTest() {
    }

    @Test
    public void productCategoryTest() {
        System.out.println("ProductCategoryTest");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        ProductCategory pc = new ProductCategory();
        pc.setCategoryCode("A");
        pc.setCategoryName("test A category");
        System.err.println(pc.toString());
        em.persist(pc);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void getProductCategoryTest() {
        System.out.println("getProductCategoryTest");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        ProductCategory pc = em.find(ProductCategory.class, 1);
        System.err.println(pc.toString());
        em.close();
    }
}
