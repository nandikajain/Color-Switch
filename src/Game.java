import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.ArrayList;
import java.util.TimerTask;

public class Game extends Application implements Screen{
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    Ball ball;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
    private Ball gameBall;
    private ArrayList<Obstacle> obstacleList;
    private ArrayList<Star> starList;

    private Timer clock;

    public Game (Game prevGame){

    }

    public Game(){

    }

//    private void startGame(){
//
//    }

    private void setupGame(){

    }

    private void gameplay(){

    }

    private void pauseGame(){

    }

    private void hasCollided(){

    }

    public int getNoOfStars() {
        return noOfStars;
    }

    public void setNoOfStars(int noOfStars){
        this.noOfStars = noOfStars;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane gamePane = FXMLLoader.load(getClass().getResource("Game.fxml"));
        primaryStage.setTitle("Color Switch");
        double centerX=250;
        double centerY=340;
        double radius=80;

        //Circle Obstacle Creation
        Group group= new Group();
        Arc arc1 = new Arc();
        arc1.setCenterX(centerX);
        arc1.setCenterY(centerY);
        arc1.setRadiusX(radius);
        arc1.setRadiusY(radius);
        arc1.setStartAngle(0);
        arc1.setLength(90);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.YELLOW);
        arc1.setStrokeWidth(15);
        arc1.setType(ArcType.OPEN);
        Arc arc2 = new Arc();
        arc2.setCenterX(centerX);
        arc2.setCenterY(centerY);
        arc2.setRadiusX(radius);
        arc2.setRadiusY(radius);
        arc2.setStartAngle(90);
        arc2.setLength(90);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.RED);
        arc2.setStrokeWidth(15);
        arc2.setType(ArcType.OPEN);
        Arc arc3 = new Arc();
        arc3.setCenterX(centerX);
        arc3.setCenterY(centerY);
        arc3.setRadiusX(radius);
        arc3.setRadiusY(radius);
        arc3.setStartAngle(180);
        arc3.setLength(90);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setStroke(Color.PURPLE);
        arc3.setStrokeWidth(15);
        arc3.setType(ArcType.OPEN);
        Arc arc4 = new Arc();
        arc4.setCenterX(centerX);
        arc4.setCenterY(centerY);
        arc4.setRadiusX(radius);
        arc4.setRadiusY(radius);
        arc4.setStartAngle(270);
        arc4.setLength(90);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setStroke(Color.CYAN);
        arc4.setStrokeWidth(15);
        arc4.setType(ArcType.OPEN);
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
        gamePane.getChildren().add(group);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setNode(group);
        rotate.play();

        Group group2= new Group();
        //Change values here in order to get line obstacles with different parameters
        double centerYb=120;
        //Line Obstacle Creation
        Line line1 = new Line();
        line1.setStartX(0);
        line1.setStartY(centerYb);
        line1.setEndX(100);
        line1.setEndY(centerYb);
        line1.setStroke(Color.CYAN);
        line1.setStrokeWidth(15);
        group2.getChildren().addAll(line1);
        Line line2 = new Line();
        line2.setStartX(100);
        line2.setStartY(centerYb);
        line2.setEndX(200);
        line2.setEndY(centerYb);
        line2.setStroke(Color.PURPLE);
        line2.setStrokeWidth(15);
        group2.getChildren().addAll(line2);
        Line line3 = new Line();
        line3.setStartX(200);
        line3.setStartY(centerYb);
        line3.setEndX(300);
        line3.setEndY(centerYb);
        line3.setStroke(Color.YELLOW);
        line3.setStrokeWidth(15);
        group2.getChildren().addAll(line3);
        Line line4 = new Line();
        line4.setStartX(300);
        line4.setStartY(centerYb);
        line4.setEndX(400);
        line4.setEndY(centerYb);
        line4.setStroke(Color.RED);
        line4.setStrokeWidth(15);
        group2.getChildren().addAll(line4);
        Line line5 = new Line();
        line5.setStartX(400);
        line5.setStartY(centerYb);
        line5.setEndX(500);
        line5.setEndY(centerYb);
        line5.setStroke(Color.CYAN);
        line5.setStrokeWidth(15);
        group2.getChildren().addAll(line5);
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

        gamePane.getChildren().add(group2);
        playfield = new Pane();
        playfield.setPrefSize(500,650);
       gamePane.getChildren().addAll(playfield);
       // gamePane.setCenter(layerPane);

        primaryStage.setScene(new Scene(gamePane, 500, 650));
        primaryStage.show();
        addBall();
        startGame();

    }
    public void startGame() throws Exception{
        gameLoop = new AnimationTimer() {
            long time = System.currentTimeMillis();
            @Override
            public void handle(long l) {
                playfield.setOnMouseClicked(e -> mouseClick = true);
                if(mouseClick){
                    if(!clickedOnce) {
                        time = System.currentTimeMillis();
                        clickedOnce = true;
                    }
                    ball.userMove();
                }
                else{
                    ball.applyForce();
                    ball.move();
                }
                ball.checkBounds();
                ball.display();
                if(mouseClick && System.currentTimeMillis()-time>150) {
                    mouseClick = false;
                    clickedOnce = false;
                }
            }
        };
        gameLoop.start();
    }

    public void addBall(){
        Pane layer = playfield;
        double x = 250;
        double y = 100;
        common.PVector location = new common.PVector(x,y);
        common.PVector velocity = new common.PVector(0,0);
        common.PVector acceleration = new common.PVector(0,0);
        ball = new Ball(layer, location, velocity, acceleration);
    }
}
