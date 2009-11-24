package cz.ligas.exportoverview.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author miro
 */
public class ProductsTest {

    public ProductsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Products.
     */
    @Test
    public void ProductTest() {
        System.out.println("*ProductTest");
       EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");
        EntityManager em = emFactory.createEntityManager();
        em = emFactory.createEntityManager();
        em.getTransaction().begin();


        ProductCategory pc = em.find(ProductCategory.class, 1);
        System.err.println(pc.toString());

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
    }

   

}