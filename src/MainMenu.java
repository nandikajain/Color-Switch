import javafx.scene.media.MediaPlayer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

//import obstacles.ThreeEqualCircles;

import java.io.File;
import java.util.ArrayList;

//Will have to make 1) Main Java file 2) fxml file linked to scene builder 3) Controller file for event listeners for each page

public class MainMenu extends Application {

    static int totalStars;
    ArrayList<Game> savedGames;

    private static MainMenu mainMenu;

    String backgroundSoundFile = "sounds/letithappen.wav";
    Media backgroundSound;
    MediaPlayer backgroundSoundPlayer;

    boolean backgroundSoundPause;

    MainMenu(){
        mainMenu = this;
    }

    /*public static MainMenu getMenuInstance(){
        return this;
    }*/

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

    /*public static void main(String[] args) {
        launch(args);
    }*/

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
        backgroundSound = new Media(new File(backgroundSoundFile).toURI().toString());
        backgroundSoundPlayer = new MediaPlayer(backgroundSound);
        backgroundSoundPlayer.play();
        backgroundSoundPause = false;
        primaryStage.show();
    }

    public boolean backgroundSoundPause(){
        if(!backgroundSoundPause) {
            backgroundSoundPlayer.pause();
            backgroundSoundPause = true;
            return true;
        }
        else{
            backgroundSoundPlayer.play();
            backgroundSoundPause = false;
            return false;
        }
    }

    public static MainMenu getInstance(){
        return mainMenu;
    }
}
