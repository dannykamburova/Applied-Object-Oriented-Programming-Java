module com.vue {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.vue to javafx.fxml;
    exports com.vue to javafx.graphics;
    requires stock.model;
}