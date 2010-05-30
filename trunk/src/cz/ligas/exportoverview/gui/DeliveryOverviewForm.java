package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.db.Document;
import java.beans.Beans;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author miro
 */
public final class DeliveryOverviewForm extends DocumentOverviewForm {

    private static DeliveryOverviewForm instance = null;
    
    public static DeliveryOverviewForm getInstance() {
        if (instance == null) {
            instance = new DeliveryOverviewForm();
        }
        return instance;
    }

    private DeliveryOverviewForm() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentOverviewForm.class);
        topLable.setText(resourceMap.getString("delivery.title"));
        bindingMethod();
        refreshTable();
    }

    @Override
    protected void myInit() {
        try {
            docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(DeliveryOps.getDeliveries());
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void refreshTable() {
        try {
            docList.clear();
            docList.addAll(DeliveryOps.getDeliveries());
        } catch (Exception ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        docsTable.updateUI();
        double total = 0;
        for (Document delivery : docList) {
            total += delivery.getTotal();
        }
        mTotalOut.setValue(total);
    }
}
