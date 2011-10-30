package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.UserInfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author miro
 */
public class UtilityOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void setDeliveryCount(int i) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        UserInfo ui = ClientOps.getUserInfo();
        ui.setDeliverCount(i);
        em.getTransaction().begin();
        em.merge(ui);
        em.getTransaction().commit();
        em.close();
    }

    public static int getDeliveryCount() throws Exception {
        UserInfo ui = ClientOps.getUserInfo();
        return ui.getDeliverCount();
    }

    public static void setInvoiceCount(int i) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        UserInfo ui = ClientOps.getUserInfo();
        ui.setInvoiceCount(i);
        em.getTransaction().begin();
        em.merge(ui);
        em.getTransaction().commit();
        em.close();
    }

    public static int getInvoiceCount() throws Exception {
        UserInfo ui = ClientOps.getUserInfo();
        return ui.getInvoiceCount();
    }
}
