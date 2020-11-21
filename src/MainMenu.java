import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
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

    MainMenu(){

    }

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
      //primaryStage.getIcons().add(new Image("/assets/logo.png")); -> DONT KNOW WHY THIS IS GIVING AN ERROR
      AnchorPane mainMenuPane= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//      Text t=FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//        primaryStage.setTitle("Color Switch");
//        Image image= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
//  mainMenuPane.getChildren().add(1, t);
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
        arc1.setStrokeWidth(10);
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
        arc2.setStrokeWidth(10);
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
        arc3.setStrokeWidth(10);
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
        arc4.setStrokeWidth(10);
        arc4.setType(ArcType.OPEN);
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
      Arc arc1b = new Arc();
      arc1b.setCenterX(250);
      arc1b.setCenterY(300);
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
      arc2b.setCenterY(300);
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
      arc3b.setCenterY(300);
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
      arc4b.setCenterY(300);
      arc4b.setRadiusX(75);
      arc4b.setRadiusY(75);
      arc4b.setStartAngle(270);
      arc4b.setLength(90);
      arc4b.setFill(Color.TRANSPARENT);
      arc4b.setStroke(Color.PURPLE);
      arc4b.setStrokeWidth(10);
      arc4b.setType(ArcType.OPEN);
      group.getChildren().addAll(arc1b);
      group.getChildren().addAll(arc2b);
      group.getChildren().addAll(arc3b);
      group.getChildren().addAll(arc4b);

        mainMenuPane.getChildren().setAll(group);

        primaryStage.setScene(new Scene(mainMenuPane,500, 750));
        primaryStage.show();

//      Group root = new Group();
//
//      Rectangle rect = new Rectangle(190, 395, 20, 5);
//      rect.setFill(Color.BLUE);
//      Rotate rot = new Rotate(0, 200, 200);
//      rect.getTransforms().add(rot);
//      root.getChildren().add(rect);
    }
}
