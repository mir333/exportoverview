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
import javax.swing.JDialog;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author xligas
 */
public final class DeliveryForm extends DocumentForm {

    private JDialog addDelivery;
    private JDialog editDeliveryLine;
    private static DeliveryForm instance = null;

    public static DeliveryForm getInstance() {
        if (instance == null) {
            instance = new DeliveryForm();
        }else{
            instance.fillDocComboBox();
        }
        return instance;
    }

    private DeliveryForm() {
        super("Delivery", "title.delivery");
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
        if (addDelivery == null) {
            addDelivery = new AddDelivery(this);
            addDelivery.setLocationRelativeTo(this);
            addDelivery.addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    refresh();
                }
            });
        }
        GuiMain.getApplication().show(addDelivery);
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

    @Override
    public void documentTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            if (editDeliveryLine == null) {

                editDeliveryLine = new EditDeliveryLineForm(this);
                editDeliveryLine.setLocationRelativeTo(this);
                editDeliveryLine.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowDeactivated(WindowEvent evt) {
                        refresh();
                        MainView.refreshTotal();
                    }
                });
            }
            GuiMain.getApplication().show(editDeliveryLine);
        }
    }

    @Override
    public void deleteSelected() {
        Delivery d = (Delivery) docComboBox.getSelectedItem();
        if (d == null) {
            errorDialog("error.noitemselected");
            return;
        }
        if (showDialog("question.delete") == 0) {
            try {
                DeliveryOps.deleteItems(getSeletedDocs(), d.getId());
                dcoSelected();
                refresh();
                MainView.refreshTotal();
            } catch (IllegalArgumentException iae) {
                DocumentForm.errorDialog(iae.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Delivery getSelectedDelviery() {
        Delivery d = (Delivery) docComboBox.getSelectedItem();
        if (d == null) {
            errorDialog("error.delivery.empty");
        }
        return d;
    }

    public DeliveryLine getSelectedDelvieryLine() {
        int index = documentTable.convertRowIndexToModel(documentTable.getSelectedRow());
        return (DeliveryLine) documentLinesList.get(index);
    }

    private void refresh() {
        try {
            Clients c = (Clients) clientComboBox.getSelectedItem();
            int i = docComboBox.getSelectedIndex();
            docList.clear();
            docList.addAll(DeliveryOps.getDeliveriesFromClient(c));
            docComboBox.setSelectedIndex(i);
        } catch (Exception ex) {
            Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
