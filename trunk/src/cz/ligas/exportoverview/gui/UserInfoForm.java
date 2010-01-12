/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.db.UserInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author miro
 */
class UserInfoForm extends ClientForm {

    boolean isEmpty;
    private JLabel bankNameL;
    private JTextField tBankNameIn;
    private JLabel bankNoL;
    private JTextField tBankNoIn;
    private javax.swing.JLabel isbanL;
    private javax.swing.JLabel swiftL;
    private javax.swing.JTextField tIsbanIn;
    private javax.swing.JTextField tSwiftIn;

    public UserInfoForm(java.awt.Frame parent) {
        super(parent);
        bankNameL = new javax.swing.JLabel();
        tBankNameIn = new javax.swing.JTextField();
        bankNoL = new javax.swing.JLabel();
        tBankNoIn = new javax.swing.JTextField();
        isbanL = new javax.swing.JLabel();
        swiftL = new javax.swing.JLabel();
        tSwiftIn = new javax.swing.JTextField();
        tIsbanIn = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(UserInfoForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        bankNameL.setText(resourceMap.getString("bankNameL.text")); // NOI18N
        bankNameL.setName("bankNameL"); // NOI18N

        tBankNameIn.setText(resourceMap.getString("tBankNameIn.text")); // NOI18N
        tBankNameIn.setName("tBankNameIn"); // NOI18N

        bankNoL.setText(resourceMap.getString("bankNoL.text")); // NOI18N
        bankNoL.setName("bankNoL"); // NOI18N

        tBankNoIn.setText(resourceMap.getString("tBankNoIn.text")); // NOI18N
        tBankNoIn.setName("tBankNoIn"); // NOI18N

        swiftL.setText(resourceMap.getString("swiftL.text")); // NOI18N
        swiftL.setName("swiftL"); // NOI18N

        tSwiftIn.setText(resourceMap.getString("tSwiftIn.text")); // NOI18N
        tSwiftIn.setName("tSwiftIn"); // NOI18N

        isbanL.setText(resourceMap.getString("isbanL.text")); // NOI18N
        isbanL.setName("isbanL"); // NOI18N

        tIsbanIn.setText(resourceMap.getString("tIsbanIn.text")); // NOI18N
        tIsbanIn.setName("tIsbanIn"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(titleLabel).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(clientNameL).addComponent(countryL).addComponent(clientPhoneL).addComponent(companyL)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(tClientPhoneIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE).addComponent(tCountryIn, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE).addComponent(tClientNameIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(tZipCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cityL)).addComponent(tClienCompanyIn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(clientAddressL).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tClientAddressIn, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)).addComponent(tCityIn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(tIsbanIn).addComponent(tBankNameIn).addComponent(tICOIn, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(bankNoL).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tBankNoIn, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(dicL).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tDICIn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(swiftL).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(tSwiftIn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))))).addContainerGap()).addComponent(zipCodeL).addGroup(layout.createSequentialGroup().addComponent(icoL).addContainerGap(380, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(clientSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(bankNameL).addContainerGap(372, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup().addComponent(isbanL).addContainerGap(368, Short.MAX_VALUE)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(titleLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(clientNameL).addComponent(tClientNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(tClientAddressIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(clientAddressL, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(companyL).addComponent(tClienCompanyIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(zipCodeL).addComponent(tZipCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(cityL).addComponent(tCityIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(countryL).addComponent(tCountryIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(clientPhoneL).addComponent(tClientPhoneIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(icoL).addComponent(tICOIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tDICIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(dicL)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(bankNameL).addComponent(bankNoL).addComponent(tBankNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tBankNoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(isbanL).addComponent(swiftL).addComponent(tSwiftIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(tIsbanIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE).addComponent(clientSaveButton).addContainerGap()));

        pack();
        setAlwaysOnTop(true);

        tBankNameIn.setInputVerifier(verifier);
        tBankNameIn.addActionListener(verifier);
        bankNameL.setLabelFor(tBankNameIn);
        tBankNoIn.setInputVerifier(verifier);
        tBankNoIn.addActionListener(verifier);
        bankNoL.setLabelFor(tBankNoIn);
        tSwiftIn.setInputVerifier(verifier);
        tSwiftIn.addActionListener(verifier);
        swiftL.setLabelFor(tSwiftIn);
        tIsbanIn.setInputVerifier(verifier);
        tIsbanIn.addActionListener(verifier);
        isbanL.setLabelFor(tIsbanIn);

        fill();
        setFocusable(true);
    }

    @Override
    public void clientSaveAction() {
        try {
            if (isEmpty) {
                ClientOps.addUserInfo(getUserInfo());
            } else {
                ClientOps.editUserInfo(getUserInfo());
            }
            this.dispose();
        } catch (UnsupportedOperationException ex) {
            JOptionPane.showMessageDialog(this,
                    "Fill the form pleas.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {

            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected UserInfo getUserInfo() {
        UserInfo ui = new UserInfo();
        if (!tClientNameIn.getText().equals("")) {
            ui.setClientName(tClientNameIn.getText());
        } else {
            throw new UnsupportedOperationException("Empty argument fiels");
        }
        ui.setCompany(tClienCompanyIn.getText());
        ui.setClientAddress(tClientAddressIn.getText());
        ui.setClientPhone(tClientPhoneIn.getText());
        ui.setPsc(tZipCodeIn.getText());
        ui.setCity(tCityIn.getText());
        ui.setCountry(tCountryIn.getText());
        ui.setIco(tICOIn.getText());
        ui.setDic(tDICIn.getText());
        ui.setBank(tBankNameIn.getText());
        ui.setBankNo(tBankNoIn.getText());
        ui.setIsban(tIsbanIn.getText());
        ui.setSwift(tSwiftIn.getText());
        return ui;
    }

    protected void setUserInfo(UserInfo ui) {
        tClientNameIn.setText(ui.getClientName());
        tClienCompanyIn.setText(ui.getCompany());
        tClientAddressIn.setText(ui.getClientAddress());
        tClientPhoneIn.setText(ui.getClientPhone());
        tZipCodeIn.setText(ui.getPsc());
        tCityIn.setText(ui.getCity());
        tCountryIn.setText(ui.getCountry());
        tICOIn.setText(ui.getIco());
        tDICIn.setText(ui.getDic());
        tBankNameIn.setText(ui.getBank());
        tBankNoIn.setText(ui.getBankNo());
        tSwiftIn.setText(ui.getSwift());
        tIsbanIn.setText(ui.getIsban());
    }

    @Override
    protected void fill() {
        isEmpty = ClientOps.isUserInfoEmpty();
        if (!isEmpty) {
            try {
                setUserInfo(ClientOps.getUserInfo());
            } catch (Exception ex) {
                Logger.getLogger(UserInfoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
