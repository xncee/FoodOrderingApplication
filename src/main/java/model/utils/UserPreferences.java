package model.utils;

import java.util.prefs.Preferences;

public class UserPreferences {
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String LANGUAGE_KEY = "language";

    // When user checks "Remember Me" Checkbox
    public static void saveCredentials(String username,String password) {
        Preferences pref = Preferences.userRoot().node(UserPreferences.class.getName());
        pref.put(USERNAME_KEY,username);
        pref.put(PASSWORD_KEY,password);
    }

    // When the app starts
    public static String[] getCredentials() {
        Preferences pref = Preferences.userRoot().node(UserPreferences.class.getName());
        String username = pref.get(USERNAME_KEY, null);
        String password = pref.get(PASSWORD_KEY, null);
        return new String[] {username, password};
    }

    // When user changes language
    public static void setLanguage(String language) {
        Preferences pref = Preferences.userRoot().node(UserPreferences.class.getName());
        pref.put(LANGUAGE_KEY, language);
    }
    public static String getLanguage() {
        Preferences pref = Preferences.userRoot().node(UserPreferences.class.getName());
        String lang = pref.get(LANGUAGE_KEY, null);
        return (lang!=null?lang:DEFAULT_LANGUAGE);
    }

    // when the user logs out
    public static void clear() {
        Preferences pref = Preferences.userRoot().node(UserPreferences.class.getName());
        pref.remove(USERNAME_KEY);
        pref.remove(PASSWORD_KEY);
        pref.remove(LANGUAGE_KEY);
    }
}