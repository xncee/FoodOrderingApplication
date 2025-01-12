package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.enums.Messages;
import model.login.Login;
import model.utils.FieldsServices;
import model.utils.UserPreferences;

import java.io.IOException;

public class SignInController {
    private static final ContentSwitcher contentSwitcher = ContentSwitcher.getInstance();

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private CheckBox rememberMeCheckbox;

    @FXML
    private Button signInButton;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    public void initialize() {
        loadRememberMe();
    }

    private void loadRememberMe() {
        String[] credentials = UserPreferences.getCredentials();
        String savedUsername = credentials[0];
        String savedPassword = credentials[1];

        if (savedUsername != null && savedPassword != null) {
            usernameField.setText(savedUsername);
            passwordField.setText(savedPassword);
            rememberMeCheckbox.setSelected(true);
        }
    }

    private boolean validateForm() {
        boolean valid = true;
        if (usernameField.getText().isBlank()) {
            FieldsServices.setRedBorder(usernameField);
            valid = false;
        } else {
            FieldsServices.setFieldValid(usernameField);
        }
        if (passwordField.getText().isBlank()) {
            FieldsServices.setRedBorder(passwordField);
            valid = false;
        } else {
            FieldsServices.setFieldValid(passwordField);
        }

        return valid;
    }

    @FXML
    public void handleSignIn(ActionEvent event) throws IOException {
        //System.out.println("Signing in...");
        if (!validateForm()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in the required fields.");
            alert.showAndWait();
            return;
        }

        if (rememberMeCheckbox != null && rememberMeCheckbox.isSelected())
            UserPreferences.saveCredentials(usernameField.getText(), passwordField.getText());
        else
            UserPreferences.clear();

        Login login = Login.getInstance();
        boolean loggedIn = true; //login.signIn(usernameField.getText(), passwordField.getText());
        if (!loggedIn) {
            Alert alert = new Alert(Alert.AlertType.ERROR, Messages.INVALID_LOGIN_DETAILS.getMessage());
            alert.showAndWait();
            return;
        }
        System.out.println("Logged In as " + usernameField.getText());
        System.out.println("Switching To Customer Panel...");
        contentSwitcher.switchContent("/view/CustomerPanel.fxml");
    }

    @FXML
    public void handleSignup(ActionEvent event) throws IOException {
        contentSwitcher.switchContent("/view/SignUp.fxml");
    }

    @FXML
    public void handleForgotPassword(ActionEvent event) {

    }
}