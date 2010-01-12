package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
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
public final class InvoiceOverviewForm extends DocumentOverviewForm {

    private static InvoiceOverviewForm instance = null;

    public static InvoiceOverviewForm getInstance() {
        if (instance == null) {
            instance = new InvoiceOverviewForm();
        }
        return instance;
    }

    private InvoiceOverviewForm() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentOverviewForm.class);
        topLable.setText(resourceMap.getString("invoice.title"));
        bindingMethod();
        refreshTable();
    }

    @Override
    protected void myInit() {
        try {
            docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoices());
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void refreshTable() {
        try {
            docList.clear();
            docList.addAll(InvoiceOps.getInvoices());
        } catch (Exception ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        docsTable.updateUI();
        float total = 0;
        for (Document invoice : docList) {
            total += invoice.getTotal();
        }
        mTotalOut.setValue(total);
    }
}
