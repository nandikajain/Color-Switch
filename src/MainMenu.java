import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.util.ArrayList;

//Will have to make 1) Main Java file 2) fxml file linked to scene builder 3) Controller file for event listeners for each page

public class MainMenu extends Application {

    int totalStars;
    ArrayList<Game> savedGames;
//
//    MainMenu(){
//
//    }
//
    private void startNewGame(){

    }

    private void exit(){

    }

    private void viewSavedGames(){

    }

    public int getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
      primaryStage.setTitle("Color Switch");
      AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));


      //__________________________________ARCS
      Group group = new Group();
      Group group2 = new Group();

      Arc arc1 = new Arc();
      arc1.setCenterX(250);
      arc1.setCenterY(210);
      arc1.setRadiusX(60);
      arc1.setRadiusY(60);
      arc1.setStartAngle(0);
      arc1.setLength(90);
      arc1.setFill(Color.TRANSPARENT);
      arc1.setStroke(Color.YELLOW);
      arc1.setStrokeWidth(10);
      arc1.setType(ArcType.OPEN);
      Arc arc2 = new Arc();
      arc2.setCenterX(250);
      arc2.setCenterY(210);
      arc2.setRadiusX(60);
      arc2.setRadiusY(60);
      arc2.setStartAngle(90);
      arc2.setLength(90);
      arc2.setFill(Color.TRANSPARENT);
      arc2.setStroke(Color.RED);
      arc2.setStrokeWidth(10);
      arc2.setType(ArcType.OPEN);
      Arc arc3 = new Arc();
      arc3.setCenterX(250);
      arc3.setCenterY(210);
      arc3.setRadiusX(60);
      arc3.setRadiusY(60);
      arc3.setStartAngle(180);
      arc3.setLength(90);
      arc3.setFill(Color.TRANSPARENT);
      arc3.setStroke(Color.PURPLE);
      arc3.setStrokeWidth(10);
      arc3.setType(ArcType.OPEN);
      Arc arc4 = new Arc();
      arc4.setCenterX(250);
      arc4.setCenterY(210);
      arc4.setRadiusX(60);
      arc4.setRadiusY(60);
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
      Arc arc1b = new Arc();
      arc1b.setCenterX(250);
      arc1b.setCenterY(210);
      arc1b.setRadiusX(75);
      arc1b.setRadiusY(75);
      arc1b.setStartAngle(0);
      arc1b.setLength(90);
      arc1b.setFill(Color.TRANSPARENT);
      arc1b.setStroke(Color.CYAN);
      arc1b.setStrokeWidth(10);
      arc1b.setType(ArcType.OPEN);
      Arc arc2b = new Arc();
      arc2b.setCenterX(250);
      arc2b.setCenterY(210);
      arc2b.setRadiusX(75);
      arc2b.setRadiusY(75);
      arc2b.setStartAngle(90);
      arc2b.setLength(90);
      arc2b.setFill(Color.TRANSPARENT);
      arc2b.setStroke(Color.YELLOW);
      arc2b.setStrokeWidth(10);
      arc2b.setType(ArcType.OPEN);
      Arc arc3b = new Arc();
      arc3b.setCenterX(250);
      arc3b.setCenterY(210);
      arc3b.setRadiusX(75);
      arc3b.setRadiusY(75);
      arc3b.setStartAngle(180);
      arc3b.setLength(90);
      arc3b.setFill(Color.TRANSPARENT);
      arc3b.setStroke(Color.RED);
      arc3b.setStrokeWidth(10);
      arc3b.setType(ArcType.OPEN);
      Arc arc4b = new Arc();
      arc4b.setCenterX(250);
      arc4b.setCenterY(210);
      arc4b.setRadiusX(75);
      arc4b.setRadiusY(75);
      arc4b.setStartAngle(270);
      arc4b.setLength(90);
      arc4b.setFill(Color.TRANSPARENT);
      arc4b.setStroke(Color.PURPLE);
      arc4b.setStrokeWidth(10);
      arc4b.setType(ArcType.OPEN);
      group2.getChildren().addAll(arc1b);
      group2.getChildren().addAll(arc2b);
      group2.getChildren().addAll(arc3b);
      group2.getChildren().addAll(arc4b);
      Arc arc1c = new Arc();
      arc1c.setCenterX(250);
      arc1c.setCenterY(210);
      arc1c.setRadiusX(90);
      arc1c.setRadiusY(90);
      arc1c.setStartAngle(0);
      arc1c.setLength(90);
      arc1c.setFill(Color.TRANSPARENT);
      arc1c.setStroke(Color.YELLOW);
      arc1c.setStrokeWidth(10);
      arc1c.setType(ArcType.OPEN);
      Arc arc2c = new Arc();
      arc2c.setCenterX(250);
      arc2c.setCenterY(210);
      arc2c.setRadiusX(90);
      arc2c.setRadiusY(90);
      arc2c.setStartAngle(90);
      arc2c.setLength(90);
      arc2c.setFill(Color.TRANSPARENT);
      arc2c.setStroke(Color.RED);
      arc2c.setStrokeWidth(10);
      arc2c.setType(ArcType.OPEN);
      Arc arc3c = new Arc();
      arc3c.setCenterX(250);
      arc3c.setCenterY(210);
      arc3c.setRadiusX(90);
      arc3c.setRadiusY(90);
      arc3c.setStartAngle(180);
      arc3c.setLength(90);
      arc3c.setFill(Color.TRANSPARENT);
      arc3c.setStroke(Color.PURPLE);
      arc3c.setStrokeWidth(10);
      arc3c.setType(ArcType.OPEN);
      Arc arc4c = new Arc();
      arc4c.setCenterX(250);
      arc4c.setCenterY(210);
      arc4c.setRadiusX(90);
      arc4c.setRadiusY(90);
      arc4c.setStartAngle(270);
      arc4c.setLength(90);
      arc4c.setFill(Color.TRANSPARENT);
      arc4c.setStroke(Color.CYAN);
      arc4c.setStrokeWidth(10);
      arc4c.setType(ArcType.OPEN);
      group.getChildren().addAll(arc1c);
      group.getChildren().addAll(arc2c);
      group.getChildren().addAll(arc3c);
      group.getChildren().addAll(arc4c);
      //___________________________________ARCS END

      RotateTransition rotate = new RotateTransition();
      rotate.setAxis(Rotate.Z_AXIS);
      rotate.setByAngle(360);
      rotate.setCycleCount(50000);
      rotate.setDuration(Duration.millis(3000));
      rotate.setNode(group);
      rotate.setInterpolator(Interpolator.LINEAR);
      rotate.play();

      RotateTransition rotate2 = new RotateTransition();
      rotate2.setAxis(Rotate.Z_AXIS);
      rotate2.setByAngle(360);
      rotate2.setCycleCount(50000);
      rotate2.setAutoReverse(true);
      rotate2.setDuration(Duration.millis(3000));
      rotate2.setNode(group2);
      rotate.setInterpolator(Interpolator.LINEAR);
      rotate2.play();


      mainMenuPane.getChildren().add(group);
      mainMenuPane.getChildren().add(group2);

      primaryStage.setScene(new Scene(mainMenuPane,500, 650));
      primaryStage.show();
    }
}
