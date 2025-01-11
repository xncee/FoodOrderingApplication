package controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.utils.cache.FXMLCache;

import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContentSwitcher {
    private static ContentSwitcher instance;

    private BorderPane mainContainer = null;
    private String currentFile;
    private final Stack<Parent> pages = new Stack<>();

    public static ContentSwitcher getInstance() {
        if (instance == null) {
            instance = new ContentSwitcher();
        }

        return instance;
    }

    // Method to switch content dynamically using preloaded pages
    @FXML
    public void switchContent(String fxmlFile, boolean forceReload) {
        currentFile = fxmlFile;
        // Check if the FXML file is already preloaded
        Parent content = FXMLCache.getFXML(fxmlFile);
        if (content == null || forceReload) {
            // If not preloaded, load it and add it to the cache
            FXMLCache.preloadFXML(fxmlFile);
            content = FXMLCache.getFXML(fxmlFile);
        }

        // Set the content in the center of the BorderPane (main container)
        pages.push(content);
        mainContainer.setCenter(content);
    }

    @FXML
    public void switchContent(String fxmlFile) throws IOException {
        switchContent(fxmlFile, false);
    }

    @FXML
    public void offload() {
        pages.pop();
    }

    @FXML
    public void reloadPage() {
        Parent content = FXMLCache.preloadFXML(currentFile);
        mainContainer.setCenter(content);
    }

    @FXML
    public void switchToPreviousPage() {
        Parent current = null;
        if (!pages.isEmpty())
            current = pages.pop();
        try {
            mainContainer.setCenter(pages.peek());
        }
        catch (Exception e) {
            pages.push(current); // if switching failed, push the page back into the stack.
            Logger.getLogger(ContentSwitcher.class.getName()).log(Level.SEVERE, "Failed to switch to the previous page", e);
        }
    }

    @FXML
    public Stage getStage(Event event) {
        return (Stage) ((Node) (event.getSource())).getScene().getWindow();
    }

    @FXML
    public void popUpWindow(ActionEvent event, String fxmlFile) {
        // Try to get the cached FXML content
        Parent root = FXMLCache.getFXML(fxmlFile);

        if (root == null) {
            // If not found in the cache, load the FXML and cache it
            root = FXMLCache.preloadFXML(fxmlFile);
            if (root == null) {
                Logger.getLogger(ContentSwitcher.class.getName()).log(Level.SEVERE, "Failed to show popup window: "+fxmlFile+". reason: root is null.");
                return;
            }
        }

        // Create a new stage for the popup window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage modularStage = new Stage();
        modularStage.initStyle(StageStyle.UNIFIED);
        modularStage.setResizable(false);
        modularStage.initModality(Modality.WINDOW_MODAL);
        modularStage.initOwner(stage);

        // Set root to scene only if root wasn't set to another scene (if root wasn't cached).
        Scene scene = root.getScene();
        if (scene == null) {
            scene = new Scene(root); // if you tired to do this for cached FXML, you'll get an error as FXML root was already set to a scene.
        }
        modularStage.setScene(scene);

        // Show and wait for the modal to close
        modularStage.showAndWait();
    }

    @FXML
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setMainContainer(BorderPane mainContainer) {
        this.mainContainer = mainContainer;
    }
}
