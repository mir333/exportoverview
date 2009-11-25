/*
 * MainView.java
 */
package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.beans.Beans;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 * The application's main frame.
 */
public class MainView extends FrameView {

    public MainView(SingleFrameApplication app) {
        super(app);
        actionMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getActionMap	(MainView.class, this);
        initComponents();
        myInit();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
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

        mainPanel = new javax.swing.JPanel();
        clientsComboBox = new javax.swing.JComboBox();
        newClientButton = new javax.swing.JButton();
        clientsL = new javax.swing.JLabel();
        newProductButton = new javax.swing.JButton();
        newCategoryButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        totalLableOut = new javax.swing.JLabel();
        totalLable = new javax.swing.JLabel();
        sentPriceOut = new javax.swing.JLabel();
        sentPriceLable = new javax.swing.JLabel();
        soldTotalLableOut = new javax.swing.JLabel();
        soldTotalLable = new javax.swing.JLabel();
        sentTotalLableOut = new javax.swing.JLabel();
        sentTotalLable = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        printMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        openDeliveryManuItem = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        oepnInvoiceMenuItem = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        warehouseMenu = new javax.swing.JMenu();
        openWarehouseMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        clientsComboBox.setName("clientsComboBox"); // NOI18N
        clientsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsComboBoxActionPerformed(evt);
            }
        });

        newClientButton.setAction(actionMap.get("newClient"));
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(MainView.class);
        newClientButton.setText(resourceMap.getString("newClientButton.text")); // NOI18N
        newClientButton.setName("newClientButton"); // NOI18N

        clientsL.setText(resourceMap.getString("clientsL.text")); // NOI18N
        clientsL.setName("clientsL"); // NOI18N

        newProductButton.setAction(actionMap.get("newProduct"));
        newProductButton.setText(resourceMap.getString("newProductButton.text")); // NOI18N
        newProductButton.setName("newProductButton"); // NOI18N

        newCategoryButton.setAction(actionMap.get("newCategory"));
        newCategoryButton.setText(resourceMap.getString("newCategoryButton.text")); // NOI18N
        newCategoryButton.setName("newCategoryButton"); // NOI18N

        addProductButton.setAction(actionMap.get("addProduct"));
        addProductButton.setText(resourceMap.getString("addProductButton.text")); // NOI18N
        addProductButton.setName("addProductButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        mainTable.setName("mainTable"); // NOI18N
        mainTable.getTableHeader().setReorderingAllowed(false);
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainTable);

        totalLableOut.setName("totalLableOut"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.total}"), totalLableOut, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        totalLable.setText(resourceMap.getString("totalLable.text")); // NOI18N
        totalLable.setName("totalLable"); // NOI18N

        sentPriceOut.setName("sentPriceOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSendValue}"), sentPriceOut, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sentPriceLable.setText(resourceMap.getString("sentPriceLable.text")); // NOI18N
        sentPriceLable.setName("sentPriceLable"); // NOI18N

        soldTotalLableOut.setName("soldTotalLableOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSold}"), soldTotalLableOut, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        soldTotalLable.setText(resourceMap.getString("soldTotalLable.text")); // NOI18N
        soldTotalLable.setName("soldTotalLable"); // NOI18N

        sentTotalLableOut.setName("sentTotalLableOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSent}"), sentTotalLableOut, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        sentTotalLable.setText(resourceMap.getString("sentTotalLable.text")); // NOI18N
        sentTotalLable.setName("sentTotalLable"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(sentTotalLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sentTotalLableOut, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(soldTotalLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soldTotalLableOut, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(sentPriceLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sentPriceOut, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLableOut, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(addProductButton)))
                        .addContainerGap())
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(newClientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCategoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newProductButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(clientsL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newClientButton)
                    .addComponent(newCategoryButton)
                    .addComponent(newProductButton)
                    .addComponent(clientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientsL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProductButton)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalLableOut)
                        .addComponent(totalLable)
                        .addComponent(sentPriceOut)
                        .addComponent(sentPriceLable)
                        .addComponent(sentTotalLable)
                        .addComponent(sentTotalLableOut)
                        .addComponent(soldTotalLable)
                        .addComponent(soldTotalLableOut)))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        printMenuItem.setAction(actionMap.get("print"));
        printMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        printMenuItem.setText(resourceMap.getString("printMenuItem.text")); // NOI18N
        printMenuItem.setName("printMenuItem"); // NOI18N
        fileMenu.add(printMenuItem);
        printMenuItem.getAccessibleContext().setAccessibleName(resourceMap.getString("printMenuItem.AccessibleContext.accessibleName")); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit"));
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        openDeliveryManuItem.setText(resourceMap.getString("openDeliveryManuItem.text")); // NOI18N
        openDeliveryManuItem.setName("openDeliveryManuItem"); // NOI18N

        jMenuItem3.setAction(actionMap.get("newDelivery"));
        jMenuItem3.setText(resourceMap.getString("deliveryMenuItem.text")); // NOI18N
        jMenuItem3.setName("deliveryMenuItem"); // NOI18N
        openDeliveryManuItem.add(jMenuItem3);
        jMenuItem3.getAccessibleContext().setAccessibleName(resourceMap.getString("jMenuItem3.AccessibleContext.accessibleName")); // NOI18N

        jMenuItem1.setAction(actionMap.get("showDelivery"));
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        openDeliveryManuItem.add(jMenuItem1);

        menuBar.add(openDeliveryManuItem);

        oepnInvoiceMenuItem.setText(resourceMap.getString("oepnInvoiceMenuItem.text")); // NOI18N
        oepnInvoiceMenuItem.setName("oepnInvoiceMenuItem"); // NOI18N

        jMenuItem4.setAction(actionMap.get("newInvoice"));
        jMenuItem4.setText(resourceMap.getString("invoiceMenuItem.text")); // NOI18N
        jMenuItem4.setName("invoiceMenuItem"); // NOI18N
        oepnInvoiceMenuItem.add(jMenuItem4);
        jMenuItem4.getAccessibleContext().setAccessibleName(resourceMap.getString("invoiceMenuItem.AccessibleContext.accessibleName")); // NOI18N

        jMenuItem2.setAction(actionMap.get("showInvoice"));
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        oepnInvoiceMenuItem.add(jMenuItem2);

        menuBar.add(oepnInvoiceMenuItem);

        warehouseMenu.setAction(actionMap.get("openWarehouse"));
        warehouseMenu.setText(resourceMap.getString("warehouseMenu.text")); // NOI18N
        warehouseMenu.setName("warehouseMenu"); // NOI18N

        openWarehouseMenuItem.setAction(actionMap.get("openWarehouse"));
        openWarehouseMenuItem.setText(resourceMap.getString("openWarehouseMenuItem.text")); // NOI18N
        openWarehouseMenuItem.setName("openWarehouseMenuItem"); // NOI18N
        warehouseMenu.add(openWarehouseMenuItem);
        openWarehouseMenuItem.getAccessibleContext().setAccessibleDescription(resourceMap.getString("openWarehouseMenuItem.AccessibleContext.accessibleDescription")); // NOI18N

        menuBar.add(warehouseMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox"));
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 622, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        if (evt.getClickCount() > 1) {
            final int index = mainTable.convertRowIndexToModel(mainTable.getSelectedRow());
            Clients clients = (Clients) clientsComboBox.getSelectedItem();
            EditExportLineForm eel = new EditExportLineForm(clients,exportLinesList.get(index));
            eel.setLocationRelativeTo(mainTable);
            eel.addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    try {
                        ExportLine exp = exportLinesList.get(index);
                        exp = ExportLineOps.getExportLineById(exp.getId());
                        exportLinesList.set(index, exp);
                        refreshTotal();
                        mainTable.updateUI();
                    } catch (Exception ex) {
                        Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            eel.setVisible(true);
        }
    }//GEN-LAST:event_mainTableMouseClicked

    private void clientsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsComboBoxActionPerformed
               Clients c = (Clients) clientsComboBox.getSelectedItem();
        if (c != null) {
            exportLinesList.clear();
            try {
                exportLinesList.addAll(ExportLineOps.getExportLinesByClient(c));

            } catch (Exception ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainTable.updateUI();
        }

    }//GEN-LAST:event_clientsComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JComboBox clientsComboBox;
    private javax.swing.JLabel clientsL;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable mainTable;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newCategoryButton;
    private javax.swing.JButton newClientButton;
    private javax.swing.JButton newProductButton;
    private javax.swing.JMenu oepnInvoiceMenuItem;
    private javax.swing.JMenu openDeliveryManuItem;
    private javax.swing.JMenuItem openWarehouseMenuItem;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel sentPriceLable;
    private javax.swing.JLabel sentPriceOut;
    private javax.swing.JLabel sentTotalLable;
    private javax.swing.JLabel sentTotalLableOut;
    private javax.swing.JLabel soldTotalLable;
    private javax.swing.JLabel soldTotalLableOut;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel totalLable;
    private javax.swing.JLabel totalLableOut;
    private javax.swing.JMenu warehouseMenu;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //private BindingGroup bindingGroup;
    private List<Clients> clientsList;
    private List<ExportLine> exportLinesList;
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private javax.swing.ActionMap actionMap;

    private void myInit() {
        bindingGroup = new BindingGroup();
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cz.ligas.exportoverview.gui.GuiMain.class).getContext().getResourceMap(MainView.class);
        try {
            exportLinesList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ExportLineOps.getExportLine());
            clientsList = Beans.isDesignTime() ? (ObservableList) Collections.emptyList() : ObservableCollections.observableList(ClientOps.getClients());
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }

        JComboBoxBinding clientsComboBoxBinding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ_WRITE, clientsList, clientsComboBox);
        bindingGroup.addBinding(clientsComboBoxBinding);

        JTableBinding mainTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, exportLinesList, mainTable);
        JTableBinding.ColumnBinding columnBinding;
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productCode}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.productCode"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productName}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.productName"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${prod.productPrice}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.productPrice"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${price}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.priceS"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sent}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.send"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sentPrice}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.sendPrice"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sold}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.sold"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${total}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.total"));
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(mainTableBinding);
        mainTableBinding.bind();
        bindingGroup.bind();
    }

    public void refreshTotal() {
        Clients e = (Clients)clientsComboBox.getSelectedItem();
        int i = clientsComboBox.getSelectedIndex();
        clientsComboBox.setSelectedIndex(-1);
        clientsComboBox.setSelectedIndex(i);
    }

    @Action
    public void showAboutBox() {
        JDialog aboutBox = new AboutBox();
        aboutBox.setLocationRelativeTo(mainTable);
        aboutBox.setVisible(true);
    }

    @Action
    public void showInvoice() {
        InvoiceForm invForm = new InvoiceForm();
        invForm.setLocationRelativeTo(mainTable);
        invForm.setVisible(true);
    }

    @Action
    public void newInvoice() {
        NewInvioceForm invForm = new NewInvioceForm();
        invForm.setLocationRelativeTo(mainTable);
        invForm.setVisible(true);
    }

    @Action
    public void showDelivery() {
        DeliveryForm delivForm = new DeliveryForm();
        delivForm.setLocationRelativeTo(mainTable);
        delivForm.setVisible(true);
    }

    @Action
    public void newDelivery() {
        NewDeliveryForm delivForm = new NewDeliveryForm();
        delivForm.setLocationRelativeTo(mainTable);
        delivForm.setVisible(true);
    }

    @Action
    public void newClient() {
        ClientForm cf = new ClientForm();
        cf.setLocationRelativeTo(mainTable);
        cf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent e) {
                clientsList.clear();
                try {
                    clientsList.addAll(ClientOps.getClients());
                    clientsComboBox.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        cf.setVisible(true);
    }

    @Action
    public void newCategory() {
        CategoryForm cf = new CategoryForm();
        cf.setLocationRelativeTo(mainTable);
        cf.setVisible(true);
    }

    @Action
    public void openWarehouse() {
        System.err.println("looool");
        WarehouseForm whf = new WarehouseForm();
        whf.setLocationRelativeTo(mainTable);
        whf.setVisible(true);
    }

    @Action
    public void newProduct() {
        ProductForm pf = new ProductForm();
        pf.setLocationRelativeTo(mainTable);
        pf.setVisible(true);
    }

    @Action
    public void newExport() {
        NewDocumentForm ef = new NewDocumentForm();
        ef.setLocationRelativeTo(mainTable);
        ef.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent e) {
                clientsList.clear();
                try {
                    clientsList.addAll(ClientOps.getClients());
                    clientsComboBox.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ef.setVisible(true);
    }

    @Action
    public void addProduct() {
        final Clients c = (Clients) clientsComboBox.getSelectedItem();
        AddExportLine ael = new AddExportLine(c);
        ael.setLocationRelativeTo(mainTable);
        ael.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent evt) {
                exportLinesList.clear();
                try {
                    exportLinesList.addAll(ExportLineOps.getExportLinesByClient(c));
                    refreshTotal();
                    mainTable.updateUI();
                } catch (Exception ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ael.setVisible(true);
    }

    @Action
    public void print() {
        /* Fetch printing properties from the GUI components */
        Clients client = (Clients) clientsComboBox.getSelectedItem();
        MessageFormat header = new MessageFormat(clientsComboBox.getSelectedItem().toString() + ", Changed: " + client.getEditDate());
        String s = "Send total: " + client.getTotalSent() + ", Sent value: " + client.getTotalSendValue() + ", Sold total: " + client.getTotalSold() + ", Total: " + client.getTotal();
        MessageFormat footer = new MessageFormat(s);
        boolean showPrintDialog = true;
        boolean interactive = true;
        /* determine the print mode */
        JTable.PrintMode mode = JTable.PrintMode.FIT_WIDTH;
        try {
            /* print the table */
            boolean complete = mainTable.print(mode, header, footer,
                    showPrintDialog, null,
                    interactive, null);
            /* if printing completes */
            if (complete) {
                /* show a success message */
                JOptionPane.showMessageDialog(null,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* show a message indicating that printing was cancelled */
                JOptionPane.showMessageDialog(null,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException pe) {
            /* Printing failed, report to the user */
            JOptionPane.showMessageDialog(null,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
// TODO: Dorobit potvrdenie na enter
// TODO: Upravit DB aby potporovala uniqu itemy
// TODO: include inheritance in entity classes
