import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

//import obstacles.ThreeEqualCircles;

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
        ThreeEqualCircles c1= new ThreeEqualCircles(250, 210, 60,71, 82);
        Group group = c1.generateObstacle();
        mainMenuPane.getChildren().add(group);
        primaryStage.setScene(new Scene(mainMenuPane,500, 650));
        primaryStage.show();
    }
}
