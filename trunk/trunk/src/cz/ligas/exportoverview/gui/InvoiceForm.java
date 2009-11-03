package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.db.ExportLine;
import java.beans.Beans;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author xligas
 */
public class InvoiceForm extends DeliveryInvoiceForm {

    private List<ExportLine> exportLinesList;

    public InvoiceForm() {
        super("Invoice","invoices");
        myInit();
    }

    private void myInit() {
        try {
            exportLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ExportLineOps.getExportLine());
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTable(exportLinesList);
    }
}
