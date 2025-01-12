package model.utils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsValidator {

    private static boolean isFieldEmpty(String field) {
        return field == null || field.trim().isEmpty();
    }

    public static boolean validateName(String name) {
        if (isFieldEmpty(name)) return false;
        // name should have at least 2 parts.
        String nameRegex = "^(\\S+\\s+\\S+.*)$";
        Pattern pattern=Pattern.compile(nameRegex);
        Matcher matcher=pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean validateUsername(String username) {
        if (isFieldEmpty(username)) return false;
        // username should only contain english letter, number and '_'.
        // username should be at least 4 characters long.
        String usernameRegex = "^[a-zA-Z0-9_]{4,}$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        if (isFieldEmpty(email)) return false;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        if (isFieldEmpty(password)) return false;

        //String passwordRegex = "(?=.[0-9])(?=.[a-z])(?=.*[A-Z]).{8,}"; // requires at least one lower case
        String passwordRegex = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}