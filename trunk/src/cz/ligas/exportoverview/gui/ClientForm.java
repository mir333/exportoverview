/*
 * ClientForm.java
 *
 * Created on 3.8.2009, 21:35:41
 */

package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.db.Clients;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.application.Action;

/**
 *
 * @author xligas
 */
public class ClientForm extends JFrame {

    /** Creates new form ClientForm */
    public ClientForm() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientNameL = new javax.swing.JLabel();
        clientAddressL = new javax.swing.JLabel();
        clientPhoneL = new javax.swing.JLabel();
        clientNameIn = new javax.swing.JTextField();
        clientAddressIn = new javax.swing.JTextField();
        clientPhoneIn = new javax.swing.JTextField();
        clientSaveButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ClientForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        clientNameL.setText(resourceMap.getString("clientNameL.text")); // NOI18N
        clientNameL.setName("clientNameL"); // NOI18N

        clientAddressL.setText(resourceMap.getString("clientAddressL.text")); // NOI18N
        clientAddressL.setName("clientAddressL"); // NOI18N

        clientPhoneL.setText(resourceMap.getString("clientPhoneL.text")); // NOI18N
        clientPhoneL.setName("clientPhoneL"); // NOI18N

        clientNameIn.setText(resourceMap.getString("clientNameIn.text")); // NOI18N
        clientNameIn.setName("clientNameIn"); // NOI18N

        clientAddressIn.setText(resourceMap.getString("clientAddressIn.text")); // NOI18N
        clientAddressIn.setName("clientAddressIn"); // NOI18N

        clientPhoneIn.setText(resourceMap.getString("clientPhoneIn.text")); // NOI18N
        clientPhoneIn.setName("clientPhoneIn"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(ClientForm.class, this);
        clientSaveButton.setAction(actionMap.get("clientSaveAction")); // NOI18N
        clientSaveButton.setText(resourceMap.getString("clientSaveButton.text")); // NOI18N
        clientSaveButton.setName("clientSaveButton"); // NOI18N

        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientNameL)
                            .addComponent(clientAddressL)
                            .addComponent(clientPhoneL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clientNameIn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(clientAddressIn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(clientPhoneIn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                    .addComponent(clientSaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientNameL)
                    .addComponent(clientNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientAddressIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientAddressL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientPhoneIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientPhoneL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientSaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void clientSaveAction() {
       Clients c = new Clients();
       c.setClientName(clientNameIn.getText());
       c.setClientAddress(clientAddressIn.getText());
       c.setClientPhone(clientPhoneIn.getText());
       //overenie vyplnenia

       try {
            ClientOps.addClient(c);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientAddressIn;
    private javax.swing.JLabel clientAddressL;
    private javax.swing.JTextField clientNameIn;
    private javax.swing.JLabel clientNameL;
    private javax.swing.JTextField clientPhoneIn;
    private javax.swing.JLabel clientPhoneL;
    private javax.swing.JButton clientSaveButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
