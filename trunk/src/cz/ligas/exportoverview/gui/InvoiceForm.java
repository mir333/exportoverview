package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.Invoice;
import cz.ligas.exportoverview.appli.DeliveryOps;
import cz.ligas.exportoverview.appli.InvoiceOps;
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
public class InvoiceForm extends DocumentForm {

    public InvoiceForm() {
        super("Invoice", "invoices");
        myInit();
    }

    private void myInit() {
        try {
            Invoice inv = (Invoice) docComboBox.getSelectedItem();
            documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoiceLinesForInvoice(inv));
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable();
    }

    @Override
    public void newDocument() {
        final Invoice i = (Invoice) clientComboBox.getSelectedItem();
        AddInvoice aiv = new AddInvoice(i);
        aiv.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                documentLinesList.clear();
                try {
                    documentLinesList.addAll(null);
                    //    mainTable.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        aiv.setVisible(true);
    }
}
