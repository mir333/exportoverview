package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.DeliveryLine;
import cz.ligas.exportoverview.db.Document;
import cz.ligas.exportoverview.db.Products;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author miro
 */
public class AddDelivery extends AddDocumentLineForm {

    Delivery delivery;

    public AddDelivery(Document d) {
        this.delivery = (Delivery)d;
    }

    @Override
    public void addDocumentLine() {
        DeliveryLine dl = new DeliveryLine();
        int i =getnAmountIn();
        float f = getmPriceIn();
        dl.setAmount(i);
        dl.setPrice(f);
        dl.setDocument(delivery);
        dl.setProd((Products)getProduct());
        dl.setTotal(i*f);
        //overenie vyplnenia
        try {
            DeliveryOps.addDeliveryLine(dl);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
