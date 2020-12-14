import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class Game extends Application implements Screen{
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    Ball ball;
    Text gameScore;
    Group group;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
    private Ball gameBall;
    public ArrayList<Obstacle> obstacles;
    public ArrayList<Star> starList;
    public ArrayList<ColorSwitcher> colorSwitchers;

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
        gameScore = new Text();
        gameScore.setText("0");
        gameScore.setX(21);
        gameScore.setY(53);
        gameScore.setFont((new Font(45)));



        obstacles.add(new CircleObstacle(250, 340, 60, false));
        obstacles.add(new TwoAdjacentStars(175, 100, 75));
        for(int i=0; i<obstacles.size(); i++)
        {
            Group g = obstacles.get(i).generateObstacle();
            gamePane.getChildren().add(g);

            Image image = new Image("file:./assets/game-star.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setX(240);
            imageView.setY(obstacles.get(i).getStarPositionY() -10);
            imageView.setFitHeight(20);
            imageView.setFitWidth(18);
            imageView.setPreserveRatio(true);

            Star s= new Star(obstacles.get(i).getStarPositionY(), imageView);
            starList.add(s);
            Group img = new Group(imageView);
            gamePane.getChildren().add(img);
        }

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
                    for(int j=0; j<starList.size(); j++)
                    {
                        if(starList.get(j).getLocation()>=ball.getLocationCollision() && !starList.get(j).isHasCollected())
                        {
                            starList.get(j).getStarImg().setImage(null);
                            starList.get(j).setHasCollected(true);
                        }
                    }
                    if(ball.getLocation()<300)
                    {
                        //move the contents of arraylist down
                        for(int i=0; i<obstacles.size(); i++)
                        {
                            obstacles.get(i).userMove();
                            obstacles.get(i).display();
                        }
                        for(int i=0; i<starList.size(); i++)
                        {
                            starList.get(i).userMove();
                            starList.get(i).display();
                        }
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
