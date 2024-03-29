package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.util.MyParser;
import cz.ligas.exportoverview.util.MyUtilErrorClass;
import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.DeliveryLine;
import cz.ligas.exportoverview.db.Products;
import cz.ligas.exportoverview.exceptoions.NoProductsInWarehouseException;
import java.text.ParseException;
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
            double f = MyParser.paresePrice(mPriceIn.getText());
            dl.setAmount(i);
            dl.setPrice(f);
            dl.setDocument(doc);
            dl.setProd((Products) productComboBox.getSelectedItem());
            dl.setTotal(i * f);
            //overenie vyplnenia
            DeliveryOps.addDeliveryLine(dl);
        } catch (ParseException ex) {
            MyUtilErrorClass.errorDialog("validation.error.field");
        } catch (NoProductsInWarehouseException ex) {
            MyUtilErrorClass.errorDialog(ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainView.refreshTotal();
        this.dispose();
    }
}
