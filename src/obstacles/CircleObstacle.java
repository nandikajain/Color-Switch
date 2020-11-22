package obstacles;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleObstacle extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
        Group group = new Group();
        //Change values here in order to get circle obstacles with different parameters
        double centerX=250;
        double centerY=210;
        double radius=60;

        //Circle Obstacle Creation
        Arc arc1 = new Arc();
        arc1.setCenterX(centerX);
        arc1.setCenterY(centerY);
        arc1.setRadiusX(radius);
        arc1.setRadiusY(radius);
        arc1.setStartAngle(0);
        arc1.setLength(90);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.YELLOW);
        arc1.setStrokeWidth(10);
        arc1.setType(ArcType.OPEN);
        Arc arc2 = new Arc();
        arc2.setCenterX(centerX);
        arc2.setCenterY(centerY);
        arc2.setRadiusX(radius);
        arc2.setRadiusY(radius);
        arc2.setStartAngle(90);
        arc2.setLength(90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(10);
        arc2.setType(ArcType.OPEN);
        Arc arc3 = new Arc();
        arc3.setCenterX(centerX);
        arc3.setCenterY(centerY);
        arc3.setRadiusX(radius);
        arc3.setRadiusY(radius);
        arc3.setStartAngle(180);
        arc3.setLength(90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.PURPLE);
        arc3.setStrokeWidth(10);
        arc3.setType(ArcType.OPEN);
        Arc arc4 = new Arc();
        arc4.setCenterX(centerX);
        arc4.setCenterY(centerY);
        arc4.setRadiusX(radius);
        arc4.setRadiusY(radius);
        arc4.setStartAngle(270);
        arc4.setLength(90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.CYAN);
        arc4.setStrokeWidth(10);
        arc4.setType(ArcType.OPEN);
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
        root.getChildren().add(group);
        //rotation
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
