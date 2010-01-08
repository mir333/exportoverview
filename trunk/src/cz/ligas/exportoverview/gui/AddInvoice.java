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

    public AddInvoice(Invoice i,java.awt.Frame parent) {
        super(parent);
        this.invoice = i;
    }

    @Override
    public void addDocumentLine() {
        InvoiceLine il = new InvoiceLine();
        try {
            int i = MyParser.pareseIntNumber(nAmountIn.getText());
            float f = MyParser.paresePrice(mPriceIn.getText());
            il.setAmount(i);
            il.setPrice(f);
            il.setDocument(invoice);
            il.setProd((Products) productComboBox.getSelectedItem());
            il.setTotal(i * f);
            //overenie vyplnenia
            InvoiceOps.addInvoiceLine(il);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainView.refreshTotal();
        this.dispose();
    }
}
