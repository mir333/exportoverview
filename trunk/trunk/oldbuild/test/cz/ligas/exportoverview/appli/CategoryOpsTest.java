/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.ProductCategory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miro
 */
public class CategoryOpsTest {

    public CategoryOpsTest() {
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
     * Test of addCategory method, of class CategoryOps.
     */
    @Test
    public void testAddCategory() throws Exception {
        System.out.println("addCategory");
         ProductCategory category = new ProductCategory();
        category.setCategoryCode("A");
        category.setCategoryName("test A category");
        CategoryOps.addCategory(category);

    }

    /**
     * Test of getCategories method, of class CategoryOps.
     */
    @Test
    public void testGetCategories() throws Exception {
        System.out.println("getCategories");
        List result = CategoryOps.getCategories();
        assertTrue("empty categorys",result.size()!=0);
        System.out.println("List length = "+ result.size());
    }

}