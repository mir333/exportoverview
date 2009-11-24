package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.db.Delivery;
import cz.ligas.exportoverview.db.ExportLine;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class DeliveryForm extends DocumentForm {

    private List<ExportLine> exportLinesList;

    public DeliveryForm() {
        super("Delivery","deliveries");
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

    @Override
    public void newDi() {
        final Delivery d = (Delivery) getSelectedItem();
        AddDelivery adf = new AddDelivery(d);
        adf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                exportLinesList.clear();
                try {
                    exportLinesList.addAll(null);
                //    mainTable.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        adf.setVisible(true);
    }
}
