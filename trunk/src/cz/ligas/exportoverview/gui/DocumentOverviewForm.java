/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import org.jdesktop.application.Action;
import java.sql.Date;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author miro
 */
public class DocumentOverviewForm extends javax.swing.JFrame {

    /** Creates new form DocumentOverviewForm */
    public DocumentOverviewForm() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        docsTable = new javax.swing.JTable();
        topLable = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        totalL = new javax.swing.JLabel();
        totalOut = new javax.swing.JLabel();

        jButton1.setName("jButton1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentOverviewForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        docsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        docsTable.setName("docsTable"); // NOI18N
        jScrollPane1.setViewportView(docsTable);

        topLable.setText(resourceMap.getString("topLable.text")); // NOI18N
        topLable.setName("topLable"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(DocumentOverviewForm.class, this);
        refreshButton.setAction(actionMap.get("refreshTable")); // NOI18N
        refreshButton.setText(resourceMap.getString("refreshButton.text")); // NOI18N
        refreshButton.setName("refreshButton"); // NOI18N

        totalL.setText(resourceMap.getString("totalL.text")); // NOI18N
        totalL.setName("totalL"); // NOI18N

        totalOut.setName("totalOut"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(topLable)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(totalL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(totalL)
                    .addComponent(totalOut))
                .addContainerGap())
        );

        topLable.getAccessibleContext().setAccessibleName(resourceMap.getString("topLable.AccessibleContext.accessibleName")); // NOI18N
        refreshButton.getAccessibleContext().setAccessibleName(resourceMap.getString("refreshButton.AccessibleContext.accessibleName")); // NOI18N
        totalL.getAccessibleContext().setAccessibleName(resourceMap.getString("totalL.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void refreshTable() {
        System.err.println("Not overriden");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTable docsTable;
    protected javax.swing.JButton jButton1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JButton refreshButton;
    protected javax.swing.JLabel topLable;
    protected javax.swing.JLabel totalL;
    protected javax.swing.JLabel totalOut;
    // End of variables declaration//GEN-END:variables
    protected java.util.List<cz.ligas.exportoverview.db.Document> docList;
     private org.jdesktop.beansbinding.BindingGroup bindingGroup;

     protected void myInit() {
        System.err.println("Not overriden");
    }

    protected void bindingMethod() {
        bindingGroup = new BindingGroup();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(DocumentOverviewForm.class);
        JTableBinding docsTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, docList, docsTable);
        JTableBinding.ColumnBinding columnBinding;
        columnBinding = docsTableBinding.addColumnBinding(ELProperty.create("${client.company}"));
        columnBinding.setColumnName(resourceMap.getString("docTable.columnModel.clientCompany"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = docsTableBinding.addColumnBinding(ELProperty.create("${docNumber}"));
        columnBinding.setColumnName(resourceMap.getString("docTable.columnModel.docNumber"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = docsTableBinding.addColumnBinding(ELProperty.create("${editDate}"));
        columnBinding.setColumnName(resourceMap.getString("docTable.columnModel.editDate"));
        columnBinding.setColumnClass(Date.class);
        columnBinding.setEditable(false);
        columnBinding = docsTableBinding.addColumnBinding(ELProperty.create("${total}"));
        columnBinding.setColumnName(resourceMap.getString("docTable.columnModel.total"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(docsTableBinding);
        docsTableBinding.bind();
        bindingGroup.bind();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(docsTable.getModel());
        docsTable.setRowSorter(sorter);
    }
}