package com.vue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import stock.model.IRandomStockSupplier;
import stock.model.Stock;
import stock.model.StockManagement;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem mniComputeAverage;

    @FXML
    private MenuItem mniGroupData;

    @FXML
    private MenuItem mniLoad;

    @FXML
    private MenuItem mniQuit;

    @FXML
    private MenuItem mniSaveAs;

    @FXML
    private MenuItem mniSortData;

    @FXML
    private Menu mnuAdmin;

    @FXML
    private Menu mnuManage;

    @FXML
    private TextArea txaResult;

    private StockManagement stockManagement;

    @FXML
    void mniComputeAverageOnAction(ActionEvent event) {
        double averagePrice = stockManagement.averagePrice();
        txaResult.setText("Average Price: " + averagePrice);
    }

    @FXML
    void mniGroupDataOnAction(ActionEvent event) {
        String groupedData = stockManagement.groupByReorderQtyAndNumberSuppliers();
        txaResult.setText(groupedData);
    }

    @FXML
    void mniLoadOnAction(ActionEvent event) {
        stockManagement.showStocks();
        txaResult.setText(stockManagement.showStocks());
    }

    @FXML
    void mniQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void mniSaveAsOnAction(ActionEvent event) {
        try {
            File file = new File("stocks.ser");
            stockManagement.writeSerializable(file);
            txaResult.setText("Stocks saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            txaResult.setText("Error saving stocks: " + e.getMessage());
        }
    }

    @FXML
    void mniSortDataOnAction(ActionEvent event) {
        List<Stock> sortedStocks = stockManagement.sortStockByReorderQtyAndID();
        txaResult.setText("Sorted Stocks:\n" + sortedStocks);
    }

    @FXML
    void mnuAdminOnAction(ActionEvent event) {

    }

    @FXML
    void mnuManageOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert mniComputeAverage != null : "fx:id=\"mniComputeAverage\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mniGroupData != null : "fx:id=\"mniGroupData\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mniLoad != null : "fx:id=\"mniLoad\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mniQuit != null : "fx:id=\"mniQuit\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mniSaveAs != null : "fx:id=\"mniSaveAs\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mniSortData != null : "fx:id=\"mniSortData\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mnuAdmin != null : "fx:id=\"mnuAdmin\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert mnuManage != null : "fx:id=\"mnuManage\" was not injected: check your FXML file 'sampleScene.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'sampleScene.fxml'.";

        stockManagement = new StockManagement(new IRandomStockSupplier() {
            @Override
            public List<Stock> get() {
                return loadStock(12, 10, 20);
            }
        });
    }

}
