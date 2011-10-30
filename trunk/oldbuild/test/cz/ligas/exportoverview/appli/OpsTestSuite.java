/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.appli;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author miro
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({cz.ligas.exportoverview.appli.InvoiceOpsTest.class,
        cz.ligas.exportoverview.appli.DeliveryOpsTest.class,
        cz.ligas.exportoverview.appli.ProductOpsTest.class,
        cz.ligas.exportoverview.appli.ExportLineOpsTest.class,
        cz.ligas.exportoverview.appli.ClientOpsTest.class,
        cz.ligas.exportoverview.appli.CategoryOpsTest.class,
        cz.ligas.exportoverview.appli.WarehouseItemOpsTest.class})
public class OpsTestSuite {


}