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
public class WarehouseItemOps {
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

     public static void addWarehouseItem(WarehouseItem warhouseItem) throws Exception {
        Warehouse wh = warhouseItem.getWarehouse();
        wh.getStoredProducts().add(warhouseItem);
        try {
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.persist(warhouseItem);
            em.merge(wh);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

//    public static ExportLine getExportLineById(int id) throws Exception {
//        try {
//            EntityManager em = emFactory.createEntityManager();
//            ExportLine c = em.find(ExportLine.class, id);
//            em.close();
//            return c;
//        } catch (Exception e) {
//            throw new Exception(e);
//        }
//    }

    public static List<WarehouseItem> getwarhouseItemByExport(Warehouse wh)throws Exception{
                try {
            EntityManager em = emFactory.createEntityManager();
            List<WarehouseItem> list = new ArrayList<WarehouseItem>();
            Query q = em.createQuery("select whi from WarehouseItem whi where whi.warehouse=:wh  order by whi.id asc");
            q.setParameter("wh", wh);
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception exc) {
            throw new Exception(exc);
        }

    }

    public static List<WarehouseItem> getWarehouseItems() throws Exception {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<WarehouseItem> list = new ArrayList<WarehouseItem>();
            Query q = em.createQuery("select whi from WarehouseItem whi order by whi.id asc");
            list = q.getResultList();
            em.close();
            return list;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

//    public static void editExportLine(Export exp,ExportLine exportLine, int sent,int sold,float price) throws Exception {
//        exportLine.setPrice(price);
//        exportLine.setSent(exportLine.getSent()+sent-sold);
//        exportLine.setSold(exportLine.getSold()+sold);
//        exportLine.setSentPrice(exportLine.getPrice()*exportLine.getSent());
//        exportLine.setTotal(exportLine.getSent()+exportLine.getSold());
//        for (int i = 0; i < exp.getExportedProd().size(); i++) {
//            ExportLine el = exp.getExportedProd().get(i);
//            if(el.getId()==exportLine.getId()){
//                exp.getExportedProd().set(i, el);
//            }
//        }
//        try {
//            EntityManager em = emFactory.createEntityManager();
//            em.getTransaction().begin();
//            em.merge(exportLine);
//            em.merge(exp);
//            em.getTransaction().commit();
//            em.close();
//        } catch (Exception e) {
//            throw new Exception(e);
//        }
//    }

}
