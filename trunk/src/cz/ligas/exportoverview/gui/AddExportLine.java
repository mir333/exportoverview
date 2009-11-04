/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.appli.ExportOps;
import cz.ligas.exportoverview.db.Export;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author miro
 */
public class AddExportLine extends AddProductForm {

    Export export = new Export();

    public AddExportLine(Export e) {
        this.export = e;
    }

    @Override
    public void addExportLine(){
        ExportLine el = new ExportLine();
        el.setProd(getSelectedProduct());
        el.setExport((Export)export);
        el.setPrice(getSpecialPriceIn());
        el.setSent(getSendIn());
        el.setSold(getSoldIn());
        try {
            ExportLineOps.addExportLine(el);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExportOps.recalculateExport(export);
        this.dispose();
    }
}