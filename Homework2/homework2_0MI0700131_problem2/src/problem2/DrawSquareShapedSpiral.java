package problem2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawSquareShapedSpiral extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 400);

        double width = scene.getWidth();
        double height = scene.getHeight();

        stage.setTitle("DrawSquareShapedSpiral");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();

        // Calculate the center coordinates
        double widthCenter = width / 2;
        double heightCenter = height / 2;

        for (int counter = 0; counter < 5; counter++) {

            // Calculate the x and y coordinates of start point
            double x = widthCenter + (30 * counter);
            double y = heightCenter + 30 + (30 * counter);

            // Create the lines, colour them and set the stroke
            Line firstLine = new Line(x, y, x, heightCenter - (30 * counter));
            firstLine.setStroke(Color.RED);
            firstLine.setStrokeWidth(1);

            Line secondLine = new Line(x, y, widthCenter - 30 - (30 * counter), y);
            secondLine.setStroke(Color.RED);
            secondLine.setStrokeWidth(1);

            Line thirdLine = new Line(widthCenter - 30 - (30 * counter), y, widthCenter - 30 - (30 * counter), heightCenter - 30 - (30 * counter));
            thirdLine.setStroke(Color.RED);
            thirdLine.setStrokeWidth(1);

            Line fourthLine = new Line(widthCenter - 30 - (30 * counter), heightCenter - 30 - (30 * counter), x + 30, heightCenter - 30 - (30 * counter));
            fourthLine.setStroke(Color.RED);
            fourthLine.setStrokeWidth(1);

            // Grouping them all together
            group.getChildren().addAll(firstLine, secondLine, thirdLine, fourthLine);
        }
    }
}


