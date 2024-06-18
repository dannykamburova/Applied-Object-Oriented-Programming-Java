module gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires lib;

    opens test to javafx.fxml;
    exports test to javafx.graphics;
}