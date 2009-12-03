/*
 * DeliveryInvoiceForm.java
 *
 * Created on 10.10.2009, 11:51:57
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.appli.GenerateXml;
import org.jdesktop.application.Action;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.Document;
import cz.ligas.exportoverview.db.DocumentLine;
import java.awt.FileDialog;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;




import javax.xml.transform.*;

/**
 *
 * @author xligas
 */
public class DocumentForm extends javax.swing.JFrame {

    public DocumentForm(String l) {
        actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(DocumentForm.class, this);
        this.lable=l;
        initComponents();
        myInit();
        dacumentL.setText(l + ":");
        setTitle(l);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        documentTableL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        clientL = new javax.swing.JLabel();
        clientComboBox = new javax.swing.JComboBox();
        dacumentL = new javax.swing.JLabel();
        docComboBox = new javax.swing.JComboBox();
        addLineButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        tatalL = new javax.swing.JLabel();
        totalOut = new javax.swing.JLabel();

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
        documentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
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
        clientComboBox.setAction(actionMap.get("fillDocComboBox"));
        clientComboBox.setName("clientComboBox"); // NOI18N

        dacumentL.setText("Document:");
        dacumentL.setName("dacumentL"); // NOI18N

        docComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docComboBox.setAction(actionMap.get("dcoSelected"));
        docComboBox.setName("docComboBox"); // NOI18N

        addLineButton.setAction(actionMap.get("newDocument"));
        addLineButton.setText("Add");
        addLineButton.setName("addLineButton"); // NOI18N

        printButton.setAction(actionMap.get("printDoc"));
        printButton.setText("Print");
        printButton.setName("printButton"); // NOI18N

        deleteButton.setAction(actionMap.get("deleteSelected"));
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        tatalL.setText("Total:");
        tatalL.setName("tatalL"); // NOI18N

        totalOut.setName("totalOut"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, docComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.total}"), totalOut, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(53, 53, 53)
                        .addComponent(tatalL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(printButton)
                        .addComponent(deleteButton)
                        .addComponent(tatalL)
                        .addComponent(totalOut))
                    .addComponent(addLineButton))
                .addContainerGap())
        );

        documentTableL.getAccessibleContext().setAccessibleName(resourceMap.getString("delInvTableL.AccessibleContext.accessibleName")); // NOI18N
        clientL.getAccessibleContext().setAccessibleName(resourceMap.getString("clientL.AccessibleContext.accessibleName")); // NOI18N
        dacumentL.getAccessibleContext().setAccessibleName(resourceMap.getString("dacumentL.AccessibleContext.accessibleName")); // NOI18N
        addLineButton.getAccessibleContext().setAccessibleName(resourceMap.getString("addLineButton.AccessibleContext.accessibleName")); // NOI18N
        printButton.getAccessibleContext().setAccessibleName(resourceMap.getString("printButton.AccessibleContext.accessibleName")); // NOI18N

        bindingGroup.bind();

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
    private javax.swing.JButton deleteButton;
    protected javax.swing.JComboBox docComboBox;
    protected javax.swing.JTable documentTable;
    private javax.swing.JLabel documentTableL;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel tatalL;
    protected javax.swing.JLabel totalOut;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    protected List<Clients> clientsList;
    protected List<Document> docList;
    protected List<DocumentLine> documentLinesList;
    javax.swing.ActionMap actionMap;
    private String lable;

    private void myInit() {

        try {
            clientsList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ClientOps.getClients());
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void bindingMethod() {
        bindingGroup = new BindingGroup();
        JComboBoxBinding clientsComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, clientsList, clientComboBox);
        bindingGroup.addBinding(clientsComboBoxBinding);

        JComboBoxBinding jComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, docList, docComboBox);
        bindingGroup.addBinding(jComboBoxBinding);

        org.jdesktop.application.ResourceMap resourceMap1 = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getResourceMap(MainView.class);
        JTableBinding mainTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, documentLinesList, documentTable);
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
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${amount}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.amount"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${price}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.priceS"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${total}"));
        columnBinding.setColumnName(resourceMap1.getString("mainTable.columnModel.total"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(mainTableBinding);
        mainTableBinding.bind();
        bindingGroup.bind();
    }

    protected List<Integer> getSeletedDocs() {
        List<Integer> list = new ArrayList<Integer>();
        for (int seletedItem : documentTable.getSelectedRows()) {
            int index = documentTable.convertRowIndexToModel(seletedItem);
            list.add(documentLinesList.get(index).getId());
        }
        return list;
    }

    protected int showDialog(String mes) {
        return JOptionPane.showConfirmDialog(this, mes, "Delete", JOptionPane.YES_NO_OPTION);
    }

    @Action
    public void newDocument() {
        System.err.println("Not Overriden");
    }

    @Action
    public void fillDocComboBox() {
        System.err.println("Not Overriden");
    }

    @Action
    public void dcoSelected() {
        System.err.println("Not Overriden");
    }

    @Action
    public void deleteSelected() {
        System.err.println("Not Overriden");
    }

    @Action
    public void printDoc() {
        try {
            Clients c = (Clients) clientComboBox.getSelectedItem();
            Document d = (Document) docComboBox.getSelectedItem();
            String path = saveFile("html.htm");
            if(path==null)return;
            Source src = GenerateXml.generateDocXml(lable,d, c,documentLinesList);
            GenerateXml.generateHtml(path, src);
        } catch (Exception e) {
           Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String saveFile(String fileType) {
        FileDialog fd = new FileDialog(this, "Save as:", FileDialog.SAVE);
        fd.setFile(fileType);
        fd.setLocationRelativeTo(documentTable);
        fd.setVisible(true);
        if(fd.getDirectory() == null)return null;
        if(fd.getFile() == null)return null;
        return fd.getDirectory() + fd.getFile();
}
}
