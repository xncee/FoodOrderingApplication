package model.utils;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class FieldsServices {
    public static void setRedBorder(Node element) {
        element.setStyle("-fx-border-color: red");
    }
    private static void resetBorderColor(Node element) {
        element.setStyle("-fx-border-color: #d4d4d4");
    }
    public static void setFieldValid(Node element) {
        resetBorderColor(element);
    }
    public static void addErrorMessage(Label errorLabel, String errorMessage) {
        if (errorLabel != null && errorMessage != null && !errorMessage.isEmpty()) {
            // append the new error message
            String old = errorLabel.getText();
            errorLabel.setText(old + "* " + errorMessage + "\n");
            errorLabel.setVisible(true);  // Make sure the error label is visible
        }
    }
}