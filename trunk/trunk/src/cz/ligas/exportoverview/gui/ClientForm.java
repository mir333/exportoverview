/*
 * ClientForm.java
 *
 * Created on 3.8.2009, 21:35:41
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.util.MyInputVerifier;
import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.db.Clients;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import org.jdesktop.application.Action;

/**
 *
 * @author xligas
 */
public class ClientForm extends JDialog {

    /** Creates new form ClientForm */
    public ClientForm(java.awt.Frame parent) {
        super(parent);
        initComponents();
        myInit();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientNameL = new javax.swing.JLabel();
        clientAddressL = new javax.swing.JLabel();
        clientPhoneL = new javax.swing.JLabel();
        tClientNameIn = new javax.swing.JTextField();
        tClientAddressIn = new javax.swing.JTextField();
        tClientPhoneIn = new javax.swing.JTextField();
        clientSaveButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        zipCodeL = new javax.swing.JLabel();
        countryL = new javax.swing.JLabel();
        cityL = new javax.swing.JLabel();
        tZipCodeIn = new javax.swing.JTextField();
        tCityIn = new javax.swing.JTextField();
        tCountryIn = new javax.swing.JTextField();
        icoL = new javax.swing.JLabel();
        dicL = new javax.swing.JLabel();
        tICOIn = new javax.swing.JTextField();
        tDICIn = new javax.swing.JTextField();
        companyL = new javax.swing.JLabel();
        tClienCompanyIn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ClientForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setMinimumSize(new java.awt.Dimension(409, 221));
        setModal(true);
        setName("Form"); // NOI18N
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        clientNameL.setText(resourceMap.getString("clientNameL.text")); // NOI18N
        clientNameL.setName("clientNameL"); // NOI18N

        clientAddressL.setText(resourceMap.getString("clientAddressL.text")); // NOI18N
        clientAddressL.setName("clientAddressL"); // NOI18N

        clientPhoneL.setText(resourceMap.getString("clientPhoneL.text")); // NOI18N
        clientPhoneL.setName("clientPhoneL"); // NOI18N

        tClientNameIn.setText(resourceMap.getString("tClientNameIn.text")); // NOI18N
        tClientNameIn.setName("tClientNameIn"); // NOI18N

        tClientAddressIn.setText(resourceMap.getString("tClientAddressIn.text")); // NOI18N
        tClientAddressIn.setName("tClientAddressIn"); // NOI18N

        tClientPhoneIn.setText(resourceMap.getString("tClientPhoneIn.text")); // NOI18N
        tClientPhoneIn.setName("tClientPhoneIn"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(ClientForm.class, this);
        clientSaveButton.setAction(actionMap.get("clientSaveAction")); // NOI18N
        clientSaveButton.setText(resourceMap.getString("clientSaveButton.text")); // NOI18N
        clientSaveButton.setName("clientSaveButton"); // NOI18N

        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        zipCodeL.setText(resourceMap.getString("zipCodeL.text")); // NOI18N
        zipCodeL.setName("zipCodeL"); // NOI18N

        countryL.setText(resourceMap.getString("countryL.text")); // NOI18N
        countryL.setName("countryL"); // NOI18N

        cityL.setText(resourceMap.getString("cityL.text")); // NOI18N
        cityL.setName("cityL"); // NOI18N

        tZipCodeIn.setText(resourceMap.getString("tZipCodeIn.text")); // NOI18N
        tZipCodeIn.setName("tZipCodeIn"); // NOI18N

        tCityIn.setText(resourceMap.getString("tCityIn.text")); // NOI18N
        tCityIn.setName("tCityIn"); // NOI18N

        tCountryIn.setText(resourceMap.getString("tCountryIn.text")); // NOI18N
        tCountryIn.setName("tCountryIn"); // NOI18N

        icoL.setText(resourceMap.getString("icoL.text")); // NOI18N
        icoL.setName("icoL"); // NOI18N

        dicL.setText(resourceMap.getString("dicL.text")); // NOI18N
        dicL.setName("dicL"); // NOI18N

        tICOIn.setText(resourceMap.getString("tICOIn.text")); // NOI18N
        tICOIn.setName("tICOIn"); // NOI18N

        tDICIn.setText(resourceMap.getString("tDICIn.text")); // NOI18N
        tDICIn.setName("tDICIn"); // NOI18N

        companyL.setText(resourceMap.getString("companyL.text")); // NOI18N
        companyL.setName("companyL"); // NOI18N

        tClienCompanyIn.setText(resourceMap.getString("tClienCompanyIn.text")); // NOI18N
        tClienCompanyIn.setName("tClienCompanyIn"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titleLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(clientNameL)
                                        .addComponent(countryL)
                                        .addComponent(clientPhoneL)
                                        .addComponent(companyL))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tClientPhoneIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addComponent(tCountryIn, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addComponent(tClientNameIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(tZipCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cityL))
                                                .addComponent(tClienCompanyIn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(clientAddressL)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tClientAddressIn, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                                .addComponent(tCityIn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tICOIn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dicL)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tDICIn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))))
                            .addContainerGap())
                        .addComponent(zipCodeL)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(icoL)
                            .addContainerGap(380, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(clientSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameL)
                    .addComponent(tClientNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tClientAddressIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientAddressL, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyL)
                    .addComponent(tClienCompanyIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipCodeL)
                    .addComponent(tZipCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityL)
                    .addComponent(tCityIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryL)
                    .addComponent(tCountryIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientPhoneL)
                    .addComponent(tClientPhoneIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(icoL)
                    .addComponent(tICOIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDICIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dicL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientSaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        fill();
    }//GEN-LAST:event_formComponentShown

    @Action
    public void clientSaveAction() {
        Clients c = new Clients();
        c.setClientName(tClientNameIn.getText());
        c.setCompany(tClienCompanyIn.getText());
        c.setClientAddress(tClientAddressIn.getText());
        c.setClientPhone(tClientPhoneIn.getText());
        c.setPsc(tZipCodeIn.getText());
        c.setCity(tCityIn.getText());
        c.setCountry(tCountryIn.getText());
        c.setIco(tICOIn.getText());
        c.setDic(tDICIn.getText());

        try {
            ClientOps.addClient(c);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel cityL;
    protected javax.swing.JLabel clientAddressL;
    protected javax.swing.JLabel clientNameL;
    protected javax.swing.JLabel clientPhoneL;
    protected javax.swing.JButton clientSaveButton;
    protected javax.swing.JLabel companyL;
    protected javax.swing.JLabel countryL;
    protected javax.swing.JLabel dicL;
    protected javax.swing.JLabel icoL;
    protected javax.swing.JTextField tCityIn;
    protected javax.swing.JTextField tClienCompanyIn;
    protected javax.swing.JTextField tClientAddressIn;
    protected javax.swing.JTextField tClientNameIn;
    protected javax.swing.JTextField tClientPhoneIn;
    protected javax.swing.JTextField tCountryIn;
    protected javax.swing.JTextField tDICIn;
    protected javax.swing.JTextField tICOIn;
    protected javax.swing.JTextField tZipCodeIn;
    protected javax.swing.JLabel titleLabel;
    protected javax.swing.JLabel zipCodeL;
    // End of variables declaration//GEN-END:variables
    protected MyInputVerifier verifier = new MyInputVerifier();

    private void myInit() {

        tClientNameIn.setInputVerifier(verifier);
        tClientNameIn.addActionListener(verifier);
        clientNameL.setLabelFor(tClientNameIn);
        tClientAddressIn.setInputVerifier(verifier);
        tClientAddressIn.addActionListener(verifier);
        clientAddressL.setLabelFor(tClientAddressIn);
        tClienCompanyIn.setInputVerifier(verifier);
        tClienCompanyIn.addActionListener(verifier);
        companyL.setLabelFor(tClienCompanyIn);
        tCountryIn.setInputVerifier(verifier);
        tCountryIn.addActionListener(verifier);
        countryL.setLabelFor(tCountryIn);
        tZipCodeIn.setInputVerifier(verifier);
        tZipCodeIn.addActionListener(verifier);
        zipCodeL.setLabelFor(tZipCodeIn);
        tDICIn.setInputVerifier(verifier);
        tDICIn.addActionListener(verifier);
        dicL.setLabelFor(tDICIn);
        tICOIn.setInputVerifier(verifier);
        tICOIn.addActionListener(verifier);
        icoL.setLabelFor(tICOIn);
        tClientPhoneIn.setInputVerifier(verifier);
        tClientPhoneIn.addActionListener(verifier);
        clientPhoneL.setLabelFor(tClientPhoneIn);
    }

    protected void fill() {
        tClientNameIn.setText("");
        tClientAddressIn.setText("");
        tClienCompanyIn.setText("");
        tCountryIn.setText("");
        tZipCodeIn.setText("");
        tDICIn.setText("");
        tICOIn.setText("");
        tClientPhoneIn.setText("");
    }
}
