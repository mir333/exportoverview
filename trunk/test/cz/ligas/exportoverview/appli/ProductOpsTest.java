
package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.ProductCategory;
import cz.ligas.exportoverview.db.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class ProductOpsTest {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public ProductOpsTest() {
    }

    /**
     * Test of addProduct method, of class ProductOps.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("addProduct");
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        ProductCategory pc = em.find(ProductCategory.class, 1);
        em.close();
        Products pro = new Products();
        pro.setProductCode("A1");
        pro.setProductName("testname");
        pro.setProductDes("das");
        pro.setProductPrice(123);
        pro.setProductCategoryId(pc);
        ProductOps.addProduct(pro);
    }

    /**
     * Test of getProducts method, of class ProductOps.
     */
    @Test
    public void testGetProducts() throws Exception {
        System.out.println("getProducts");
        List result = ProductOps.getProducts();
        assertTrue("LIST IS EMPTY", result.size() != 0);
    }
}
