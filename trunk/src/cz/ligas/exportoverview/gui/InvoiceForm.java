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
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author xligas
 */
public class InvoiceForm extends DocumentForm {

    private JDialog addInvoice;
    private JDialog editInvoice;

    public InvoiceForm() {
        super("Invoice", "title.invoice");
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
        Invoice i = (Invoice) docComboBox.getSelectedItem();
        if (i == null) {
            errorDialog("error.invoice.empty");
            return;
        }
        if (addInvoice == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            addInvoice = new AddInvoice(i, mainFrame);
            addInvoice.setLocationRelativeTo(mainFrame);
            addInvoice.addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    refresh();
                }
            });
        }
        GuiMain.getApplication().show(addInvoice);
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
            if (editInvoice == null) {
                int index = documentTable.convertRowIndexToModel(documentTable.getSelectedRow());
                JFrame mainFrame = GuiMain.getApplication().getMainFrame();
                editInvoice = new EditInvoiceLineForm((InvoiceLine) documentLinesList.get(index), mainFrame);
                editInvoice.setLocationRelativeTo(mainFrame);
                editInvoice.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowDeactivated(WindowEvent evt) {
                        refresh();
                        MainView.refreshTotal();
                    }
                });
            }
            GuiMain.getApplication().show(editInvoice);
        }
    }

    @Override
    public void deleteSelected() {
        Invoice i = (Invoice) docComboBox.getSelectedItem();
        if (i == null) {
            errorDialog("error.noitemselected");
            return;
        }
        if (showDialog("question.delete") == 0) {
            try {
                InvoiceOps.deleteItems(getSeletedDocs(), i.getId());
                dcoSelected();
                refresh();
                MainView.refreshTotal();
            } catch (Exception ex) {
                Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void refresh() {
        try {
            Clients c = (Clients) clientComboBox.getSelectedItem();
            int i = docComboBox.getSelectedIndex();
            docList.clear();
            docList.addAll(InvoiceOps.getInvoicesFromClient(c));
            docComboBox.setSelectedIndex(i);
        } catch (Exception ex) {
            Logger.getLogger(DeliveryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
