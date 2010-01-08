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

    public EditInvoiceLineForm(InvoiceLine il,java.awt.Frame parent) {
        super(parent);
        this.invLine = il;
        nAmountIn.setValue(0);
        mPriceIn.setText(invLine.getPrice() + "");

    }

    @Override
    public void saveDocumentLine() {
        int sold = 0;
        float price = 0;
        try {
            if (!nAmountIn.getValue().toString().equals("")) {
                sold = MyParser.pareseIntNumber(nAmountIn.getValue().toString());
            }
            if (!mPriceIn.getText().equals("")) {
                price = MyParser.paresePrice(mPriceIn.getText());
            }
            InvoiceOps.editInvoiceLine(invLine, sold, price);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
