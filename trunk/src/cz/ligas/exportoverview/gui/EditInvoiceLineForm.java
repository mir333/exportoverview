package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.util.MyFormater;
import cz.ligas.exportoverview.util.MyParser;
import cz.ligas.exportoverview.util.MyUtilErrorClass;
import cz.ligas.exportoverview.appli.InvoiceOps;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditInvoiceLineForm extends EditDocumentLineForm {

    public EditInvoiceLineForm(java.awt.Frame parent) {
        super(parent);
        nAmountIn.setValue(0);
        double price = InvoiceForm.getInstance().getSelectedInvoiceLine().getPrice();
        mPriceIn.setText(MyFormater.priceFormater(price));

    }

    @Override
    public void saveDocumentLine() {
        int sold = 0;
        double price = 0;
        try {
            if (!nAmountIn.getValue().toString().equals("")) {
                sold = MyParser.pareseIntNumber(nAmountIn.getValue().toString());
            }
            if (!mPriceIn.getText().equals("")) {
                price = MyParser.paresePrice(mPriceIn.getText());
            }
            InvoiceOps.editInvoiceLine(InvoiceForm.getInstance().getSelectedInvoiceLine(), sold, price);
            this.dispose();
        } catch (ParseException ex) {
            MyUtilErrorClass.errorDialog("validation.error.field");
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void fill() {
        nAmountIn.setValue(0);
        mPriceIn.setText(InvoiceForm.getInstance().getSelectedInvoiceLine().getPrice() + "");
    }
}
