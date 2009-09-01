/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
        productCodeIn = new javax.swing.JTextField();
        productNameIn = new javax.swing.JTextField();
        productPriceIn = new javax.swing.JTextField();
        productDescIn = new javax.swing.JTextField();
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

        productCodeIn.setText(resourceMap.getString("productCodeIn.text")); // NOI18N
        productCodeIn.setName("productCodeIn"); // NOI18N

        productNameIn.setText(resourceMap.getString("productNameIn.text")); // NOI18N
        productNameIn.setName("productNameIn"); // NOI18N

        productPriceIn.setText(resourceMap.getString("productPriceIn.text")); // NOI18N
        productPriceIn.setName("productPriceIn"); // NOI18N

        productDescIn.setText(resourceMap.getString("productDescIn.text")); // NOI18N
        productDescIn.setName("productDescIn"); // NOI18N

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
                            .addComponent(productDescL)
                            .addComponent(productCodeL)
                            .addComponent(productNameL)
                            .addComponent(productPriceL)
                            .addComponent(categoryL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productPriceIn)
                            .addComponent(productNameIn, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(productDescIn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productCodeIn)
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
                    .addComponent(productCodeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productNameL)
                    .addComponent(productNameIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productPriceL)
                    .addComponent(productPriceIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productDescL)
                    .addComponent(productDescIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
       }// </editor-fold>//GEN-END:initComponents

    @Action
    public void saveProduct() {
        Products p = new Products();
        p.setProductCode(productCodeIn.getText());
        p.setProductName(productNameIn.getText());
        p.setProductPrice(Float.parseFloat(productPriceIn.getText()));
        p.setProductDes(productDescIn.getText());
        p.setProductCategoryId((ProductCategory) categoryComboBox.getSelectedItem());
        //overenie vyplnenia
        try {
            ProductOps.addProduct(p);
        } catch (Exception ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryL;
    private javax.swing.JTextField productCodeIn;
    private javax.swing.JLabel productCodeL;
    private javax.swing.JTextField productDescIn;
    private javax.swing.JLabel productDescL;
    private javax.swing.JTextField productNameIn;
    private javax.swing.JLabel productNameL;
    private javax.swing.JTextField productPriceIn;
    private javax.swing.JLabel productPriceL;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private List<ProductCategory> categoryList;
    private BindingGroup bindingGroup;


    private void myInit() {
        bindingGroup = new BindingGroup();
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
