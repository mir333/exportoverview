package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
import cz.ligas.exportoverview.db.InvoiceLine;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditInvoiceLineForm extends EditDocumentLineForm {

    InvoiceLine invLine;

    public EditInvoiceLineForm(InvoiceLine il) {
        this.invLine = il;
        nAmountIn.setValue(0);
        mPriceIn.setText(invLine.getPrice() + "");

    }

    @Override
    public void saveDocumentLine() {
        int sold = 0;
        float price = 0;
        if(!nAmountIn.getValue().toString().equals(""))
            sold = Integer.parseInt(nAmountIn.getValue().toString());
        if(!mPriceIn.getText().equals(""))
            price = Float.parseFloat(mPriceIn.getText());
        try {
            InvoiceOps.editInvoiceLine(invLine, sold, price);
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
