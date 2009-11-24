package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Delivery;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class NewDeliveryForm extends NewDocumentForm  {
    @Override
    public void createDocument(){
         Delivery del = new Delivery();
        del.setClient(getClient());
        try {
            DeliveryOps.addDelivery(del);
        } catch (Exception ex) {
            Logger.getLogger(NewDocumentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
