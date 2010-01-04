package cz.ligas.exportoverview.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author miro
 */
public class UtilErrorClass {

    public static void errorDialog(String mes) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(UtilErrorClass.class);
        JOptionPane.showMessageDialog(null, resourceMap.getString(mes), resourceMap.getString("error.title"), JOptionPane.ERROR_MESSAGE);
    }
}
