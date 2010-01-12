package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.db.Clients;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
public class EditClientForm extends ClientForm {

    public EditClientForm(java.awt.Frame parent) {
        super(parent);
        setAlwaysOnTop(true);
    }

    @Override
    public void clientSaveAction() {
        Clients c = new Clients();
        try {
            c.setId(MainView.getInstance().getSelectedClient().getId());
            c.setClientName(tClientNameIn.getText());
            c.setCompany(tClienCompanyIn.getText());
            c.setClientAddress(tClientAddressIn.getText());
            c.setClientPhone(tClientPhoneIn.getText());
            c.setPsc(tZipCodeIn.getText());
            c.setCity(tCityIn.getText());
            c.setCountry(tCountryIn.getText());
            c.setIco(tICOIn.getText());
            c.setDic(tDICIn.getText());
            ClientOps.editClient(c);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    @Override
    protected void fill(){
            try {
            Clients c = ClientOps.getClientById(MainView.getInstance().getSelectedClient().getId());
            tCityIn.setText(c.getCity());
            tClienCompanyIn.setText(c.getCompany());
            tClientAddressIn.setText(c.getClientAddress());
            tClientNameIn.setText(c.getClientName());
            tClientPhoneIn.setText(c.getClientPhone());
            tCountryIn.setText(c.getCountry());
            tDICIn.setText(c.getDic());
            tICOIn.setText(c.getIco());
            tZipCodeIn.setText(c.getPsc());
        } catch (Exception ex) {
            Logger.getLogger(EditClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
