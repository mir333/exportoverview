package cz.ligas.exportoverview.gui;

import org.jdesktop.application.Action;

/**
 *
 * @author miro
 */
public class EditDocumentLineForm extends javax.swing.JDialog {

    /** Creates new form EditDocumentLineFOrm */
    public EditDocumentLineForm(java.awt.Frame parent) {
        super(parent);
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

        editDocumentLineL = new javax.swing.JLabel();
        amountL = new javax.swing.JLabel();
        priceL = new javax.swing.JLabel();
        mPriceIn = new javax.swing.JTextField();
        nAmountIn = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(EditDocumentLineForm.class);
        setTitle(resourceMap.getString("title")); // NOI18N

        editDocumentLineL.setText(resourceMap.getString("editDocumentLineL.text")); // NOI18N
        editDocumentLineL.setName("editDocumentLineL"); // NOI18N

        amountL.setText(resourceMap.getString("amountL.text")); // NOI18N
        amountL.setName("amountL"); // NOI18N

        priceL.setText(resourceMap.getString("priceL.text")); // NOI18N
        priceL.setName("priceL"); // NOI18N

        mPriceIn.setName("mPriceIn"); // NOI18N

        nAmountIn.setName("nAmountIn"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(EditDocumentLineForm.class, this);
        saveButton.setAction(actionMap.get("saveDocumentLine")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(amountL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nAmountIn))
                        .addComponent(editDocumentLineL, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(saveButton)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(priceL)
                            .addGap(18, 18, 18)
                            .addComponent(mPriceIn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editDocumentLineL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amountL)
                    .addComponent(nAmountIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceL)
                    .addComponent(mPriceIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel amountL;
    protected javax.swing.JLabel editDocumentLineL;
    protected javax.swing.JTextField mPriceIn;
    protected javax.swing.JSpinner nAmountIn;
    protected javax.swing.JLabel priceL;
    protected javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    private MyInputVerifier verifier = new MyInputVerifier();

    private void myInit() {
        nAmountIn.setInputVerifier(verifier);
        amountL.setLabelFor(nAmountIn);
        mPriceIn.setInputVerifier(verifier);
        mPriceIn.addActionListener(verifier);
        priceL.setLabelFor(mPriceIn);
        setAlwaysOnTop(true);
    }

    @Action
    public void saveDocumentLine() {
        System.err.println("Not overriden");
    }
}
