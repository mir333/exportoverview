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

    public DocumentForm(String l, String title) {
        actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap(DocumentForm.class, this);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        this.lable = l;
        initComponents();
        myInit();
        dacumentL.setText(resourceMap.getString(title) + ":");
        setTitle(resourceMap.getString(title));

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
        mTotalOut = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N

        documentTableL.setText(resourceMap.getString("documentTableL.text")); // NOI18N
        documentTableL.setName("documentTableL"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        documentTable.setAutoCreateRowSorter(true);
        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        documentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        documentTable.setName("documentTable"); // NOI18N
        documentTable.getTableHeader().setReorderingAllowed(false);
        documentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(documentTable);

        clientL.setText(resourceMap.getString("clientL.text")); // NOI18N
        clientL.setName("clientL"); // NOI18N

        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientComboBox.setAction(actionMap.get("fillDocComboBox"));
        clientComboBox.setName("clientComboBox"); // NOI18N

        dacumentL.setText(resourceMap.getString("dacumentL.text")); // NOI18N
        dacumentL.setName("dacumentL"); // NOI18N

        docComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docComboBox.setAction(actionMap.get("dcoSelected"));
        docComboBox.setName("docComboBox"); // NOI18N

        addLineButton.setAction(actionMap.get("newDocument"));
        addLineButton.setText(resourceMap.getString("addLineButton.text")); // NOI18N
        addLineButton.setName("addLineButton"); // NOI18N

        printButton.setAction(actionMap.get("printDoc"));
        printButton.setText(resourceMap.getString("printButton.text")); // NOI18N
        printButton.setName("printButton"); // NOI18N

        deleteButton.setAction(actionMap.get("deleteSelected"));
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        tatalL.setText(resourceMap.getString("tatalL.text")); // NOI18N
        tatalL.setName("tatalL"); // NOI18N

        mTotalOut.setEditable(false);
        mTotalOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        mTotalOut.setText(resourceMap.getString("mTotalOut.text")); // NOI18N
        mTotalOut.setName("mTotalOut"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, docComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.total}"), mTotalOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
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
                        .addComponent(mTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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
                        .addComponent(mTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addLineButton))
                .addContainerGap())
        );

        documentTableL.getAccessibleContext().setAccessibleName(resourceMap.getString("delInvTableL.AccessibleContext.accessibleName")); // NOI18N
        clientL.getAccessibleContext().setAccessibleName(resourceMap.getString("clientL.AccessibleContext.accessibleName")); // NOI18N
        dacumentL.getAccessibleContext().setAccessibleName(resourceMap.getString("dacumentL.AccessibleContext.accessibleName")); // NOI18N
        addLineButton.getAccessibleContext().setAccessibleName(resourceMap.getString("addLineButton.text")); // NOI18N
        addLineButton.getAccessibleContext().setAccessibleDescription(resourceMap.getString("addLineButton.AccessibleContext.accessibleDescription")); // NOI18N
        printButton.getAccessibleContext().setAccessibleName(resourceMap.getString("printButton.text")); // NOI18N
        printButton.getAccessibleContext().setAccessibleDescription(resourceMap.getString("printButton.AccessibleContext.accessibleDescription")); // NOI18N

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

	protected void documentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentTableMouseClicked
            System.err.println("Not owerriden");
    }//GEN-LAST:event_documentTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addLineButton;
    protected javax.swing.JComboBox clientComboBox;
    protected javax.swing.JLabel clientL;
    protected javax.swing.JLabel dacumentL;
    protected javax.swing.JButton deleteButton;
    protected javax.swing.JComboBox docComboBox;
    protected javax.swing.JTable documentTable;
    protected javax.swing.JLabel documentTableL;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JFormattedTextField mTotalOut;
    protected javax.swing.JButton printButton;
    protected javax.swing.JLabel tatalL;
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

        org.jdesktop.application.ResourceMap resourceMap1 = org.jdesktop.application.Application.getInstance(GuiMain.class).getContext().getResourceMap(MainView.class);
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

            String path = saveFile("html.htm");
            if (path == null) {
                return;
            }
            Clients c = (Clients) clientComboBox.getSelectedItem();
            Document d = (Document) docComboBox.getSelectedItem();
            Source src = GenerateXml.generateDocXml(lable, d, c, documentLinesList, optionDialog());
            org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(GuiMain.class).getContext().getResourceMap(GuiMain.class);
            GenerateXml.generateHtml(path, src, resourceMap.getString("files.xslt"));
        } catch (Exception e) {
            Logger.getLogger(EditExportLineForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String saveFile(String fileType) {
        FileDialog fd = new FileDialog(this, "Save as:", FileDialog.SAVE);
        fd.setFile(fileType);
        fd.setLocationRelativeTo(documentTable);
        fd.setVisible(true);
        if (fd.getDirectory() == null) {
            return null;
        }
        if (fd.getFile() == null) {
            return null;
        }
        return fd.getDirectory() + fd.getFile();
    }

    protected static void errorDialog(String mes) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        JOptionPane.showMessageDialog(null, resourceMap.getString(mes), resourceMap.getString("error.title"), JOptionPane.ERROR_MESSAGE);
    }

    protected static int showDialog(String mes) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        return JOptionPane.showConfirmDialog(null, resourceMap.getString(mes), resourceMap.getString("delete.title"), JOptionPane.YES_NO_OPTION);
    }

    protected String optionDialog() {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentForm.class);
        String[] option = {
            resourceMap.getString("paymentType.one"),
            resourceMap.getString("paymentType.two"),
            resourceMap.getString("paymentType.three")};
        int result = JOptionPane.showOptionDialog(
                null,
                resourceMap.getString("paymentType.msg"),
                resourceMap.getString("paymentType.lable"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                option,
                option[0]);

        return option[result];
    }
}
