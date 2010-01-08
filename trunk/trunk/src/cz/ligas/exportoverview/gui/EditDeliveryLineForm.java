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

    public EditDeliveryLineForm(DeliveryLine dl,java.awt.Frame parent) {
        super(parent);
        this.docLine = dl;
        nAmountIn.setValue(0);
        mPriceIn.setText(dl.getPrice() + "");
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
            DeliveryOps.editDeliveryLine(docLine, sold, price);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
