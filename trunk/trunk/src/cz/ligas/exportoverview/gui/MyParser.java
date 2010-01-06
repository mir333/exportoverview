package cz.ligas.exportoverview.gui;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author miro
 */
public class MyParser {

    public static float paresePrice(String imput) throws ParseException{
        NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        return moneyFormat.parse(imput).floatValue();
    }

    public static int pareseIntNumber(String imput) throws ParseException{
        NumberFormat numberFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
        return numberFormat.parse(imput).intValue();
    }
}
