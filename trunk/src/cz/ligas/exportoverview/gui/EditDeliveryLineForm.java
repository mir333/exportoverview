package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditDeliveryLineForm extends EditDocumentLineForm {


    public EditDeliveryLineForm(java.awt.Frame parent) {
        super(parent);
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
            DeliveryOps.editDeliveryLine(DeliveryForm.getInstance().getSelectedDelvieryLine(), sold, price);
            this.dispose();
        } catch (ParseException ex) {
            MyUtilErrorClass.errorDialog("validation.error.field");
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void fill(){
        nAmountIn.setValue(0);
        mPriceIn.setText(DeliveryForm.getInstance().getSelectedDelvieryLine().getPrice() + "");
    }
}
