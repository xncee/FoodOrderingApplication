module foodorderingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;
    requires com.zaxxer.hikari;


    opens application to javafx.fxml;
    exports application;
}