/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.DeliveryLine;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditDeliveryLineForm extends EditDocumentLineForm {

    private DeliveryLine docLine;

    public EditDeliveryLineForm(DeliveryLine dl){
        this.docLine = dl;
        nAmountIn.setValue(dl.getAmount());
        mPriceIn.setText(dl.getPrice()+"");
    }

    @Override
    public void saveDocumentLine(){
        int sold = Integer.parseInt(nAmountIn.getValue().toString());
        float price = Float.parseFloat(mPriceIn.getText());
                try {
            DeliveryOps.editDeliveryLine(docLine,sold, price);
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
