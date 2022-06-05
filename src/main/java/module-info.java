module com.lab10.lab10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab10 to javafx.fxml;
    exports com.lab10.controllers;
    opens com.lab10.controllers to javafx.fxml;
    exports com.lab10.models;
    opens com.lab10.models to javafx.fxml;
    exports com.lab10;
}