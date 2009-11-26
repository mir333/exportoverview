package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.DeliveryLine;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.util.ArrayList;
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
        super("Delivery");
        myInit();
    }

    private void myInit() {
        try {

            if (clientsList.size() != 0) {
                docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveriesFromClient(clientsList.get(0)));
            } else {
                Delivery dl = new Delivery();
                ArrayList<Delivery> ardl = new ArrayList<Delivery>();
                ardl.add(dl);
                docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ardl);
            }
            if (docList.size() != 0) {
                documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveriesLinesForDelivery((Delivery) docList.get(0)));
            } else {
                DeliveryLine dlLi = new DeliveryLine();
                ArrayList<DeliveryLine> ardlLi = new ArrayList<DeliveryLine>();
                ardlLi.add(dlLi);
                documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ardlLi);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        bindingMethod();
    }

    @Override
    public void newDocument() {
        final Delivery d = (Delivery) docComboBox.getSelectedItem();
        AddDelivery adf = new AddDelivery(d);
        adf.setLocationRelativeTo(documentTable);
        adf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                documentLinesList.clear();
                try {
                    documentLinesList.addAll(DeliveryOps.getDeliveriesLinesForDelivery(d));
                    documentTable.updateUI();
                    } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adf.setVisible(true);
    }

    @Override
    public void fillDocComboBox() {
        if (docList != null) {
            try {

                docList.clear();
                Clients cl = (Clients) clientComboBox.getSelectedItem();
                docList.addAll(Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveriesFromClient(cl)));
            } catch (Exception ex) {
                Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void dcoSelected() {
        if (documentLinesList != null) {
            try {
                documentLinesList.clear();
                Delivery dl = (Delivery) docComboBox.getSelectedItem();
                documentLinesList.addAll(Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveriesLinesForDelivery(dl)));
            } catch (Exception ex) {
                Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
