import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;

import static java.lang.Integer.valueOf;


public class Game extends Application implements Screen{
    Pane playfield;
    AnimationTimer gameLoop;
    Scene scene;
    Ball ball;
    Text gameScore;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
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
        noOfStars=0;
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
        gameScore.setStroke(Color.WHITE);
        gameScore.setFill(Color.WHITE);
        gameScore.setY(53);
        gameScore.setFont((new Font(50)));
        gamePane.getChildren().add(gameScore);

        obstacles.add(new CircleObstacle(250, 340, 60, false));
        obstacles.add(new TwoAdjacentStars(175, 90, 75));
        obstacles.add(new SquareObstacle(250,-195,120, false));
        obstacles.add(new TwoEqualCircles(250,-475,70,82));
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

            Image image2= new Image("file:./assets/game-color-switcher.jpg");
            ImageView imageView1 = new ImageView(image2);
            imageView1.setX(240);
            imageView1.setY(obstacles.get(i).getColorSwitcherPositionY() -10);
            imageView1.setFitHeight(20);
            imageView1.setFitWidth(18);
            imageView1.setPreserveRatio(true);

            ColorSwitcher cs= new ColorSwitcher(obstacles.get(i).getColorSwitcherPositionY(), imageView1);
            colorSwitchers.add(cs);
            Group img2= new Group(imageView1);
            gamePane.getChildren().add(img2);

        }

        playfield = new Pane();
        playfield.setPrefSize(500,650);
        gamePane.getChildren().addAll(playfield);
        primaryStage.setScene(new Scene(gamePane, 500, 650));
        primaryStage.show();
        addBall();
//        gamePane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                try {
//                    ball.setup();
                   startGame();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }
    public void addBall(){
        Pane layer = playfield;
        double y = 500;
        ball = new Ball(layer, y, Color.RED);
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
                    boolean status=checkCollision();
                    if(status)
                    {
                        System.out.println("Collided");
                    }
                    collectStars();
                    switchColor();

                    if(ball.getLocation()<300)
                    {
                        moveContentsDown();
                        //move the contents of arraylist down
                    }
                }
                else{
                    ball.applyForce();
                    ball.move();
                    boolean status1 = checkCollision();
                    if (status1) {
                        System.out.println("Collided");
                    }
                }
                ball.checkBottom();
                boolean status2= ball.isBottom();
                if(status2)
                {
                    System.out.println("Collided");
                }

                ball.display();
                if(mouseClick && System.currentTimeMillis()-time>70) {
                    mouseClick = false;
                    clickedOnce = false;
                }
            }
        };
        gameLoop.start();
    }
    private void collectStars()
    {
        for(int j=0; j<starList.size(); j++)
        {
            if(starList.get(j).getLocation()>=ball.getLocationCollision() && !starList.get(j).isHasCollected())
            {
                starList.get(j).getStarImg().setImage(null);
                starList.get(j).setHasCollected(true);
                noOfStars++;
                int score= valueOf(gameScore.getText());
                score++;
                gameScore.setText(""+score);
            }
        }
    }
    private void moveContentsDown()
    {
        for(int i=0; i<obstacles.size(); i++)
        {
            obstacles.get(i).userMove();
            obstacles.get(i).display();
            starList.get(i).userMove();
            starList.get(i).display();
            colorSwitchers.get(i).userMove();
            colorSwitchers.get(i).display();
        }
    }
    private void switchColor()
    {
        for(int j=0; j<colorSwitchers.size(); j++)
        {
            if(colorSwitchers.get(j).getLocation()>=ball.getLocationCollision() && !colorSwitchers.get(j).isHasCollected())
            {
                colorSwitchers.get(j).getStarImg().setImage(null);
                colorSwitchers.get(j).setHasCollected(true);
                colorSwitchers.get(j).changeColor(ball);
            }
        }

    }
    private boolean checkCollision()
    {
        for(int i=0; i<obstacles.size(); i++)
        {
            ArrayList<Shape> list;
            Obstacle obs = obstacles.get(i);
            list= obs.getShapesList();
            for(int j=0; j<list.size(); j++)
            {
                if((Shape.intersect(list.get(j), ball.getCircle())).getBoundsInLocal().getWidth()!=-1)
                {
                    if(ball.getBallColor()!= list.get(j).getStroke())
                        return true;
                }

            }
        }
        return false;
    }

}
