module com.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires data.model;
    opens com.view to javafx.fxml;
    exports com.view to javafx.graphics;
}