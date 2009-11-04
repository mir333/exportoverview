package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.ExportLine;

/**
 *
 * @author miro
 */
public class AddDelivery extends AddProductForm {

    Delivery delivery;

    public AddDelivery(Delivery d) {
        this.delivery = d;
    }

    @Override
    public void addExportLine() {
        ExportLine el = new ExportLine();
        el.setProd(getSelectedProduct());
        el.setPrice(getSpecialPriceIn());
        el.setSent(getSendIn());
        el.setSold(getSoldIn());
        //set export
    }
}
