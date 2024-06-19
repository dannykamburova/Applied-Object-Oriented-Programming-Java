package com.view;

import java.net.URL;
import java.util.ResourceBundle;

import data.model.InventoryManagement;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnFindAverage;

    @FXML
    private Button btnGroup;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnShowInventory;

    @FXML
    private Button btnSort;

    @FXML
    private TextArea txaResult;

    private InventoryManagement inventoryManagement;
    @FXML
    void btnFindAverageOnAction(ActionEvent event) {
        double average = inventoryManagement.averagePrice();
        txaResult.setText("Average Price: " + average);
    }

    @FXML
    void btnGroupOnAction(ActionEvent event) {
        String largestPrices = inventoryManagement.findLargestPricePerCategory();
        txaResult.setText("Largest Prices per Category:\n" + largestPrices);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnShowInventoryOnAction(ActionEvent event) {
        String inventoryList = inventoryManagement.showInventory();
        txaResult.setText(inventoryList);
    }

    @FXML
    void btnSortOnAction(ActionEvent event) {
        String sortedInventory = inventoryManagement.sortInventoryTypeAndID().toString();
        txaResult.setText("Sorted Inventory:\n" + sortedInventory);
    }

    @FXML
    void initialize() {
        assert btnFindAverage != null : "fx:id=\"btnFindAverage\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnGroup != null : "fx:id=\"btnGroup\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnShowInventory != null : "fx:id=\"btnShowInventory\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSort != null : "fx:id=\"btnSort\" was not injected: check your FXML file 'sample.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'sample.fxml'.";

        inventoryManagement = new InventoryManagement();
    }

}
