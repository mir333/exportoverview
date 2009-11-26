package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
import cz.ligas.exportoverview.db.Invoice;
import cz.ligas.exportoverview.db.InvoiceLine;
import cz.ligas.exportoverview.db.Products;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        InvoiceLine il = new InvoiceLine();
        int i =getnAmountIn();
        float f = getmPriceIn();
        il.setAmount(i);
        il.setPrice(f);
        il.setDocument(invoice);
        il.setProd((Products)getProduct());
        il.setTotal(i*f);
        //overenie vyplnenia
        try {
            InvoiceOps.addInvoiceLine(il);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
