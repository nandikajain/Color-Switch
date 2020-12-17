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

    int totalStars=200;
    int highScore=0;
    int noOfGamesPlayed=0;

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getNoOfGamesPlayed() {
        return noOfGamesPlayed;
    }

    public void setNoOfGamesPlayed(int noOfGamesPlayed) {
        this.noOfGamesPlayed = noOfGamesPlayed;
    }
    ArrayList<Game> savedGames;

    transient private static MainMenu mainMenu;

    transient String backgroundSoundFile = "sounds/letithappen.wav";
    transient Media backgroundSound;
    transient MediaPlayer backgroundSoundPlayer;

    transient boolean backgroundSoundPause;

    MainMenu(){
        mainMenu = this;
        savedGames = new ArrayList<>();
    }

    private void startNewGame(){

    }

    private void exit(){

    }

    public ArrayList<Game> viewSavedGames(){
        return savedGames;
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
        ThreeEqualCircles c1= new ThreeEqualCircles(250, 210, 60,71, 82,4000);
        Group group = c1.generateObstacle();
        mainMenuPane.getChildren().add(group);
        primaryStage.setScene(new Scene(mainMenuPane,500, 650));
        backgroundSound = new Media(new File(backgroundSoundFile).toURI().toString());
        backgroundSoundPlayer = new MediaPlayer(backgroundSound);
        backgroundSoundPlayer.setVolume(0.05);
        backgroundSoundPlayer.play();
        backgroundSoundPause = false;
        primaryStage.show();
        //saveState();
        //System.out.println(savedGames.size());
        loadState();
        //System.out.println(savedGames.size());
        //System.out.println(savedGames.get(0).getNoOfStars());
        //System.out.println(savedGames.get(1).getNoOfStars());
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

    public void backgroundSoundStop(){
        backgroundSoundPlayer.pause();
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
            this.savedGames = new ArrayList<>(x.savedGames);
            this.setHighScore(x.getHighScore());
            this.setNoOfGamesPlayed(x.getNoOfGamesPlayed());
            //this.setTotalStars(x.getTotalStars());
            //System.out.println(x.getTotalStars());
        } catch (IOException e) {
            saveState();
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found F");
            e.printStackTrace();
        }
    }
}
