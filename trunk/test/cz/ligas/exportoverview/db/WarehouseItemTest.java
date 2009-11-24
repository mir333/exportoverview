/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author miro
 */
public class WarehouseItemTest {

    public WarehouseItemTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class WarehouseItem.
     */
    @Test
    public void warehouseItemsTest() {
        System.out.println("warehouseItemsTest");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
        
        Products pro = em.find(Products.class, 1);
        System.err.println(pro);
        Products prod = em.find(Products.class, 2);
        System.err.println(pro);
        
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        WarehouseItem wh = new WarehouseItem();
        wh.setProductCount(5);
        wh.setProductItem(prod);
        em.persist(wh);
        WarehouseItem wh1 = new WarehouseItem();
        wh1.setProductCount(15);
        wh1.setProductItem(pro);
        em.persist(wh1);
        em.getTransaction().commit();
        em.close();
    }

}