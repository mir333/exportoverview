package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.Invoice;

/**
 *
 * @author miro
 */
public class AddInvoice extends AddDocumentLineForm {

    Invoice invoice;

    public AddInvoice(Invoice i) {
        this.invoice = i;
    }

    @Override
    public void addDocumentLine() {
        this.dispose();
    }
}
