/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditWarehouseItemForm.java
 *
 * Created on Oct 8, 2009, 10:10:23 AM
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.WarehouseItemOps;
import cz.ligas.exportoverview.db.WarehouseItem;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;

/**
 *
 * @author miro
 */
public class EditWarehouseItemForm extends javax.swing.JFrame {

    /** Creates new form EditWarehouseItemForm */
    public EditWarehouseItemForm(WarehouseItem whi) {
        this.warehouseItem = whi;
        initComponents();
        myInit();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editWhiItemButton = new javax.swing.JButton();
        editWhItemL = new javax.swing.JLabel();
        editWhItemCountL = new javax.swing.JLabel();
        nEditWhItemCountSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EditWarehouseItemForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setAlwaysOnTop(true);

        editWhiItemButton.setText(resourceMap.getString("editWhiItemButton.text")); // NOI18N
        editWhiItemButton.setName("editWhiItemButton"); // NOI18N

        editWhItemL.setText(resourceMap.getString("editWhItemL.text")); // NOI18N
        editWhItemL.setName("editWhItemL"); // NOI18N

        editWhItemCountL.setText(resourceMap.getString("editWhItemCountL.text")); // NOI18N
        editWhItemCountL.setName("editWhItemCountL"); // NOI18N

        nEditWhItemCountSpinner.setName("nEditWhItemCountSpinner"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editWhiItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editWhItemL)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editWhItemCountL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nEditWhItemCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editWhItemL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editWhItemCountL)
                    .addComponent(nEditWhItemCountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editWhiItemButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editWhiItemButton.getAccessibleContext().setAccessibleName(resourceMap.getString("editWhiItemButton.AccessibleContext.accessibleName")); // NOI18N
        editWhiItemButton.getAccessibleContext().setAccessibleDescription(resourceMap.getString("editWhiItemButton.AccessibleContext.accessibleDescription")); // NOI18N
        editWhItemL.getAccessibleContext().setAccessibleName(resourceMap.getString("editWhItemL.AccessibleContext.accessibleName")); // NOI18N
        editWhItemCountL.getAccessibleContext().setAccessibleName(resourceMap.getString("editWhItemCountL.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel editWhItemCountL;
    private javax.swing.JLabel editWhItemL;
    private javax.swing.JButton editWhiItemButton;
    private javax.swing.JSpinner nEditWhItemCountSpinner;
    // End of variables declaration//GEN-END:variables
    private WarehouseItem warehouseItem;
    private MyInputVerifier verifier = new MyInputVerifier();

    @Action
    public void editExportLineSaveAction() {
        int amount = Integer.parseInt(nEditWhItemCountSpinner.getValue().toString());
        try {
            WarehouseItemOps.editWarehouseItem(warehouseItem,amount);
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    private void myInit() {
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(EditWarehouseItemForm.class, this);
        editWhiItemButton.setAction(actionMap.get("editExportLineSaveAction")); // NOI18N
        nEditWhItemCountSpinner.setValue(warehouseItem.getProductCount());
        nEditWhItemCountSpinner.setInputVerifier(verifier);
        editWhItemCountL.setLabelFor(nEditWhItemCountSpinner);
    }
}
