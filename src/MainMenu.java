import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

//Will have to make 1) Main Java file 2) fxml file linked to scene builder 3) Controller file for event listeners for each page

public class MainMenu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        //primaryStage.getIcons().add(new Image("/assets/logo.png")); -> DONT KNOW WHY THIS IS GIVING AN ERROR
        primaryStage.setTitle("Color Switch");

        Group group = new Group();
        Arc arc1 = new Arc();
        arc1.setCenterX(250);
        arc1.setCenterY(300);
        arc1.setRadiusX(60);
        arc1.setRadiusY(60);
        arc1.setStartAngle(0);
        arc1.setLength(90);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.YELLOW);
        arc1.setStrokeWidth(5);
        arc1.setType(ArcType.OPEN);
        Arc arc2 = new Arc();
        arc2.setCenterX(250);
        arc2.setCenterY(300);
        arc2.setRadiusX(60);
        arc2.setRadiusY(60);
        arc2.setStartAngle(90);
        arc2.setLength(90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(5);
        arc2.setType(ArcType.OPEN);
        Arc arc3 = new Arc();
        arc3.setCenterX(250);
        arc3.setCenterY(300);
        arc3.setRadiusX(60);
        arc3.setRadiusY(60);
        arc3.setStartAngle(180);
        arc3.setLength(90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.PURPLE);
        arc3.setStrokeWidth(5);
        arc3.setType(ArcType.OPEN);
        Arc arc4 = new Arc();
        arc4.setCenterX(250);
        arc4.setCenterY(300);
        arc4.setRadiusX(60);
        arc4.setRadiusY(60);
        arc4.setStartAngle(270);
        arc4.setLength(90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.CYAN);
        arc4.setStrokeWidth(5);
        arc4.setType(ArcType.OPEN);
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
//        RotateTransition rt1= new RotateTransition(Duration.seconds(10), arc1);
//        RotateTransition rt2= new RotateTransition(Duration.INDEFINITE, arc2);
//        RotateTransition rt3= new RotateTransition(Duration.INDEFINITE, arc3);
//        RotateTransition rt4= new RotateTransition(Duration.INDEFINITE, arc4);
//        rt1.setFromAngle(0);
//        rt1.setFromAngle(180);
//        rt2.setByAngle(360);
//        rt3.setByAngle(360);
//        rt4.setByAngle(360);
//        rt1.setCycleCount(1000);
//        rt2.setCycleCount(3);
//        rt3.setCycleCount(3);
//        rt4.setCycleCount(3);
//        rt1.setDelay(Duration.seconds(0));
//        rt1.setRate(3);
//        rt1.play();




        //  root.getChildren().addAll(group);
        primaryStage.setScene(new Scene(group,500, 750));
        primaryStage.show();
    }
}
