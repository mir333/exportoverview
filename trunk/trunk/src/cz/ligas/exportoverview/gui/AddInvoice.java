/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.ExportLine;
import cz.ligas.exportoverview.db.Invoice;

/**
 *
 * @author miro
 */
public class AddInvoice extends AddProductForm {

    Invoice invoice;

    public AddInvoice(Invoice i) {
        this.invoice = i;
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
