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
        EntityManagerFactory emFactory =
                Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();

        ProductCategory pc = new ProductCategory();
        pc.setCategoryCode("A");
        pc.setCategoryName("test A category");


        Products pro = new Products();
        pro.setProductCode("A1");
        pro.setProductName("testname");
        pro.setProductDes("das");
        pro.setProductPrice(123);
        pro.setProductCategoryId(pc);


        Products prod = new Products();
        prod.setProductCode("A2");
        prod.setProductName("testmeno");
        prod.setProductDes("dasdas");
        prod.setProductPrice(123);
        prod.setProductCategoryId(pc);


        Clients kl1 = new Clients();
        kl1.setClientName("fero");
        kl1.setClientAddress("fdsfs");

        Clients kl2 = new Clients();
        kl2.setClientName("jozo");
        kl2.setClientAddress("fdsfs");


        Export e = new Export();
        e.setClient(kl1);


        Export e2 = new Export();
        e2.setClient(kl2);

        ExportLine el = new ExportLine();
        el.setProd(pro);
        el.setSent(6);
        el.setSold(3);
        el.setExport(e);




        ExportLine el2 = new ExportLine();
        el2.setProd(pro);
        el2.setSent(1);
        el2.setSold(2);
        el2.setExport(e);

        ExportLine el3 = new ExportLine();
        el3.setProd(prod);
        el3.setSent(3);
        el3.setSold(4);
        el3.setExport(e2);



        System.err.println(pc.toString());
        System.err.println("test");
        System.err.println(pro.toString());


        em.getTransaction().begin();
        em.persist(pc);
        em.persist(pro);
        em.persist(prod);
        em.persist(kl1);
        em.persist(kl2);
        em.persist(e);
        em.persist(e2);
        em.persist(el);
        em.persist(el2);
         em.persist(el3);
        em.getTransaction().commit();

        em.close();




    }
}
