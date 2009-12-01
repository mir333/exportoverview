/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;

/**
 *
 * @author xligas
 */
public class MyInputVerifier extends InputVerifier implements ActionListener {

    ResourceMap resourceMap = Application.getInstance().getContext().getResourceMap(MyInputVerifier.class);
    String message = null;

    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            return true;
        }
        showDialog(message);
        input.setInputVerifier(this);
        return false;
    }

    @Override
    public boolean verify(JComponent input) {
        boolean b = true;
        char c = input.getName().charAt(0);
        if (c == 'n') {
            return checkNumberField(input);
        } else if (c == 'm') {
            return checkMoneyField(input);
        } else if (c == 't') {
            return true;
        }
        return b;
    }

    public boolean checkNumberField(JComponent inp) {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
        JTextField tf = (JTextField) inp;
        try {
            //TODO: prerobit pripadne na reg vyraz ale osetrit lokalizaciu
//            if(tf.getText().length()==0)
//                return true;
            String s = numberFormat.format(numberFormat.parse(tf.getText()).intValue());
            //tf.setText(s);
        } catch (ParseException pe) {
            message = resourceMap.getString("validation.error.number");
            return false;
        }
        return true;
    }

    public boolean checkMoneyField(JComponent inp) {
        NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        JTextField tf = (JTextField) inp;
        try {
//            if(tf.getText().length()==0)
//                return true;
            String s = moneyFormat.format(moneyFormat.parse(tf.getText()).doubleValue());
            //tf.setText(s);
        } catch (ParseException pe) {
            message = resourceMap.getString("validation.error.money");
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        shouldYieldFocus(source); //ignore return value
        source.selectAll();
    }

    private void showDialog(String mes) {
        JOptionPane.showMessageDialog(null, //no owner frame
                mes, //text to display
                "Invalid Value", //title
                JOptionPane.WARNING_MESSAGE);
    }
}
