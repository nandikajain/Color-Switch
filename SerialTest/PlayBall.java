import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import common.PVector;

import java.io.*;

public class PlayBall extends Application implements Serializable{

    transient Pane playfield;
    transient AnimationTimer gameLoop;
    transient Scene scene;
    Ball ball;
    Obs obstacle;
    transient Stage stage;
    boolean mouseClick = false;
    boolean clickedOnce = false;

    String jumpSoundFile = "sounds/jump.wav";
    Media jumpSound;
    MediaPlayer jumpSoundPlayer;

    String starSoundFile = "sounds/star.wav";
    Media starSound;
    MediaPlayer starSoundPlayer;

    public PlayBall(){

    }
    /*public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void start(Stage primaryStage) throws InterruptedException{
        stage = primaryStage;
        BorderPane root = new BorderPane();
        StackPane layerPane = new StackPane();
        playfield = new Pane();
        playfield.setPrefSize(800,600);
        /*Button saveBtn = new Button("Save");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                saveState();
            }
        });*/
        Button loadBtn = new Button("Load");
        loadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadState();
            }
        });
        layerPane.getChildren().addAll(loadBtn);
        layerPane.getChildren().addAll(playfield);
        root.setCenter(layerPane);
        scene = new Scene(root,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
        addBall();
        addObs();
        startGame();
    }

    public void startGame() throws InterruptedException{
        gameLoop = new AnimationTimer() {
            long time = System.currentTimeMillis();
            @Override
            public void handle(long l) {
                playfield.setOnMouseClicked(e -> mouseClick = true);
                /*playfield.setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode() == KeyCode.SPACE) {
                        mouseClick = true;
                    }
                });*/
                if(mouseClick){
                    if(!clickedOnce) {
                        time = System.currentTimeMillis();
                        clickedOnce = true;
                        jumpSound = new Media(new File(jumpSoundFile).toURI().toString());
                        jumpSoundPlayer = new MediaPlayer(jumpSound);
                        jumpSoundPlayer.play();
                    }
                    ball.userMove();
                    if(ball.getLocation()<300) {
                        obstacle.userMove();
                    }
                    //Collision logic, yeh pretty smooth hai
                    if(ball.getLocationCollision()-obstacle.getLocation()<3 && ball.getLocationCollision()-obstacle.getLocation()>-3){
                        System.out.println("Collided "+ball.getLocationCollision()+" "+obstacle.getLocation());
                        starSound = new Media(new File(starSoundFile).toURI().toString());
                        starSoundPlayer = new MediaPlayer(starSound);
                        starSoundPlayer.play();
                    }
                }
                else{
                    ball.applyForce();
                    ball.move();
                }
                ball.checkBounds();
                ball.display();
                obstacle.display();
                if(mouseClick && System.currentTimeMillis()-time>70) {
                    mouseClick = false;
                    clickedOnce = false;
                }
            }
        };
        gameLoop.start();
    }

    public void addBall(){
        Pane layer = playfield;
        double x = 400;
        double y = 200;
        PVector location = new PVector(x,y);
        PVector velocity = new PVector(0,0);
        PVector acceleration = new PVector(0,0);
        ball = new Ball(layer, location, velocity, acceleration);
    }

    public void addObs(){
        Pane layer = playfield;
        double x = 400;
        double y = 0;
        PVector location = new PVector(x,y);
        PVector velocity = new PVector(0,0);
        obstacle = new Obs(layer,location,velocity);
    }

    public void saveState(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("save.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(this);
            out.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in save.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadState(){
        try{
            FileInputStream fileInputStream = new FileInputStream("save.txt");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            PlayBall x = (PlayBall) in.readObject();
            in.close();
            fileInputStream.close();
            x.start(stage);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found F");
            e.printStackTrace();
        }
    }

}