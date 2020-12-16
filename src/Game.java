import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;

import static java.lang.Integer.valueOf;


public class Game extends Application implements Screen, Serializable {
    transient AnchorPane gamePane;
    transient Pane playfield;
    int temp;
    transient AnimationTimer gameLoop;
    int DynamicGeneration;
    boolean gameMoving;
    Ball ball;
    transient Text gameScore;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
    public ArrayList<Obstacle> obstacles;
    transient public ArrayList<Star> starList;
    transient public ArrayList<ColorSwitcher> colorSwitchers;

    transient Scene scene;
    transient Scene pausedScene;
    transient Ball pausedBall;

    transient Stage stage;

    boolean gamePause;

    transient private Timer clock;

    public Game (Game prevGame){

    }

    public Game(){
        obstacles = new ArrayList<Obstacle>();
        starList = new ArrayList<Star>();
        colorSwitchers = new ArrayList<ColorSwitcher>();
        noOfStars = 0;
        gameMoving = false;
        temp= 8;
        gamePause = false;
    }

    public void resumeGame(Stage stage) throws Exception {
        stage.setScene(pausedScene);
        stage.show();
        //addBall(true);
        mouseClick = false;
        clickedOnce = false;
        gamePause = false;
        gameLoop.start();
        //startGame();
    }

    private void pauseGame() throws Exception {
        gamePause = true;
        gameLoop.stop();
        //pausedBall = ball;
        //System.out.println("Ball at"+ball.getPositionY());
        //ball = null;
        pausedScene = scene;
        PauseMenu pm = new PauseMenu(this);
        pm.start(stage);
    }

