package obstacles;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
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

import java.util.Timer;
import java.util.TimerTask;

public class LineObstacle extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
        Group group= new Group();
        //Change values here in order to get line obstacles with different parameters
        double centerY=300;
        //Line Obstacle Creation
        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(centerY);
        line1.setEndX(100);
        line1.setEndY(centerY);
        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(15);
        group.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(100);
        line2.setStartY(centerY);
        line2.setEndX(200);
        line2.setEndY(centerY);
        line2.setStroke(Color.PURPLE);
        line2.setStrokeWidth(15);
        group.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(200);
        line3.setStartY(centerY);
        line3.setEndX(300);
        line3.setEndY(centerY);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(15);
        group.getChildren().addAll(line3);
        Line line4 = new Line();
        line4.setStartX(300);
        line4.setStartY(centerY);
        line4.setEndX(400);
        line4.setEndY(centerY);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(15);
        group.getChildren().addAll(line4);
        Line line5 = new Line();
        line5.setStartX(400);
        line5.setStartY(centerY);
        line5.setEndX(500);
        line5.setEndY(centerY);
        line5.setStroke(Color.CYAN);
        line5.setStrokeWidth(15);
        group.getChildren().addAll(line5);
        //Color.CYAN,Color.PURPLE,Color.YELLOW,Color.RED;
        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        if(line1.getStroke()== Color.CYAN)
                            line1.setStroke(Color.RED);
                        else if(line1.getStroke()==Color.PURPLE)
                            line1.setStroke(Color.CYAN);
                        else if(line1.getStroke()== Color.YELLOW)
                            line1.setStroke(Color.PURPLE);
                        else if(line1.getStroke()==Color.RED)
                            line1.setStroke(Color.YELLOW);
                        if(line2.getStroke()== Color.CYAN)
                            line2.setStroke(Color.RED);
                        else if(line2.getStroke()==Color.PURPLE)
                            line2.setStroke(Color.CYAN);
                        else if(line2.getStroke()== Color.YELLOW)
                            line2.setStroke(Color.PURPLE);
                        else if(line2.getStroke()==Color.RED)
                            line2.setStroke(Color.YELLOW);
                        if(line3.getStroke()== Color.CYAN)
                            line3.setStroke(Color.RED);
                        else if(line3.getStroke()==Color.PURPLE)
                            line3.setStroke(Color.CYAN);
                        else if(line3.getStroke()== Color.YELLOW)
                            line3.setStroke(Color.PURPLE);
                        else if(line3.getStroke()==Color.RED)
                            line3.setStroke(Color.YELLOW);
                        if(line4.getStroke()== Color.CYAN)
                            line4.setStroke(Color.RED);
                        else if(line4.getStroke()==Color.PURPLE)
                            line4.setStroke(Color.CYAN);
                        else if(line4.getStroke()== Color.YELLOW)
                            line4.setStroke(Color.PURPLE);
                        else if(line4.getStroke()==Color.RED)
                            line4.setStroke(Color.YELLOW);
                        if(line5.getStroke()== Color.CYAN)
                            line5.setStroke(Color.RED);
                        else if(line5.getStroke()==Color.PURPLE)
                            line5.setStroke(Color.CYAN);
                        else if(line5.getStroke()== Color.YELLOW)
                            line5.setStroke(Color.PURPLE);
                        else if(line5.getStroke()==Color.RED)
                            line5.setStroke(Color.YELLOW);

                    }
                }, 0, 1000);

        root.getChildren().add(group);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
