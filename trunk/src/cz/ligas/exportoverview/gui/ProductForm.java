/*
 * ProductForm.java
 *
 * Created on 4.8.2009, 23:30:13
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.CategoryOps;
import cz.ligas.exportoverview.appli.ProductOps;
import cz.ligas.exportoverview.db.ProductCategory;
import cz.ligas.exportoverview.db.Products;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author xligas
 */
public class ProductForm extends javax.swing.JFrame {

    /** Creates new form ProductForm */
    public ProductForm() {
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

        categoryComboBox = new javax.swing.JComboBox();
        categoryL = new javax.swing.JLabel();
        productCodeL = new javax.swing.JLabel();
        productNameL = new javax.swing.JLabel();
        productPriceL = new javax.swing.JLabel();
        productDescL = new javax.swing.JLabel();
        tProductCodeIn = new javax.swing.JTextField();
        tProductNameIn = new javax.swing.JTextField();
        mProductPriceIn = new javax.swing.JTextField();
        tProductDescIn = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(ProductForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryComboBox.setName("categoryComboBox"); // NOI18N

        categoryL.setText(resourceMap.getString("categoryL.text")); // NOI18N
        categoryL.setName("categoryL"); // NOI18N

        productCodeL.setText(resourceMap.getString("productCodeL.text")); // NOI18N
        productCodeL.setName("productCodeL"); // NOI18N

        productNameL.setText(resourceMap.getString("productNameL.text")); // NOI18N
        productNameL.setName("productNameL"); // NOI18N

        productPriceL.setText(resourceMap.getString("productPriceL.text")); // NOI18N
        productPriceL.setName("productPriceL"); // NOI18N

        productDescL.setText(resourceMap.getString("productDescL.text")); // NOI18N
        productDescL.setName("productDescL"); // NOI18N

        tProductCodeIn.setText(resourceMap.getString("tProductCodeIn.text")); // NOI18N
        tProductCodeIn.setName("tProductCodeIn"); // NOI18N

        tProductNameIn.setText(resourceMap.getString("tProductNameIn.text")); // NOI18N
        tProductNameIn.setName("tProductNameIn"); // NOI18N

        mProductPriceIn.setText(resourceMap.getString("mProductPriceIn.text")); // NOI18N
        mProductPriceIn.setName("mProductPriceIn"); // NOI18N

        tProductDescIn.setText(resourceMap.getString("tProductDescIn.text")); // NOI18N
        tProductDescIn.setName("tProductDescIn"); // NOI18N

	        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(ProductForm.class, this);
        saveButton.setAction(actionMap.get("saveProduct")); // NOI18N
        saveButton.setText(resourceMap.getString("saveButton.text")); // NOI18N
        saveButton.setName("saveButton"); // NOI18N

        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productCodeL)
                            .addComponent(productNameL)
                            .addComponent(productPriceL)
                            .addComponent(categoryL)
                            .addComponent(productDescL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mProductPriceIn)
                            .addComponent(tProductNameIn, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(tProductDescIn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tProductCodeIn)
                            .addComponent(categoryComboBox, 0, 327, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryL)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCodeL)
                    .addComponent(tProductCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameL)
                    .addComponent(tProductNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productPriceL)
                    .addComponent(mProductPriceIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tProductDescIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productDescL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void saveProduct() {
        Products p = new Products();
        p.setProductCode(tProductCodeIn.getText());
        p.setProductName(tProductNameIn.getText());
        p.setProductPrice(Float.parseFloat(mProductPriceIn.getText()));
        p.setProductDes(tProductDescIn.getText());
        p.setProductCategoryId((ProductCategory) categoryComboBox.getSelectedItem());
        //overenie vyplnenia
        try {
            ProductOps.addProduct(p);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        System.err.println("saveProduct execution");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryL;
    private javax.swing.JTextField mProductPriceIn;
    private javax.swing.JLabel productCodeL;
    private javax.swing.JLabel productDescL;
    private javax.swing.JLabel productNameL;
    private javax.swing.JLabel productPriceL;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField tProductCodeIn;
    private javax.swing.JTextField tProductDescIn;
    private javax.swing.JTextField tProductNameIn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private List<ProductCategory> categoryList;
    private BindingGroup bindingGroup;
    private MyInputVerifier verifier = new MyInputVerifier();

    private void myInit() {
        bindingGroup = new BindingGroup();
        tProductCodeIn.setInputVerifier(verifier);
        tProductCodeIn.addActionListener(verifier);
        productCodeL.setLabelFor(tProductCodeIn);
        tProductDescIn.setInputVerifier(verifier);
        tProductDescIn.addActionListener(verifier);
        productDescL.setLabelFor(tProductDescIn);
        tProductNameIn.setInputVerifier(verifier);
        tProductNameIn.addActionListener(verifier);
        productNameL.setLabelFor(tProductNameIn);
        mProductPriceIn.setInputVerifier(verifier);
        mProductPriceIn.addActionListener(verifier);
        productPriceL.setLabelFor(mProductPriceIn);
        try {
            categoryList = CategoryOps.getCategories();
        } catch (Exception ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, categoryList, categoryComboBox);
        bindingGroup.addBinding(jComboBoxBinding);
        bindingGroup.bind();
    }
}