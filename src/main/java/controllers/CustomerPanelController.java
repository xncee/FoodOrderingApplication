package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;

public class CustomerPanelController {

    @FXML
    private Hyperlink handleRestaurants;
    @FXML
    private Hyperlink handleOrders;
    @FXML
    private Hyperlink handleSupport;
    @FXML
    private ToggleButton categoryButtonAll;
    @FXML
    private ToggleButton categoryButtonPizza;
    @FXML
    private ToggleButton categoryButtonBurgers;
    @FXML
    private ToggleButton categoryButtonSushi;
    @FXML
    private ToggleButton categoryButtonItalian;
    @FXML
    private ToggleButton categoryButtonChinese;
    @FXML
    private ToggleButton categoryButtonIndian;
    @FXML
    private ImageView filterButton;
    @FXML
    private ImageView sortButton;
    @FXML
    private Hyperlink handleAboutUs;
    @FXML
    private Hyperlink handleCareers;
    @FXML
    private Hyperlink handlePress;
    @FXML
    private Hyperlink handlePartner;
    @FXML
    private Hyperlink handleRestaurantApp;
    @FXML
    private Hyperlink handleBecomeDriver;
    @FXML
    private Hyperlink handleDriverPortal;
    @FXML
    private Hyperlink handleHelpCenter;
    @FXML
    private Hyperlink handleContact;
    @FXML
    private Hyperlink handleTerms;
    @FXML
    private Hyperlink handlePrivacy;

    @FXML
    private void handleRestaurants(ActionEvent event) {
        System.out.println("Navigating to Restaurants...");
    }

    @FXML
    private void handleOrders(ActionEvent event) {
        System.out.println("Navigating to Orders...");
    }

    @FXML
    private void handleSupport(ActionEvent event) {
        System.out.println("Navigating to Support...");
    }

    @FXML
    private void handleFilter(ActionEvent event) {
        System.out.println("Applying filters...");
    }

    @FXML
    private void handleSort(ActionEvent event) {
        System.out.println("Sorting items...");
    }

    @FXML
    private void toggleCategory(ActionEvent event) {
        ToggleButton toggleButton = (ToggleButton) event.getSource();
        System.out.println("Category selected: " + toggleButton.getText());
    }

    @FXML
    private void handleAboutUs(ActionEvent event) {
        System.out.println("Navigating to About Us...");
    }

    @FXML
    private void handleCareers(ActionEvent event) {
        System.out.println("Navigating to Careers...");
    }

    @FXML
    private void handlePress(ActionEvent event) {
        System.out.println("Navigating to Press...");
    }

    @FXML
    private void handlePartner(ActionEvent event) {
        System.out.println("Navigating to Partner with us...");
    }

    @FXML
    private void handleRestaurantApp(ActionEvent event) {
        System.out.println("Navigating to Restaurant app...");
    }

    @FXML
    private void handleBecomeDriver(ActionEvent event) {
        System.out.println("Navigating to Become a Driver...");
    }

    @FXML
    private void handleDriverPortal(ActionEvent event) {
        System.out.println("Navigating to Driver Portal...");
    }

    @FXML
    private void handleHelpCenter(ActionEvent event) {
        System.out.println("Navigating to Help Center...");
    }

    @FXML
    private void handleContact(ActionEvent event) {
        System.out.println("Navigating to Contact Us...");
    }

    @FXML
    private void handleTerms(ActionEvent event) {
        System.out.println("Navigating to Terms of Service...");
    }

    @FXML
    private void handlePrivacy(ActionEvent event) {
        System.out.println("Navigating to Privacy Policy...");
    }
}
