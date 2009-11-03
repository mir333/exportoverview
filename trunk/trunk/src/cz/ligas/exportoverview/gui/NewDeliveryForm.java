package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Delivery;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class NewDeliveryForm extends ExportForm  {
    @Override
    public void createExport(){
         Delivery del = new Delivery();
        del.setClient(getClient());
        try {
            DeliveryOps.addDelivery(del);
        } catch (Exception ex) {
            Logger.getLogger(ExportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
