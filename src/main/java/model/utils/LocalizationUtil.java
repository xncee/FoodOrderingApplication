package model.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationUtil {
    private static ResourceBundle resourceBundle;

    public static boolean setLocale(Locale locale) {
        if (resourceBundle == null || !locale.equals(resourceBundle.getLocale())) {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
            return true;
        }
        return false;
    }

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}