package problem2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawLines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);

        double width = scene.getWidth();
        double height = scene.getHeight();

        drawLines(group, width, height);

        stage.setTitle("DrawLines");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    private void drawLines(Group group, double width, double height) {
        // Dividing the width and the height of the scene by 20, so that we have 20
        // lines starting from every side
        double width2 = width / 20.0;
        double height2 = height / 20.0;

        // Using for cycle so that it can draw 20 lines from each side
        for (int x = 0, y = 0; x <= width && y <= height; x += width2, y += height2) {
                // Drawing down left lines
                Line downLeft = new Line(0, y, x, height);
                downLeft.setStrokeWidth(0.5);
                downLeft.setStroke(Color.RED);

                // Drawing up left lines
                Line upLeft = new Line(0, height - y, x, 0);
                upLeft.setStrokeWidth(0.5);
                upLeft.setStroke(Color.RED);

                // Drawing up right lines
                Line upRight = new Line(width - x, 0, width, height - y);
                upRight.setStrokeWidth(0.5);
                upRight.setStroke(Color.RED);

                // Drawing down right lines
                Line downRight = new Line(x, height, width, height - y);
                downRight.setStrokeWidth(0.5);
                downRight.setStroke(Color.RED);

                // Grouping them all together, so it can print out the desired result
                group.getChildren().addAll(downLeft, upLeft, downRight, upRight);
        }
    }
}
