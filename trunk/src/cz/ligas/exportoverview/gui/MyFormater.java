package cz.ligas.exportoverview.gui;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author ligasm
 */
public class MyFormater {

    public static String priceFormater(double imput) {
        NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return moneyFormat.format(imput);
    }
}