    private void endGame() throws Exception {
        gamePause = true;
        pausedScene = scene;
        GameEndMenu gameEndMenu = new GameEndMenu(noOfStars,this);
        gameEndMenu.start(stage);
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
        gamePane = FXMLLoader.load(getClass().getResource("Game.fxml"));
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
        obstacles.add(new SquareObstacle(250,-235,120, false));
        obstacles.add(new TwoEqualCircles(250,-545,70,82));
        obstacles.add(new LineObstacle(-770));
        obstacles.add(new ThreeEqualCircles(250,-1050,70,82, 94 ));
        obstacles.add(new RhombusObstacle(250,-1400,120, false));
        obstacles.add(new TwoAdjacentCircles(175, -1700, 75,80));
        obstacles.add(new StarObstacle(330, -1950, 90, false));

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
        scene = new Scene(gamePane, 500, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
        addBall(false);
        startGame();
        stage = primaryStage;
    }

    public void addBall(boolean resuming){
        Pane layer = playfield;
        if(resuming){
            double y = pausedBall.getPositionY();
            ball = new Ball(layer,y,pausedBall.getBallColor());
        }
        else {
            double y = 500;
            ball = new Ball(layer, y, Color.RED);
        }
    }

    public void startGame() throws Exception{
        gameLoop = new AnimationTimer() {
            long time = System.currentTimeMillis();
            @Override
            public void handle(long l) {
                //if(!gamePause) {
                    /*playfield.setOnMouseClicked(e -> mouseClick = true);
                    scene.setOnKeyPressed(e->{
                        if(e.getCode() == KeyCode.P){
                            try {
                                pauseGame();
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                        }
                    });*/
                    scene.setOnKeyPressed(e->{
                        if(e.getCode()==KeyCode.SPACE){
                            mouseClick = true;
                        }
                        else if(e.getCode()==KeyCode.P){
                            try{
                                pauseGame();
                            } catch(Exception exception){
                                exception.printStackTrace();
                            }
                        }
                    });
                    playfield.setOnMouseClicked(e -> {
                        try{
                            pauseGame();
                        } catch(Exception exception){
                            exception.printStackTrace();
                        }
                    });
                    if (mouseClick) {
                        if (!clickedOnce) {
                            time = System.currentTimeMillis();
                            clickedOnce = true;
                        }
                        ball.userMove();
                        boolean status = checkCollision();
                        if (status) {
                            try {
                                //endGame();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Collided");
                        }
                        collectStars();
                        switchColor();

                        if (ball.getLocation() < 300) {
                            gameMoving = true;
                            moveContentsDown();
                            //move the contents of arraylist down
                        }
                    } else {
                        ball.applyForce();
                        ball.move();
                        boolean status1 = checkCollision();
                        if (status1) {
                            try {
                                //endGame();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            System.out.println("Collided");
                        }
                        ball.checkBottom();
                        if (gameMoving) {
                            boolean status2 = ball.isBottom();
                            if (status2) {
                                try {
                                  //  endGame();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Collided");
                            }
                        }

                    }
                    ball.display();
                    if (mouseClick && System.currentTimeMillis() - time > 70) {
                        mouseClick = false;
                        clickedOnce = false;
                    }
                //}
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
                DynamicGeneration++;
                int score= valueOf(gameScore.getText());
                score++;
                temp++;
                gameScore.setText(""+score);
            }

        }
    }
    private void moveContentsDown()
    {
        for(int i=0; i<obstacles.size(); i++)
        {
            if(obstacles.get(i).getCenterY()- ball.getLocationCollision() > 750)
            {    DynamicAddObstacles();
                i=i-1;
                continue;
            }
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

    private void HandleDynamicObstacle(Obstacle obs)
    {
        Group dynamicGroup = obs.generateObstacle();
        gamePane.getChildren().add(dynamicGroup);
        Image imageDyn = new Image("file:./assets/game-star.jpg");
        ImageView imageViewDyn = new ImageView(imageDyn);
        imageViewDyn.setX(240);
        imageViewDyn.setY(obs.getStarPositionY() -10);
        imageViewDyn.setFitHeight(20);
        imageViewDyn.setFitWidth(18);
        imageViewDyn.setPreserveRatio(true);

        Star sDyn= new Star(obs.getStarPositionY(), imageViewDyn);
        starList.remove(0);
        starList.add(sDyn);
        Group imgDyn = new Group(imageViewDyn);
        gamePane.getChildren().add(imgDyn);

        Image image2Dyn= new Image("file:./assets/game-color-switcher.jpg");
        ImageView imageView1Dyn = new ImageView(image2Dyn);
        imageView1Dyn.setX(240);
        imageView1Dyn.setY(obs.getColorSwitcherPositionY() -10);
        imageView1Dyn.setFitHeight(20);
        imageView1Dyn.setFitWidth(18);
        imageView1Dyn.setPreserveRatio(true);

        ColorSwitcher csDyn= new ColorSwitcher(obs.getColorSwitcherPositionY(), imageView1Dyn);
        colorSwitchers.remove(0);
        colorSwitchers.add(csDyn);
        Group img2Dyn= new Group(imageView1Dyn);
        gamePane.getChildren().add(img2Dyn);

    }


    private void DynamicAddObstacles()
    {
        double newCenter= obstacles.get(obstacles.size()-1).getCenterY();
        Obstacle obs;

        if(obstacles.get(0) instanceof CircleObstacle)
        {
            //CIRCLE -> Y last obstacle -=300, radius 60,
            obs= new CircleObstacle(250, newCenter-300,60, false );
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);

        }
        else if(obstacles.get(0) instanceof TwoAdjacentStars)
        {
            //TWO ADJACENT STAR-> Y last obstacle -=250, len-> 75, x cord-> 175
            obs= new TwoAdjacentStars(175, newCenter-250,75);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);
        }
        else if(obstacles.get(0) instanceof SquareObstacle)
        {
            //SQUARE OBSTACLE-> Y last obstacle -=325,len ->120
            obs= new SquareObstacle(250, newCenter- 325, 120, false);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);

        }
        else if(obstacles.get(0) instanceof TwoEqualCircles)
        {
            //TWO EQUAL CIRCLE -> Y last obstacle-=310, r1->70, r2->82
            obs= new TwoEqualCircles(250, newCenter- 310, 70, 82);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);

        }
        else if(obstacles.get(0) instanceof LineObstacle)
        {
            //LINE OBSTACLE -> Y last obstacle-=225
            obs= new LineObstacle(newCenter-225);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);
        }
        else  if(obstacles.get(0) instanceof  TwoEqualCircles)
        {
            //THREE EQUAL CIRCLES -> Y last obstacle -=280, r1-> 70, r2-> 82, r3-> 94
            obs = new ThreeEqualCircles(250, newCenter- 280, 70, 82, 94);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);
        }
        else if(obstacles.get(0) instanceof  RhombusObstacle)
        {
            //RHOMBUS OBSTACLE -> Y last obstacle-=350, len ->120
            obs= new RhombusObstacle(250, newCenter-350, 120, false);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);
        }
        else if (obstacles.get(0) instanceof  TwoAdjacentCircles)
        {
            //TWO ADJACENT CIRCLES -> Y last obstacle -=300, r1->75, r2-> 80, x cord-> 175
            obs= new TwoAdjacentCircles(175, newCenter-300,75, 80);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs);
        }
        else{
            //STAR OBSTACLE -> Y last obstacle -=250, x cord-> 330, len->90
            obs= new StarObstacle(330, newCenter-250, 90, false);
            obstacles.add(obs);
            obstacles.remove(0);
            obstacles.set(8, obs);
            HandleDynamicObstacle(obs);
        }

    }
}