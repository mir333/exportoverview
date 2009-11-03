package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.InvoiceOps;
import java.util.logging.Level;
import java.util.logging.Logger;
import cz.ligas.exportoverview.db.Invoice;
/**
 *
 * @author miro
 */
public class NewInvioceForm extends ExportForm{

    @Override
    public void createExport(){
       Invoice inv = new Invoice();
        inv.setClient(getClient());
        try {
            InvoiceOps.addInvoice(inv);
        } catch (Exception ex) {
            Logger.getLogger(ExportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
