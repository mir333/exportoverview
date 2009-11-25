package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Delivery;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author xligas
 */
public class DeliveryForm extends DocumentForm {

    public DeliveryForm() {
        super("Delivery", "deliveries");
        myInit();
    }

    private void myInit() {
        try {
            Delivery deliv = (Delivery) docComboBox.getSelectedItem();
            documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveriesLinesForDelivery(deliv));
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable();
    }

    @Override
    public void newDocument() {
        final Delivery d = (Delivery) clientComboBox.getSelectedItem();
        AddDelivery adf = new AddDelivery(d);
        adf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                try {
                    documentLinesList.addAll(null);
                    //    mainTable.updateUI();
                    } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adf.setVisible(true);
    }
}
