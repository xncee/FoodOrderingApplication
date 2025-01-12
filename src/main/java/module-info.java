module foodorderingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires java.prefs;
    requires io.github.cdimascio.dotenv.java;


    opens application to javafx.fxml;
    exports application;
    exports controllers;
    opens controllers to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}