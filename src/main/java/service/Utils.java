package service;

import java.text.MessageFormat;

public class Utils {

    public static String dCrlat(String path) {
        return MessageFormat.format("[data-crlat = \"{0}\"]", path);
    }

    public static String dUAT(String path) {
        return MessageFormat.format("[data-uat = \"{0}\"]", path);
    }

   public static int genRandom = (int) (Math.random()* 522 + 1);


}
