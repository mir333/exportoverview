package cz.ligas.exportoverview.appli;

import cz.ligas.exportoverview.db.UserInfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 *
 * @author xligas
 */
public class ClientOps {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ExportOverviewPU");

    public static void addClient(Clients client) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    public static List<Clients> getClients() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        List<Clients> list = new ArrayList<Clients>();
        Query q = em.createQuery("select c from Clients c order by c.clientName asc");
        list = q.getResultList();
        em.close();
        return list;
    }

    public static void editClient(Clients c) {
        EntityManager em = emFactory.createEntityManager();
        Clients client = em.find(Clients.class, c.getId());
        client.setCity(c.getCity());
        client.setClientAddress(c.getClientAddress());
        client.setClientName(c.getClientName());
        client.setClientPhone(c.getClientPhone());
        client.setCompany(c.getCompany());
        client.setCountry(c.getCountry());
        client.setDic(c.getDic());
        client.setIco(c.getIco());
        client.setPsc(c.getPsc());
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
        em.close();
    }

    public static Clients getClientById(int id) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Clients c = em.find(Clients.class, id);
        em.close();
        return c;
    }

    public static void recalculateExportedProducts(Clients client) {
        int total = 0;
        int totalSold = 0;
        int totalSent = 0;
        double totalSendValue = 0;
        try {
            List<ExportLine> ls = ExportLineOps.getExportLinesByClient(client);
            for (ExportLine el : ls) {
                total += el.getTotal();
                totalSendValue += el.getSentPrice();
                totalSent += el.getSent();
                totalSold += el.getSold();
            }
            client.setTotal(total);
            client.setTotalSendValue(totalSendValue);
            client.setTotalSent(totalSent);
            client.setTotalSold(totalSold);
            java.util.Date today = new java.util.Date();
            client.setEditDate(new java.sql.Date(today.getTime()));
            EntityManager em = emFactory.createEntityManager();
            em.getTransaction().begin();
            em.merge(client);
            em.getTransaction().commit();
            em.close();
        } catch (Exception ex) {
            Logger.getLogger(ClientOps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addUserInfo(UserInfo userInfo) throws Exception {
        EntityManager em = emFactory.createEntityManager();
        userInfo.setDeliverCount(0);
        userInfo.setInvoiceCount(0);
        em.getTransaction().begin();
        em.persist(userInfo);
        em.getTransaction().commit();
        em.close();
    }

    public static UserInfo getUserInfo() throws Exception {
        EntityManager em = emFactory.createEntityManager();
        Query q = em.createQuery("select ui from UserInfo ui order by ui.id asc");
        UserInfo ui = (UserInfo) q.getSingleResult();
        em.close();
        return ui;
    }

    public static void editUserInfo(UserInfo userInfo) {
        EntityManager em = emFactory.createEntityManager();
        userInfo.setId(1);
        em.getTransaction().begin();
        em.merge(userInfo);
        em.getTransaction().commit();
        em.close();
    }

    public static boolean isUserInfoEmpty() {
        try {
            EntityManager em = emFactory.createEntityManager();
            List<UserInfo> list = new ArrayList<UserInfo>();
            Query q = em.createQuery("select ui from UserInfo ui order by ui.id asc");
            list = q.getResultList();
            em.close();
            if (list.size() > 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    public static void editClientSoldTotal(int id, double total) {
        EntityManager em = emFactory.createEntityManager();
        Clients c = em.find(Clients.class, id);
        c.setTotalSoldValue(total);
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
    }
}
