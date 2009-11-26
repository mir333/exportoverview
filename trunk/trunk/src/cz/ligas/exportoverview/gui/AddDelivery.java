package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.Document;


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
                this.dispose();
    }
}
