package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
import cz.ligas.exportoverview.db.InvoiceLine;
import cz.ligas.exportoverview.db.Products;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class AddInvoice extends AddDocumentLineForm {


    public AddInvoice(java.awt.Frame parent) {
        super(parent);
    }

    @Override
    public void addDocumentLine() {
        InvoiceLine il = new InvoiceLine();
        try {
            int i = MyParser.pareseIntNumber(nAmountIn.getText());
            double f = MyParser.paresePrice(mPriceIn.getText());
            il.setAmount(i);
            il.setPrice(f);
            il.setDocument(InvoiceForm.getInstance().getSelectedInvoice());
            il.setProd((Products) productComboBox.getSelectedItem());
            il.setTotal(i * f);
            //overenie vyplnenia
            InvoiceOps.addInvoiceLine(il);
        } catch (ParseException ex) {
            MyUtilErrorClass.errorDialog("validation.error.field");
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainView.refreshTotal();
        this.dispose();
    }
}
