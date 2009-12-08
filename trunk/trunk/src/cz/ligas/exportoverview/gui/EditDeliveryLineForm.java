/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.DeliveryLine;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author miro
 */
public class EditDeliveryLineForm extends EditDocumentLineForm {

    private DeliveryLine docLine;

    public EditDeliveryLineForm(DeliveryLine dl) {
        this.docLine = dl;
        nAmountIn.setValue(0);
        mPriceIn.setText(dl.getPrice() + "");
    }

    @Override
    public void saveDocumentLine() {
        int sold = 0;
        float price = 0;
        if (!nAmountIn.getValue().toString().equals("")) {
            sold = Integer.parseInt(nAmountIn.getValue().toString());
        }
        if (!mPriceIn.getText().equals("")) {
            price = Float.parseFloat(mPriceIn.getText());
        }
        try {
            DeliveryOps.editDeliveryLine(docLine, sold, price);
        } catch (IllegalArgumentException iae) {
            DocumentForm.errorDialog(iae.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
