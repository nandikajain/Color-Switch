package obstacles;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SquareObstacle extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
        Group group= new Group();
        Line line1 = new Line();
        line1.setStartX(180.0);
        line1.setStartY(150.0);
        line1.setEndX(320.0);
        line1.setEndY(150.0);
        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(10);
        group.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(180.0);
        line2.setStartY(150.0);
        line2.setEndX(180.0);
        line2.setEndY(270.0);
        line2.setStroke(Color.PURPLE);
        line2.setStrokeWidth(10);
        group.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(180.0);
        line3.setStartY(270.0);
        line3.setEndX(320.0);
        line3.setEndY(270.0);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(10);
        group.getChildren().addAll(line3);
        Line line4 = new Line();
        line4.setStartX(320.0);
        line4.setStartY(150.0);
        line4.setEndX(320.0);
        line4.setEndY(270.0);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(10);
        group.getChildren().addAll(line4);
        root.getChildren().add(group);
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setNode(group);
        rotate.play();

        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
