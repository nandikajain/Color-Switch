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

import java.io.*;
import java.util.ArrayList;

//Will have to make 1) Main Java file 2) fxml file linked to scene builder 3) Controller file for event listeners for each page

public class MainMenu extends Application implements Serializable {

    private final static long serialVersionUID = 65621354;

    int totalStars = 5;
    transient ArrayList<Game> savedGames;

    transient private static MainMenu mainMenu;

    transient String backgroundSoundFile = "sounds/letithappen.wav";
    transient Media backgroundSound;
    transient MediaPlayer backgroundSoundPlayer;

    transient boolean backgroundSoundPause;

    MainMenu(){
        mainMenu = this;
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

    public void setTotalStars(int _totalStars) {
        totalStars = _totalStars;
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
        backgroundSoundPlayer.setVolume(0.2);
        backgroundSoundPlayer.play();
        backgroundSoundPause = false;
        primaryStage.show();
        /* This serialization is working fine
        loadState();
        System.out.println(getTotalStars());
        setTotalStars(getTotalStars()+1);
        saveState();
         */
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

    public void saveState(){
        //System.out.println(getTotalStars());
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("main.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(this);
            out.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in main.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadState(){
        try{
            FileInputStream fileInputStream = new FileInputStream("main.txt");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            MainMenu x = (MainMenu) in.readObject();
            in.close();
            fileInputStream.close();
            this.setTotalStars(x.getTotalStars());
            //System.out.println(x.getTotalStars());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found F");
            e.printStackTrace();
        }
    }
}
