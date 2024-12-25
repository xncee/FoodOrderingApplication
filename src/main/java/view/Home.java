package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "home.fxml";
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getResource(fileName));
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to load '"+fileName+"'");
        }

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Food Ordering System");
        stage.show();
    }
}
