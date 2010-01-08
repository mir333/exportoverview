package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.CategoryOps;
import cz.ligas.exportoverview.appli.WarehouseItemOps;
import cz.ligas.exportoverview.db.ProductCategory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Beans;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.application.Action;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author xligas
 */
public class WarehouseForm extends javax.swing.JFrame {

    private JDialog editWhItem;
    private JDialog editProduct;

    /** Creates new form WarehouseForm */
    public WarehouseForm() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        warehouseTable = new javax.swing.JTable();
        warehouseTableL = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox();
        categoryL = new javax.swing.JLabel();
        showAllWhitemsButton = new javax.swing.JButton();
        editProductbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(WarehouseForm.class);
        setTitle(resourceMap.getString("title")); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        warehouseTable.setAutoCreateRowSorter(true);
        warehouseTable.setName("warehouseTable"); // NOI18N
        warehouseTable.getTableHeader().setReorderingAllowed(false);
        warehouseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warehouseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(warehouseTable);

        warehouseTableL.setText(resourceMap.getString("warehouseTableL.text")); // NOI18N
        warehouseTableL.setName("warehouseTableL"); // NOI18N

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryComboBox.setName("categoryComboBox"); // NOI18N
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        categoryL.setText(resourceMap.getString("categoryL.text")); // NOI18N
        categoryL.setName("categoryL"); // NOI18N

        showAllWhitemsButton.setText(resourceMap.getString("showAllWhitemsButton.text")); // NOI18N
        showAllWhitemsButton.setName("showAllWhitemsButton"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(WarehouseForm.class, this);
        editProductbutton.setAction(actionMap.get("editProdut")); // NOI18N
        editProductbutton.setName("editProductbutton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(warehouseTableL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(categoryL, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editProductbutton)
                        .addGap(551, 551, 551)
                        .addComponent(showAllWhitemsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warehouseTableL)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllWhitemsButton)
                    .addComponent(editProductbutton))
                .addGap(12, 12, 12))
        );

        warehouseTableL.getAccessibleContext().setAccessibleName(resourceMap.getString("warehouseTableL.AccessibleContext.accessibleName")); // NOI18N
        categoryL.getAccessibleContext().setAccessibleName(resourceMap.getString("categoryL.AccessibleContext.accessibleName")); // NOI18N
        showAllWhitemsButton.getAccessibleContext().setAccessibleName(resourceMap.getString("showAllWhitemsButton.AccessibleContext.accessibleName")); // NOI18N
        showAllWhitemsButton.getAccessibleContext().setAccessibleDescription(resourceMap.getString("showAllWhitemsButton.AccessibleContext.accessibleDescription")); // NOI18N
        editProductbutton.getAccessibleContext().setAccessibleName(resourceMap.getString("editProductbutton.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void warehouseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warehouseTableMouseClicked
        if (evt.getClickCount() > 1) {
            int index = warehouseTable.convertRowIndexToModel(warehouseTable.getSelectedRow());
            if (editWhItem == null) {
                JFrame mainFrame = GuiMain.getApplication().getMainFrame();
                editWhItem = new EditWarehouseItemForm(warehouseItemList.get(index), mainFrame);
                editWhItem.setLocationRelativeTo(mainFrame);
                editWhItem.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowDeactivated(WindowEvent evt) {
                        try {
                            refresh();
                        } catch (Exception ex) {
                            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
            GuiMain.getApplication().show(editWhItem);
        }
    }//GEN-LAST:event_warehouseTableMouseClicked

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        ProductCategory prodCat = (ProductCategory) categoryComboBox.getSelectedItem();
        if (prodCat != null) {
            try {
                warehouseItemList.clear();
                warehouseItemList.addAll(WarehouseItemOps.getWarhouseItemByCategoryId(prodCat.getId()));
            } catch (Exception ex) {
                Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_categoryComboBoxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JLabel categoryL;
    private javax.swing.JButton editProductbutton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showAllWhitemsButton;
    private javax.swing.JTable warehouseTable;
    private javax.swing.JLabel warehouseTableL;
    // End of variables declaration//GEN-END:variables
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private java.util.List<cz.ligas.exportoverview.db.ProductCategory> categoryList;
    private java.util.List<cz.ligas.exportoverview.db.WarehouseItem> warehouseItemList;

    private void myInit() {
        bindingGroup = new BindingGroup();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getResourceMap(WarehouseForm.class);
        try {
            warehouseItemList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(WarehouseItemOps.getWarehouseItems());
            categoryList = CategoryOps.getCategories();
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, categoryList, categoryComboBox);
        bindingGroup.addBinding(jComboBoxBinding);
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(WarehouseForm.class, this);
        showAllWhitemsButton.setAction(actionMap.get("showAll")); // NOI18N
        JTableBinding warehouseTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, warehouseItemList, warehouseTable);
        JTableBinding.ColumnBinding columnBinding;
        columnBinding = warehouseTableBinding.addColumnBinding(ELProperty.create("${productItem.productCode}"));
        columnBinding.setColumnName(resourceMap.getString("warehouseTable.columnModel.productCode"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = warehouseTableBinding.addColumnBinding(ELProperty.create("${productItem.productName}"));
        columnBinding.setColumnName(resourceMap.getString("warehouseTable.columnModel.productName"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = warehouseTableBinding.addColumnBinding(ELProperty.create("${productItem.productPrice}"));
        columnBinding.setColumnName(resourceMap.getString("warehouseTable.columnModel.productPrice"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = warehouseTableBinding.addColumnBinding(ELProperty.create("${productCount}"));
        columnBinding.setColumnName(resourceMap.getString("warehouseTable.columnModel.productCount"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(warehouseTableBinding);
        warehouseTableBinding.bind();
        bindingGroup.bind();
    }

    @Action
    public void showAll() {
        try {
            warehouseItemList.clear();
            warehouseItemList.addAll(WarehouseItemOps.getWarehouseItems());
        } catch (Exception ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        warehouseTable.updateUI();
    }

    public void refresh() {
        try {
            int index = categoryComboBox.getSelectedIndex();
            categoryList.clear();
            categoryList.addAll(CategoryOps.getCategories());
            categoryComboBox.setSelectedIndex(index);
        } catch (Exception ex) {
            Logger.getLogger(WarehouseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Action
    public void editProdut() {
        int index = warehouseTable.convertRowIndexToModel(warehouseTable.getSelectedRow());
        if (editProduct == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            editProduct = new EditProductForm(warehouseItemList.get(index).getProductItem().getId(), mainFrame);
            editProduct.setLocationRelativeTo(mainFrame);
            editProduct.addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    try {
                        refresh();
                    } catch (Exception ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        GuiMain.getApplication().show(editProduct);
    }
}