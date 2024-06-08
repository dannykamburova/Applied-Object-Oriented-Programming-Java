package view;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import geometry.Line;
import geometry.Point;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawLine;

    @FXML
    private Button btnDrawrRectangle;

    @FXML
    private Pane pnlDrawingBoard;

    private Random rand;
    private int paneWidth;
    private int paneHeight;


    @FXML
    void btnDrawLineOnAction(ActionEvent event) {
        paneWidth = (int) pnlDrawingBoard.getWidth();
        paneHeight = (int) pnlDrawingBoard.getHeight();
        Line line = new Line(new int[]{
                rand.nextInt(paneWidth),
                rand.nextInt(paneHeight)
                },
                new Point( new int[]{
                  rand.nextInt(paneWidth),
                        rand.nextInt(paneHeight)}
                ));
        line.draw(pnlDrawingBoard);
    }

    @FXML
    void btnDrawrRectangleOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDrawLine != null : "fx:id=\"btnDrawLine\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnDrawrRectangle != null : "fx:id=\"btnDrawrRectangle\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert pnlDrawingBoard != null : "fx:id=\"pnlDrawingBoard\" was not injected: check your FXML file 'MainScene.fxml'.";
        rand = new Random();
    }
}
