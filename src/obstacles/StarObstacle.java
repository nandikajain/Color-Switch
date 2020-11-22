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

public class StarObstacle extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
        Group group= new Group();
        //Change values here in order to get star obstacles with different parameters
        double centerX=250;
        double centerY=200;
        double length=100;
        //Star Obstacle Creation

        Line line1 = new Line();
        line1.setStartX(centerX);
        line1.setStartY(centerY);
        line1.setEndX(centerX);
        line1.setEndY(centerY-length);
        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(15);
        group.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(centerX);
        line2.setStartY(centerY);
        line2.setEndX(centerX- length);
        line2.setEndY(centerY);
        line2.setStroke(Color.PURPLE);
        line2.setStrokeWidth(15);
        group.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(centerX);
        line3.setStartY(centerY);
        line3.setEndX(centerX);
        line3.setEndY(centerY+length);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(15);
        group.getChildren().addAll(line3);
        Line line4 = new Line();
        line4.setStartX(centerX);
        line4.setStartY(centerY);
        line4.setEndX(centerX+length);
        line4.setEndY(centerY);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(15);
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
