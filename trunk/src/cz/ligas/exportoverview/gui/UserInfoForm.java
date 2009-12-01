/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miro
 */
class UserInfoForm extends ClientForm {

    boolean isEmpty;

    public UserInfoForm() {
        isEmpty = ClientOps.isUserInfoEmpty();
        if (!isEmpty) {
            try {
                setUserInfo(ClientOps.getUserInfo().get(0));
            } catch (Exception ex) {
                Logger.getLogger(UserInfoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void clientSaveAction() {
        try {
            if (isEmpty) {
                ClientOps.addUserInfo(getUserInfo());
            } else {
                ClientOps.editUserInfo(getUserInfo());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
}
