package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.DeliveryLine;
import cz.ligas.exportoverview.db.Products;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class AddDelivery extends AddDocumentLineForm {


    public AddDelivery(java.awt.Frame parent) {
        super(parent);
    }

    @Override
    public void addDocumentLine() {
        DeliveryLine dl = new DeliveryLine();
        try {
            int i = MyParser.pareseIntNumber(nAmountIn.getText());
            float f = MyParser.paresePrice(mPriceIn.getText());
            dl.setAmount(i);
            dl.setPrice(f);
            dl.setDocument(DeliveryForm.getInstance().getSelectedDelviery());
            dl.setProd((Products) productComboBox.getSelectedItem());
            dl.setTotal(i * f);
            //overenie vyplnenia
            DeliveryOps.addDeliveryLine(dl);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainView.refreshTotal();
        this.dispose();
    }
}
