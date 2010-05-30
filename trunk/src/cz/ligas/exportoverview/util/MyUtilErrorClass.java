package cz.ligas.exportoverview.util;

import javax.swing.JOptionPane;

/**
 *
 * @author miro
 */
public class MyUtilErrorClass {

    public static void errorDialog(String mes) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(MyUtilErrorClass.class);
        JOptionPane.showMessageDialog(null, resourceMap.getString(mes), resourceMap.getString("error.title"), JOptionPane.ERROR_MESSAGE);
    }
}
