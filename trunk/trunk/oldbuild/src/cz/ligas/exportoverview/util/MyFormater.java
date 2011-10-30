package cz.ligas.exportoverview.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author ligasm
 */
public class MyFormater {

    public static String priceFormater(double imput) {
        NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        moneyFormat.setMaximumFractionDigits(2);
        moneyFormat.setMinimumFractionDigits(2);
        return moneyFormat.format(imput);
    }
}
