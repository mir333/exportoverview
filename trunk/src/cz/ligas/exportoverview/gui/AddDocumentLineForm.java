package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.CategoryOps;
import cz.ligas.exportoverview.db.ProductCategory;
import java.beans.Beans;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author miro
 */
public class AddDocumentLineForm extends javax.swing.JDialog {

    /** Creates new form AddDocumentLine */
    public AddDocumentLineForm(java.awt.Frame parent) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        addProductButton = new javax.swing.JButton();
        productCategoryComboBox = new javax.swing.JComboBox();
        productComboBox = new javax.swing.JComboBox();
        nAmountIn = new javax.swing.JTextField();
        productCategoryL = new javax.swing.JLabel();
        productL = new javax.swing.JLabel();
        amountL = new javax.swing.JLabel();
        priceL = new javax.swing.JLabel();
        addDocumentLable = new javax.swing.JLabel();
        mPriceIn = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(AddDocumentLineForm.class);
        setTitle(resourceMap.getString("title")); // NOI18N
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(AddDocumentLineForm.class, this);
        addProductButton.setAction(actionMap.get("addDocumentLine")); // NOI18N
        addProductButton.setText(resourceMap.getString("addProductButton.text")); // NOI18N
        addProductButton.setName("addProductButton"); // NOI18N

        productCategoryComboBox.setName("productCategoryComboBox"); // NOI18N

        productComboBox.setName("productComboBOx"); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedItem.products}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productCategoryComboBox, eLProperty, productComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        nAmountIn.setName("nAmountIn"); // NOI18N

        productCategoryL.setText(resourceMap.getString("productCategoryL.text")); // NOI18N
        productCategoryL.setName("productCategoryL"); // NOI18N

        productL.setText(resourceMap.getString("productL.text")); // NOI18N
        productL.setName("productL"); // NOI18N

        amountL.setText(resourceMap.getString("amountL.text")); // NOI18N
        amountL.setName("amountL"); // NOI18N

        priceL.setText(resourceMap.getString("priceL.text")); // NOI18N
        priceL.setName("priceL"); // NOI18N

        addDocumentLable.setText("Add produt to list:");
        addDocumentLable.setName("addDocumentLable"); // NOI18N

        mPriceIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        mPriceIn.setName("mPriceIn"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, productComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.productPrice}"), mPriceIn, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productCategoryL)
                            .addComponent(productL)
                            .addComponent(amountL)
                            .addComponent(priceL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productComboBox, 0, 171, Short.MAX_VALUE)
                            .addComponent(nAmountIn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(productCategoryComboBox, 0, 171, Short.MAX_VALUE)
                            .addComponent(mPriceIn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                    .addComponent(addDocumentLable)
                    .addComponent(addProductButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDocumentLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productCategoryL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nAmountIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceL)
                    .addComponent(mPriceIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addProductButton)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel addDocumentLable;
    protected javax.swing.JButton addProductButton;
    protected javax.swing.JLabel amountL;
    protected javax.swing.JFormattedTextField mPriceIn;
    protected javax.swing.JTextField nAmountIn;
    protected javax.swing.JLabel priceL;
    protected javax.swing.JComboBox productCategoryComboBox;
    protected javax.swing.JLabel productCategoryL;
    protected javax.swing.JComboBox productComboBox;
    protected javax.swing.JLabel productL;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private List<ProductCategory> categoryList = null;
    private MyInputVerifier verifier = new MyInputVerifier();

    private void myInit() {
        bindingGroup = new BindingGroup();
        nAmountIn.setInputVerifier(verifier);
        nAmountIn.addActionListener(verifier);
        amountL.setLabelFor(nAmountIn);
        mPriceIn.setInputVerifier(verifier);
        mPriceIn.addActionListener(verifier);
        priceL.setLabelFor(mPriceIn);
        fill();
        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, categoryList, productCategoryComboBox);
        bindingGroup.addBinding(jComboBoxBinding);
        bindingGroup.bind();
    }

    @Action
    public void addDocumentLine() {
        System.err.println("Not Overriden");
    }

    protected void fill() {
        nAmountIn.setText("");
        mPriceIn.setText("");
        try {
            if(categoryList == null)
                categoryList =  Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(CategoryOps.getCategories());
            else{
                categoryList.clear();
                categoryList.addAll(CategoryOps.getCategories());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
