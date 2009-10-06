/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.Warehouse;
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
public class WarehouseOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addWarehouse(String name, java.util.Date date) throws Exception {
        try {
            Warehouse warehouse = new Warehouse();
            warehouse.setName(name);
            warehouse.setStoredProducts(new ArrayList<WarehouseItem>());
            warehouse.setLastUpdate(new java.sql.Date(date.getTime()));
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(warehouse);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

     public static List<Warehouse> getExports() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<Warehouse> list = new ArrayList<Warehouse>();
            Query q = em.createQuery("select wh from Warehouse wh order by wh.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
