/*
 * DeliveryInvoiceForm.java
 *
 * Created on 10.10.2009, 11:51:57
 */

package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import org.jdesktop.application.Action;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Document;
import cz.ligas.exportoverview.db.ExportLine;
import java.beans.Beans;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DocumentForm extends javax.swing.JFrame {

    public DocumentForm(String lable) {
        actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(DocumentForm.class, this);
        initComponents();
        myInit();
        dacumentL.setText(lable+":");
        setTitle(lable);

    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        documentTableL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        clientL = new javax.swing.JLabel();
        clientComboBox = new javax.swing.JComboBox();
        dacumentL = new javax.swing.JLabel();
        docComboBox = new javax.swing.JComboBox();
        addLineButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("diform");

        documentTableL.setText("Document:");
        documentTableL.setName("documentTableL"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        documentTable.setName("documentTable"); // NOI18N
        documentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(documentTable);

        clientL.setText("Client:");
        clientL.setName("clientL"); // NOI18N

        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientComboBox.setName("clientComboBox"); // NOI18N

        dacumentL.setText("Document:");
        dacumentL.setName("dacumentL"); // NOI18N

        docComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docComboBox.setName("docComboBox"); // NOI18N

        addLineButton.setAction(actionMap.get("newDocument"));
        addLineButton.setText("Add");
        addLineButton.setName("addLineButton"); // NOI18N

        printButton.setText("Print");
        printButton.setName("printButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(documentTableL)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                        .addComponent(dacumentL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(docComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                        .addComponent(addLineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientL)
                    .addComponent(clientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(docComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dacumentL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentTableL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printButton)
                    .addComponent(addLineButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        documentTableL.getAccessibleContext().setAccessibleName(resourceMap.getString("delInvTableL.AccessibleContext.accessibleName")); // NOI18N
        clientL.getAccessibleContext().setAccessibleName(resourceMap.getString("clientL.AccessibleContext.accessibleName")); // NOI18N
        dacumentL.getAccessibleContext().setAccessibleName(resourceMap.getString("dacumentL.AccessibleContext.accessibleName")); // NOI18N
        addLineButton.getAccessibleContext().setAccessibleName(resourceMap.getString("addLineButton.AccessibleContext.accessibleName")); // NOI18N
        printButton.getAccessibleContext().setAccessibleName(resourceMap.getString("printButton.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void documentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentTableMouseClicked
        System.err.println("Not owerriden");
    }//GEN-LAST:event_documentTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLineButton;
    protected javax.swing.JComboBox clientComboBox;
    private javax.swing.JLabel clientL;
    private javax.swing.JLabel dacumentL;
    protected javax.swing.JComboBox docComboBox;
    protected javax.swing.JTable documentTable;
    private javax.swing.JLabel documentTableL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    private List<Clients> clientsList;
    protected List<Document> docList;
    protected List<Document> documentLinesList;
    javax.swing.ActionMap actionMap;

    private void myInit() {
        
        try {
            clientsList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ClientOps.getClients());
            
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected  void fillTable(){
        bindingGroup = new BindingGroup();

        JComboBoxBinding clientsComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, clientsList, clientComboBox);
        bindingGroup.addBinding(clientsComboBoxBinding);

        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, docList , docComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        org.jdesktop.application.ResourceMap resourceMap1 = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getResourceMap(MainView.class);
        JTableBinding mainTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,documentLinesList , documentTable);
        JTableBinding.ColumnBinding columnBinding;
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productCode}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.productCode"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productName}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.productName"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productPrice}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.productPrice"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${amount}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.amount"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${price}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.priceS"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${total}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.total"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(mainTableBinding);
        mainTableBinding.bind();
        bindingGroup.bind();
    }

    @Action
    public void newDocument() {
        System.err.println("Not Overriden");
    }
}
