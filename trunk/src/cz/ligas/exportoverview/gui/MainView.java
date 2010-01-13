package cz.ligas.exportoverview.gui;

import cz.ligas.exportoverview.appli.ClientOps;
import cz.ligas.exportoverview.appli.ExportLineOps;
import cz.ligas.exportoverview.db.Clients;
import cz.ligas.exportoverview.db.ExportLine;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.beans.Beans;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public final class MainView extends FrameView {

    private static MainView instance = null;

    public static MainView getInstance(SingleFrameApplication app) {
        if (instance == null) {
            instance = new MainView(app);
        }
        return instance;
    }

    public static MainView getInstance() {
        return instance;
    }

    private MainView(SingleFrameApplication app) {
        super(app);
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

        mainPanel = new javax.swing.JPanel();
        clientsComboBox = new javax.swing.JComboBox();
        newClientButton = new javax.swing.JButton();
        clientsL = new javax.swing.JLabel();
        newProductButton = new javax.swing.JButton();
        newCategoryButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        totalLable = new javax.swing.JLabel();
        sentPriceLable = new javax.swing.JLabel();
        soldTotalLable = new javax.swing.JLabel();
        sentTotalLable = new javax.swing.JLabel();
        editClient = new javax.swing.JButton();
        soldPriceLable = new javax.swing.JLabel();
        mSentPriceOut = new javax.swing.JFormattedTextField();
        nSentTotalOut = new javax.swing.JFormattedTextField();
        nSoldTotalOut = new javax.swing.JFormattedTextField();
        mSoldPriceOut = new javax.swing.JFormattedTextField();
        nTotalOut = new javax.swing.JFormattedTextField();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        printMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        openDeliveryManuItem = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        deliveryOverviewMenuitem = new javax.swing.JMenuItem();
        oepnInvoiceMenuItem = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        invoiceOverviewMenuItem = new javax.swing.JMenuItem();
        warehouseMenu = new javax.swing.JMenu();
        openWarehouseMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        userInfoMenuitem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(MainView.class);
        mainPanel.setFont(resourceMap.getFont("mainPanel.font")); // NOI18N
        mainPanel.setName("mainPanel"); // NOI18N

        clientsComboBox.setName("clientsComboBox"); // NOI18N
        clientsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(MainView.class, this);
        newClientButton.setAction(actionMap.get("newClient")); // NOI18N
        newClientButton.setText(resourceMap.getString("newClientButton.text")); // NOI18N
        newClientButton.setName("newClientButton"); // NOI18N

        clientsL.setText(resourceMap.getString("clientsL.text")); // NOI18N
        clientsL.setName("clientsL"); // NOI18N

        newProductButton.setAction(actionMap.get("newProduct")); // NOI18N
        newProductButton.setText(resourceMap.getString("newProductButton.text")); // NOI18N
        newProductButton.setName("newProductButton"); // NOI18N

        newCategoryButton.setAction(actionMap.get("newCategory")); // NOI18N
        newCategoryButton.setText(resourceMap.getString("newCategoryButton.text")); // NOI18N
        newCategoryButton.setName("newCategoryButton"); // NOI18N

        addProductButton.setAction(actionMap.get("addProduct")); // NOI18N
        addProductButton.setText(resourceMap.getString("addProductButton.text")); // NOI18N
        addProductButton.setName("addProductButton"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        mainTable.setAutoCreateRowSorter(true);
        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

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

        totalLable.setText(resourceMap.getString("totalLable.text")); // NOI18N
        totalLable.setName("totalLable"); // NOI18N

        sentPriceLable.setText(resourceMap.getString("sentPriceLable.text")); // NOI18N
        sentPriceLable.setName("sentPriceLable"); // NOI18N

        soldTotalLable.setText(resourceMap.getString("soldTotalLable.text")); // NOI18N
        soldTotalLable.setName("soldTotalLable"); // NOI18N

        sentTotalLable.setText(resourceMap.getString("sentTotalLable.text")); // NOI18N
        sentTotalLable.setName("sentTotalLable"); // NOI18N

        editClient.setAction(actionMap.get("editClient")); // NOI18N
        editClient.setText(resourceMap.getString("editClient.text")); // NOI18N
        editClient.setName("editClient"); // NOI18N

        soldPriceLable.setText(resourceMap.getString("soldPriceLable.text")); // NOI18N
        soldPriceLable.setName("soldPriceLable"); // NOI18N

        mSentPriceOut.setEditable(false);
        mSentPriceOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        mSentPriceOut.setText(resourceMap.getString("mSentPriceOut.text")); // NOI18N
        mSentPriceOut.setName("mSentPriceOut"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSendValue}"), mSentPriceOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        nSentTotalOut.setEditable(false);
        nSentTotalOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        nSentTotalOut.setText(resourceMap.getString("nSentTotalOut.text")); // NOI18N
        nSentTotalOut.setName("nSentTotalOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSent}"), nSentTotalOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        nSoldTotalOut.setEditable(false);
        nSoldTotalOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        nSoldTotalOut.setText(resourceMap.getString("nSoldTotalOut.text")); // NOI18N
        nSoldTotalOut.setName("nSoldTotalOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSold}"), nSoldTotalOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        mSoldPriceOut.setEditable(false);
        mSoldPriceOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        mSoldPriceOut.setText(resourceMap.getString("mSoldPriceOut.text")); // NOI18N
        mSoldPriceOut.setName("mSoldPriceOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.totalSoldValue}"), mSoldPriceOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        nTotalOut.setEditable(false);
        nTotalOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        nTotalOut.setText(resourceMap.getString("nTotalOut.text")); // NOI18N
        nTotalOut.setName("nTotalOut"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, clientsComboBox, org.jdesktop.beansbinding.ELProperty.create("${selectedItem.total}"), nTotalOut, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(sentTotalLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nSentTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soldTotalLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nSoldTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sentPriceLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mSentPriceOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soldPriceLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mSoldPriceOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(addProductButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(newClientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newCategoryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newProductButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(clientsL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editClient, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                    .addComponent(clientsL)
                    .addComponent(editClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sentTotalLable)
                    .addComponent(nSentTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soldTotalLable)
                    .addComponent(nSoldTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sentPriceLable)
                    .addComponent(mSentPriceOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soldPriceLable)
                    .addComponent(mSoldPriceOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductButton)
                    .addComponent(totalLable)
                    .addComponent(nTotalOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        deliveryOverviewMenuitem.setAction(actionMap.get("openDeliveryOverview")); // NOI18N
        deliveryOverviewMenuitem.setText(resourceMap.getString("deliveryOverviewMenuitem.text")); // NOI18N
        deliveryOverviewMenuitem.setName("deliveryOverviewMenuitem"); // NOI18N
        openDeliveryManuItem.add(deliveryOverviewMenuitem);

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

        invoiceOverviewMenuItem.setAction(actionMap.get("openInvoiceOverview")); // NOI18N
        invoiceOverviewMenuItem.setText(resourceMap.getString("invoiceOverviewMenuItem.text")); // NOI18N
        invoiceOverviewMenuItem.setName("invoiceOverviewMenuItem"); // NOI18N
        oepnInvoiceMenuItem.add(invoiceOverviewMenuItem);

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

        userInfoMenuitem.setAction(actionMap.get("userInfoMangm"));
        userInfoMenuitem.setText(resourceMap.getString("userInfoMenuitem.text")); // NOI18N
        userInfoMenuitem.setName("userInfoMenuitem"); // NOI18N
        helpMenu.add(userInfoMenuitem);

        aboutMenuItem.setAction(actionMap.get("showAboutBox"));
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainTableMouseClicked
        if (evt.getClickCount() > 1) {
            if (dialogMap.get("EditExportLine") == null) {
                JFrame mainFrame = GuiMain.getApplication().getMainFrame();
                dialogMap.put("EditExportLine", new EditExportLineForm(GuiMain.getApplication().getMainFrame()));
                dialogMap.get("EditExportLine").setLocationRelativeTo(mainFrame);
                dialogMap.get("EditExportLine").addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowDeactivated(WindowEvent evt) {
                        try {
                            int index = mainTable.convertRowIndexToModel(mainTable.getSelectedRow());
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
            }
            GuiMain.getApplication().show(dialogMap.get("EditExportLine"));
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
    private static javax.swing.JComboBox clientsComboBox;
    private javax.swing.JLabel clientsL;
    private javax.swing.JMenuItem deliveryOverviewMenuitem;
    private javax.swing.JButton editClient;
    private javax.swing.JMenuItem invoiceOverviewMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField mSentPriceOut;
    private javax.swing.JFormattedTextField mSoldPriceOut;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable mainTable;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JFormattedTextField nSentTotalOut;
    private javax.swing.JFormattedTextField nSoldTotalOut;
    private javax.swing.JFormattedTextField nTotalOut;
    private javax.swing.JButton newCategoryButton;
    private javax.swing.JButton newClientButton;
    private javax.swing.JButton newProductButton;
    private javax.swing.JMenu oepnInvoiceMenuItem;
    private javax.swing.JMenu openDeliveryManuItem;
    private javax.swing.JMenuItem openWarehouseMenuItem;
    private javax.swing.JMenuItem printMenuItem;
    private javax.swing.JLabel sentPriceLable;
    private javax.swing.JLabel sentTotalLable;
    private javax.swing.JLabel soldPriceLable;
    private javax.swing.JLabel soldTotalLable;
    private javax.swing.JLabel totalLable;
    private javax.swing.JMenuItem userInfoMenuitem;
    private javax.swing.JMenu warehouseMenu;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    //private BindingGroup bindingGroup;
    private static List<Clients> clientsList;
    private List<ExportLine> exportLinesList;
    private HashMap<String, JDialog> dialogMap = new HashMap<String, JDialog>();

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
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${price}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.priceS"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sent}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.send"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sentPrice}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.sendPrice"));
        columnBinding.setColumnClass(Float.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${sold}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.sold"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = mainTableBinding.addColumnBinding(ELProperty.create("${total}"));
        columnBinding.setColumnName(resourceMap.getString("mainTable.columnModel.total"));
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(mainTableBinding);
        mainTableBinding.bind();
        bindingGroup.bind();
    }

    protected static void clientListRefresh() {
        clientsList.clear();
        try {
            clientsList.addAll(ClientOps.getClients());
            clientsComboBox.updateUI();
        } catch (Exception ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void refreshTotal() {
        int i = clientsComboBox.getSelectedIndex();
        clientListRefresh();
        clientsComboBox.setSelectedIndex(i);
    }

    @Action
    public void showAboutBox() {
        if (dialogMap.get("AboutBox") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("AboutBox", new AboutBox(mainFrame));
            dialogMap.get("AboutBox").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("AboutBox"));
    }

    @Action
    public void showInvoice() {
        InvoiceForm invForm = InvoiceForm.getInstance();
        invForm.setLocationRelativeTo(mainTable);
        invForm.setVisible(true);
    }

    @Action
    public void newInvoice() {
        if (dialogMap.get("NewInvoice") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewInvoice", new NewInvioceForm(mainFrame));
            dialogMap.get("NewInvoice").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("NewInvoice"));
    }

    @Action
    public void showDelivery() {
        DeliveryForm delivForm = DeliveryForm.getInstance();
        delivForm.setLocationRelativeTo(mainTable);
        delivForm.setVisible(true);
    }

    @Action
    public void newDelivery() {
        if (dialogMap.get("NewDelivery") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewDelivery", new NewDeliveryForm(mainFrame));
            dialogMap.get("NewDelivery").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("NewDelivery"));
    }

    @Action
    public void openDeliveryOverview() {
        DeliveryOverviewForm delivForm = DeliveryOverviewForm.getInstance();
        delivForm.setLocationRelativeTo(mainTable);
        delivForm.setVisible(true);
    }

    @Action
    public void openInvoiceOverview() {
        InvoiceOverviewForm delivForm = InvoiceOverviewForm.getInstance();
        delivForm.setLocationRelativeTo(mainTable);
        delivForm.setVisible(true);
    }

    @Action
    public void newClient() {
        if (dialogMap.get("NewClient") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewClient", new ClientForm(mainFrame));
            dialogMap.get("NewClient").setLocationRelativeTo(mainFrame);
            dialogMap.get("NewClient").addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent e) {
                    clientListRefresh();
                }
            });
        }
        GuiMain.getApplication().show(dialogMap.get("NewClient"));
    }

    @Action
    public void newCategory() {
        if (dialogMap.get("NewCategory") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewCategory", new CategoryForm(mainFrame));
            dialogMap.get("NewCategory").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("NewCategory"));
    }

    @Action
    public void openWarehouse() {
        WarehouseForm whf = WarehouseForm.getInstance();
        whf.setLocationRelativeTo(mainTable);
        whf.setVisible(true);
    }

    @Action
    public void newProduct() {
        if (dialogMap.get("NewProduct") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewProduct", new ProductForm(mainFrame));
            dialogMap.get("NewProduct").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("NewProduct"));
    }

    @Action
    public void newExport() {
        if (dialogMap.get("NewExport") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("NewExport", new NewDocumentForm(mainFrame));
            dialogMap.get("NewExport").setLocationRelativeTo(mainFrame);
            dialogMap.get("NewExport").addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent e) {
                    clientListRefresh();
                }
            });
        }
        GuiMain.getApplication().show(dialogMap.get("NewExport"));
    }

    @Action
    public void addProduct() {
        if (dialogMap.get("AddProduct") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("AddProduct", new AddProductForm(mainFrame));
            dialogMap.get("AddProduct").setLocationRelativeTo(mainFrame);
            dialogMap.get("AddProduct").addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent evt) {
                    clientListRefresh();
                }
            });
        }
        GuiMain.getApplication().show(dialogMap.get("AddProduct"));
    }

    @Action
    public void userInfoMangm() {
        if (dialogMap.get("UserInfoMangm") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("UserInfoMangm", new UserInfoForm(mainFrame));
            dialogMap.get("UserInfoMangm").setLocationRelativeTo(mainFrame);
        }
        GuiMain.getApplication().show(dialogMap.get("UserInfoMangm"));
    }

    @Action
    public void editClient() {
        if (dialogMap.get("EditClient") == null) {
            JFrame mainFrame = GuiMain.getApplication().getMainFrame();
            dialogMap.put("EditClient", new EditClientForm(mainFrame));
            dialogMap.get("EditClient").setLocationRelativeTo(mainFrame);
            dialogMap.get("EditClient").addWindowListener(new WindowAdapter() {

                @Override
                public void windowDeactivated(WindowEvent e) {
                    clientListRefresh();
                }
            });
        }
        GuiMain.getApplication().show(dialogMap.get("EditClient"));
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

    public void testFirstRun() {
        if (ClientOps.isUserInfoEmpty()) {
            userInfoMangm();
        }
    }

    public Clients getSelectedClient() {
        Clients c = (Clients) clientsComboBox.getSelectedItem();
        if (c == null) {
            MyUtilErrorClass.errorDialog("error.imput.novalue");
            throw new IllegalArgumentException();
        }
        return c;
    }

    public ExportLine getSelectedExportLine(){
        int index = mainTable.convertRowIndexToModel(mainTable.getSelectedRow());
        return exportLinesList.get(index);
    }
}
// TODO: Dorobit potvrdenie na enter
// TODO: Upravit DB aby potporovala uniqu itemy
// TODO: include inheritance in entity classes
// TODO: lokalizovat nazvy v labloch documentov
// TODO: Cesty k xsl do resource
// TODO: pridat prvky do kategorie cisla pre produkty
// TODO: autovytvorenie delivery a invoice ak je prazny na add
// TODO: prepojit sklad!!!

