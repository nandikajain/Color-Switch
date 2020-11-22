package obstacles;

import javafx.animation.Interpolator;
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
        //Change values here in order to get star obstacles with different parameters
        //coordinates of the top left corner are given and the length of the side
        double Px=180;
        double Py=150;
        double length=100;

        //Square Obstacle Creation

        Line line1 = new Line();
        line1.setStartX(Px);
        line1.setStartY(Py);
        line1.setEndX(Px+length);
        line1.setEndY(Py);
        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(10);
        group.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(Px);
        line2.setStartY(Py);
        line2.setEndX(Px);
        line2.setEndY(Py+length);
        line2.setStroke(Color.PURPLE);
        line2.setStrokeWidth(10);
        group.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(Px);
        line3.setStartY(Py+length);
        line3.setEndX(Px+length);
        line3.setEndY(Py+length);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(10);
        group.getChildren().addAll(line3);
        Line line4 = new Line();
        line4.setStartX(Px+length);
        line4.setStartY(Py);
        line4.setEndX(Px+length);
        line4.setEndY(Py+length);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(10);
        group.getChildren().addAll(line4);
        root.getChildren().add(group);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(group);
        rotate.play();

        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
