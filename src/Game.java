import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class Game extends Application implements Screen{
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    Ball ball;
    Group group;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
    private Ball gameBall;
    public ArrayList<Obstacle> obstacles;
    public ArrayList<Star> starList;
    public ArrayList<ColorSwitcher> colorSwitchers;
    Obstacle c1;

    private Timer clock;

    public Game (Game prevGame){

    }

    public Game(){
        obstacles = new ArrayList<Obstacle>();
        starList = new ArrayList<Star>();
        colorSwitchers= new ArrayList<ColorSwitcher>();
    }

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
        c1 = new CircleObstacle(250, 340, 80, false);
        group = c1.generateObstacle();
        gamePane.getChildren().add(group);


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
                    if(ball.getLocation()<300)
                    {
                        //move the contents of arraylist down
                        c1.userMove();
                        c1.display();

                    }
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
