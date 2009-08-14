/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditExportLineForm.java
 *
 * Created on 9.8.2009, 11:56:22
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.appli.ExportOps;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;

/**
 *
 * @author xligas
 */
public class EditExportLineForm extends javax.swing.JFrame {

    /** Creates new form EditExportLineForm */
    public EditExportLineForm(ExportLine el) {
        this.exportLine = el;
        initComponents();
     }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exportLineSentL = new javax.swing.JLabel();
        exportLineSoldL = new javax.swing.JLabel();
        exportLineSentSpinner = new javax.swing.JSpinner();
        exportLineSoldSpinner = new javax.swing.JSpinner();
        exportLineSaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getResourceMap(EditExportLineForm.class);
        exportLineSentL.setText(resourceMap.getString("exportLineSentL.text")); // NOI18N
        exportLineSentL.setName("exportLineSentL"); // NOI18N

        exportLineSoldL.setText(resourceMap.getString("exportLineSoldL.text")); // NOI18N
        exportLineSoldL.setName("exportLineSoldL"); // NOI18N

        exportLineSentSpinner.setName("exportLineSentSpinner"); // NOI18N

        exportLineSoldSpinner.setName("exportLineSoldSpinner"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(EditExportLineForm.class, this);
        exportLineSaveButton.setAction(actionMap.get("editExportLineSaveAction")); // NOI18N
        exportLineSaveButton.setText(resourceMap.getString("exportLineSaveButton.text")); // NOI18N
        exportLineSaveButton.setName("exportLineSaveButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exportLineSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportLineSentL)
                            .addComponent(exportLineSoldL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exportLineSoldSpinner)
                            .addComponent(exportLineSentSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportLineSentL)
                    .addComponent(exportLineSentSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportLineSoldL)
                    .addComponent(exportLineSoldSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportLineSaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportLineSaveButton;
    private javax.swing.JLabel exportLineSentL;
    private javax.swing.JSpinner exportLineSentSpinner;
    private javax.swing.JLabel exportLineSoldL;
    private javax.swing.JSpinner exportLineSoldSpinner;
    // End of variables declaration//GEN-END:variables
    private ExportLine exportLine;

    @Action
    public void editExportLineSaveAction() {
        int send = Integer.parseInt(exportLineSentSpinner.getValue().toString());
        int sold = Integer.parseInt(exportLineSoldSpinner.getValue().toString());
        try {
            ExportLineOps.editExportLine(exportLine,send,sold);
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExportOps.recalculateExport(exportLine.getExport());
        this.dispose();
    }
}