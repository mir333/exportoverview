/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

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
public class WarehouseItemOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addWarehouseItem(WarehouseItem warhouseItem) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(warhouseItem);
        em.getTransaction().commit();
        em.close();
    }

    public static WarehouseItem getWarehouseItemById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        WarehouseItem c = em.find(WarehouseItem.class, id);
        em.close();
        return c;
    }

    public static List<WarehouseItem> getWarhouseItemByCategoryId(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<WarehouseItem> list = new ArrayList<WarehouseItem>();
        Query q = em.createQuery("SELECT whi FROM WarehouseItem whi WHERE whi.productItem.productCategoryId.id = :wh order by whi.productItem.productCode asc");
        q.setParameter("wh", id);
        list = q.getResultList();
        em.close();
        return list;
    }

    public static List<WarehouseItem> getWarehouseItems() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<WarehouseItem> list = new ArrayList<WarehouseItem>();
        Query q = em.createQuery("select whi from WarehouseItem whi order by whi.productItem.productCode asc");
        list = q.getResultList();
        em.close();
        return list;
    }

    public static WarehouseItem getWarehouseItemByProductCode(String code) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Query q = em.createQuery("select whi from WarehouseItem whi where whi.productItem.productCode=:code order by whi.productItem.productCode asc");
        q.setParameter("code", code);
        WarehouseItem wh = (WarehouseItem) q.getSingleResult();
        em.close();
        return wh;
    }

    public static void editWarehouseItem(WarehouseItem whi, int amount) throws Exception {
        whi.setProductCount(whi.getProductCount() + amount);
        if(whi.getProductCount()<0)
            throw new IllegalArgumentException("error.warehouse.negativeValue");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(whi);
        em.getTransaction().commit();
        em.close();
    }
}
