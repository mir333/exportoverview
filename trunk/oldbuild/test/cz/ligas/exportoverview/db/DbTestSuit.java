package cz.ligas.exportoverview.db;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author miro
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {cz.ligas.exportoverview.db.ClientsTest.class,
         cz.ligas.exportoverview.db.ProductCategoryTest.class,
         cz.ligas.exportoverview.db.ProductsTest.class,
         cz.ligas.exportoverview.db.ExportLineTest.class,
         cz.ligas.exportoverview.db.WarehouseItemTest.class,
         cz.ligas.exportoverview.db.DocumentTest.class,
         cz.ligas.exportoverview.db.DocumentLineTest.class})
public class DbTestSuit {

}