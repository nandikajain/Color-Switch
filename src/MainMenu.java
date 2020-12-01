import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import obstacles.CircleObstacle;

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
      //Obstacle Creation
      CircleObstacle c1 = new CircleObstacle(250, 210, 60, false);
      Group group1 = c1.returnCircleObstacle();
      CircleObstacle c2 = new CircleObstacle(250, 210, 75, true);
      Group group2 = c2.returnCircleObstacle();
      CircleObstacle c3 = new CircleObstacle(250, 210, 90, false);
      Group group3 = c3.returnCircleObstacle();
      mainMenuPane.getChildren().add(group1);
      mainMenuPane.getChildren().add(group2);
      mainMenuPane.getChildren().add(group3);

      primaryStage.setScene(new Scene(mainMenuPane,500, 650));
      primaryStage.show();
    }
}
