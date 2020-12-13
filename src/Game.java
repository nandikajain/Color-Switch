import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import obstacles.CircleObstacle;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;


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

        //Circle Obstacle Creation
        CircleObstacle c1 = new CircleObstacle(250, 340, 80, false);
//        Group group = c1.returnCircleObstacle();
       // gamePane.getChildren().add(group);

        //Line Obstacle Creation
//        LineObstacle l1= new LineObstacle(120);
//        Group group2= l1.returnLineObstacle();

      //  gamePane.getChildren().add(group2);
        playfield = new Pane();
        playfield.setPrefSize(500,650);
       gamePane.getChildren().addAll(playfield);
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
                ball.checkBottom();
                ball.display();
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
        double y = 100;
        ball = new Ball(layer, y, Color.RED);
    }
}
