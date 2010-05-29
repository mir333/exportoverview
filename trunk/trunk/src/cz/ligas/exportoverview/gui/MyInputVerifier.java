package cz.ligas.exportoverview.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author xligas
 */
public class MyInputVerifier extends InputVerifier implements ActionListener {

    String message = null;

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean inputOK = verify(input);
        if (inputOK) {
            return true;
        }
        MyUtilErrorClass.errorDialog(message);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        shouldYieldFocus(source); //ignore return value
        source.selectAll();
    }
    
    public boolean checkNumberField(JComponent inp) {
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
        JTextField tf = (JTextField) inp;
        try {
            //TODO: prerobit pripadne na reg vyraz ale osetrit lokalizaciu
//            if(tf.getText().length()==0)
//                return true;
            String s = numberFormat.format(numberFormat.parse(tf.getText()).intValue());
            tf.setText(s);
        } catch (ParseException pe) {
            message = "validation.error.number";
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
            tf.setText(s);
        } catch (ParseException pe) {
            message = "validation.error.money";
            return false;
        }
        return true;
    }
}
