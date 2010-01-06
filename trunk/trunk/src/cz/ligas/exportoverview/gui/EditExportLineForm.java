package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ExportLineOps;
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

        exportLineSentL = new javax.swing.JLabel();
        exportLineSoldL = new javax.swing.JLabel();
        nExportLineSentSpinner = new javax.swing.JSpinner();
        nExportLineSoldSpinner = new javax.swing.JSpinner();
        exportLineSaveButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        mExportLinePriceTextfield = new javax.swing.JTextField();
        exportLinePriceL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EditExportLineForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setAlwaysOnTop(true);
        setName("Form"); // NOI18N

        exportLineSentL.setText(resourceMap.getString("exportLineSentL.text")); // NOI18N
        exportLineSentL.setName("exportLineSentL"); // NOI18N

        exportLineSoldL.setText(resourceMap.getString("exportLineSoldL.text")); // NOI18N
        exportLineSoldL.setName("exportLineSoldL"); // NOI18N

        nExportLineSentSpinner.setName("nExportLineSentSpinner"); // NOI18N

        nExportLineSoldSpinner.setName("nExportLineSoldSpinner"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(EditExportLineForm.class, this);
        exportLineSaveButton.setAction(actionMap.get("editExportLineSaveAction")); // NOI18N
        exportLineSaveButton.setText(resourceMap.getString("exportLineSaveButton.text")); // NOI18N
        exportLineSaveButton.setName("exportLineSaveButton"); // NOI18N

        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        mExportLinePriceTextfield.setText(resourceMap.getString("mExportLinePriceTextfield.text")); // NOI18N
        mExportLinePriceTextfield.setName("mExportLinePriceTextfield"); // NOI18N

        exportLinePriceL.setText(resourceMap.getString("exportLinePriceL.text")); // NOI18N
        exportLinePriceL.setName("exportLinePriceL"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exportLinePriceL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mExportLinePriceTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(titleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exportLineSentL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nExportLineSentSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportLineSoldL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nExportLineSoldSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addComponent(exportLineSaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mExportLinePriceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportLinePriceL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportLineSentL)
                    .addComponent(nExportLineSentSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nExportLineSoldSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportLineSoldL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportLineSaveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exportLinePriceL;
    private javax.swing.JButton exportLineSaveButton;
    private javax.swing.JLabel exportLineSentL;
    private javax.swing.JLabel exportLineSoldL;
    private javax.swing.JTextField mExportLinePriceTextfield;
    private javax.swing.JSpinner nExportLineSentSpinner;
    private javax.swing.JSpinner nExportLineSoldSpinner;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private ExportLine exportLine;
    private MyInputVerifier verifier = new MyInputVerifier();

    @Action
    public void editExportLineSaveAction() {
        //TODO: ak to bude robit moc bordel zmenit spinre na text
        int send = 0;
        int sold = 0;
        try {
            float price = exportLine.getPrice();
            if (!nExportLineSentSpinner.getValue().toString().equals("")) {
                send = MyParser.pareseIntNumber(nExportLineSentSpinner.getValue().toString());
            }
            if (!nExportLineSoldSpinner.getValue().toString().equals("")) {
                sold = MyParser.pareseIntNumber(nExportLineSoldSpinner.getValue().toString());
            }
            if (!mExportLinePriceTextfield.getText().equals("")) {
                price = MyParser.paresePrice(mExportLinePriceTextfield.getText());
            }
            ExportLineOps.editExportLine(exportLine, send, sold, price);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }

    private void myInit() {
        mExportLinePriceTextfield.setText(exportLine.getPrice() + "");
        mExportLinePriceTextfield.setInputVerifier(verifier);
        exportLinePriceL.setLabelFor(mExportLinePriceTextfield);
        nExportLineSentSpinner.setValue(0);
        nExportLineSentSpinner.setInputVerifier(verifier);
        exportLineSentL.setLabelFor(nExportLineSentSpinner);
        nExportLineSoldSpinner.setValue(0);
        nExportLineSoldSpinner.setInputVerifier(verifier);
        exportLineSoldL.setLabelFor(nExportLineSoldSpinner);

    }
}
