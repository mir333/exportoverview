package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.db.Invoice;
import cz.ligas.exportoverview.appli.InvoiceOps;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.InvoiceLine;
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
public class InvoiceForm extends DocumentForm {

    public InvoiceForm() {
        super("Invoice");
        myInit();
    }

    private void myInit() {
        try {

            if (clientsList.size() != 0) {
                docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoicesFromClient(clientsList.get(0)));
            } else {
                Invoice inv = new Invoice();
                ArrayList<Invoice> arInv = new ArrayList<Invoice>();
                arInv.add(inv);
                docList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(arInv);
            }
            if (docList.size() != 0) {
                documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoiceLinesForInvoice((Invoice) docList.get(0)));
            } else {
                InvoiceLine invLi = new InvoiceLine();
                ArrayList<InvoiceLine> arInvLi = new ArrayList<InvoiceLine>();
                arInvLi.add(invLi);
                documentLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(arInvLi);
            }
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        bindingMethod();
    }

    @Override
    public void newDocument() {
        final Invoice i = (Invoice) docComboBox.getSelectedItem();
        AddInvoice aiv = new AddInvoice(i);
        aiv.setLocationRelativeTo(documentTable);
        aiv.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                documentLinesList.clear();
                try {
                    documentLinesList.addAll(InvoiceOps.getInvoiceLinesForInvoice(i));
                    documentTable.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        aiv.setVisible(true);
    }

    @Override
    public void fillDocComboBox() {
        if (docList != null) {
            try {

                docList.clear();
                Clients cl = (Clients) clientComboBox.getSelectedItem();
                docList.addAll(Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoicesFromClient(cl)));
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
                Invoice inv = (Invoice) docComboBox.getSelectedItem();
                documentLinesList.addAll(Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(InvoiceOps.getInvoiceLinesForInvoice(inv)));
            } catch (Exception ex) {
                Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     @Override
    public void documentTableMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() > 1) {
            final int index = documentTable.convertRowIndexToModel(documentTable.getSelectedRow());
            EditInvoiceLineForm edlf = new EditInvoiceLineForm((InvoiceLine) documentLinesList.get(index));
            edlf.setLocationRelativeTo(documentTable);
            edlf.addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    try {
                        InvoiceLine invLine = (InvoiceLine) documentLinesList.get(index);
                        invLine = InvoiceOps.getInvoiceLineById(invLine.getId());
                        documentLinesList.set(index, invLine);
                        documentTable.updateUI();
                    } catch (Exception ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            edlf.setVisible(true);
        }
    }
}
