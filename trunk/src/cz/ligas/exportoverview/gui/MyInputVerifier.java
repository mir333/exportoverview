/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.ligas.exportoverview.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author xligas
 */
public class MyInputVerifier extends InputVerifier implements ActionListener {
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
        System.err.println(input.getName());
        return checkNumberField(input);
    }

    public boolean checkNumberField(JComponent inp) {
            NumberFormat moneyFormat = NumberFormat.getNumberInstance();
            JTextField tf = (JTextField) inp;
            try {
                moneyFormat.parse(tf.getText()).doubleValue();
            } catch (ParseException pe) {
                message = "Invalid money format in Loan Amount field";
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
