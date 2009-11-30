/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
import cz.ligas.exportoverview.db.InvoiceLine;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditInvoiceLineForm extends EditDocumentLineForm{

    InvoiceLine invLine;

    public EditInvoiceLineForm(InvoiceLine il){
        this.invLine = il;
        nAmountIn.setValue(il.getAmount());
        mPriceIn.setText(invLine.getPrice()+"");

    }

       @Override
    public void saveDocumentLine(){
        int sold = Integer.parseInt(nAmountIn.getValue().toString());
        float price = Float.parseFloat(mPriceIn.getText());
                try {
            InvoiceOps.editDeliveryLine(invLine,sold, price);
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
