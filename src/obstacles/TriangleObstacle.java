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

public class TriangleObstacle extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
        Group group= new Group();
        //Change values here in order to get star obstacles with different parameters
        //coordinates of the bottom left corner are given and the length of the side
        //colors are also passed, have to make sure that one of the side includes the color of the ball
        //Colors => CYAN, PURPLE, YELLOW, RED
        Color c1= Color.RED;
        Color c2=Color.PURPLE;
        Color c3= Color.YELLOW;
        double Px=180;
        double Py=250;
        double length=150;

        //Triangle Obstacle Creation

        Line line1 = new Line();
        line1.setStartX(Px);
        line1.setStartY(Py);
        line1.setEndX(Px+length);
        line1.setEndY(Py);
        line1.setStroke(c1);
        line1.setStrokeWidth(10);
        group.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(Px+length);
        line2.setStartY(Py);
        // ((Math.sqrt(3))/2)*length
        line2.setEndX(Px + (length/2));
        line2.setEndY(Py - (((Math.sqrt(3))/2)*length));
        line2.setStroke(c2);
        line2.setStrokeWidth(10);
        group.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(Px+ (length/2));
        line3.setStartY(Py - (((Math.sqrt(3))/2)*length));
        line3.setEndX(Px);
        line3.setEndY(Py);
        line3.setStroke(c3);
        line3.setStrokeWidth(10);
        group.getChildren().addAll(line3);
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
