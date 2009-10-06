/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xligas
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
//
        em.getTransaction().begin();
        ProductCategory pc = new ProductCategory();
        pc.setCategoryCode("A");
        pc.setCategoryName("test A category");
        System.err.println(pc.toString());
        em.persist(pc);
        em.getTransaction().commit();
        em.close();

//

        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Products pro = new Products();
        pro.setProductCode("A1");
        pro.setProductName("testname");
        pro.setProductDes("das");
        pro.setProductPrice(123);
        System.err.println("produkt " + pro.toString());

        Products prod = new Products();
        prod.setProductCode("A2");
        prod.setProductName("testmeno");
        prod.setProductDes("dasdas");
        prod.setProductPrice(123);
        System.err.println("produkt " + prod.toString());

        pc.getProducts().add(pro);
        pro.setProductCategoryId(pc);

        pc.getProducts().add(prod);
        prod.setProductCategoryId(pc);

        em.persist(pro);
        em.persist(prod);
        em.merge(pc);
        em.getTransaction().commit();
        em.close();

//
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        ProductCategory pc1 = em.find(ProductCategory.class, 1);
        System.err.println(pc1.getProducts().size());
        em.getTransaction().commit();
        em.close();

//
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients kl1 = new Clients();
        kl1.setClientName("fero");
        kl1.setClientAddress("fdsfs");
        kl1.setClientPhone("111111");
        System.err.println("klient " + kl1.toString());
        Clients kl2 = new Clients();
        kl2.setClientName("jozo");
        kl2.setClientAddress("fdsfs");
        kl2.setClientPhone("2222");
        System.err.println("klient " + kl2.toString());
        em.persist(kl2);
        em.persist(kl1);
        em.getTransaction().commit();
        em.close();

//
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Export e = new Export();
        Export e2 = new Export();

        kl1.getExports().add(e);
        e.setClient(kl1);
        kl2.getExports().add(e2);
        e2.setClient(kl2);

        em.persist(e2);
        em.persist(e);
        em.merge(kl1);
        em.merge(kl2);
        em.getTransaction().commit();
        em.close();

//
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Clients c = em.find(Clients.class, 1);
        System.err.println(c.getExports().size());
        em.getTransaction().commit();
        em.close();

//
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        ExportLine el = new ExportLine();
        el.setSent(6);
        el.setSold(3);
        el.setProd(pro);
        System.err.println("exp " + el.toString());
        ExportLine el2 = new ExportLine();
        el2.setProd(pro);
        el2.setSent(1);
        el2.setSold(2);
        System.err.println("exp " + el2.toString());
        ExportLine el3 = new ExportLine();
        el3.setProd(prod);
        el3.setSent(3);
        el3.setSold(4);
        System.err.println("exp " + el3.toString());

        e.getExportedProd().add(el);
        el.setExport(e);
        e.getExportedProd().add(el2);
        el2.setExport(e);
        e2.getExportedProd().add(el3);
        el3.setExport(e2);

        em.persist(el);
        em.persist(el2);
        em.persist(el3);
        em.merge(e);
        em.merge(e2);
        em.getTransaction().commit();
        em.close();

        //
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Export exp = em.find(Export.class, 1);
        System.err.println(exp.getExportedProd().size());
        em.getTransaction().commit();
        em.close();

        //
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Export exp1 = em.find(Export.class, 2);
        System.err.println(exp1.getExportedProd().size());
        em.getTransaction().commit();
        em.close();

        //
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Warehouse wh = new Warehouse();
        wh.setName("Sklad");
        java.util.Date today = new java.util.Date();
        wh.setLastUpdate(new java.sql.Date(today.getTime()));
        em.persist(wh);
        System.err.println(wh.toString());
        em.getTransaction().commit();
        em.close();

        //
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        WarehouseItem whi1 = new WarehouseItem();
        whi1.setProductItem(prod);
        whi1.setProductCount(4);
        whi1.setWarehouse(wh);
        wh.getStoredProducts().add(whi1);
        em.persist(whi1);
        System.err.println(whi1.toString());
        em.getTransaction().commit();
        em.close();
    }
}
