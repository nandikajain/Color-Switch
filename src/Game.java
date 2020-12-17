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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.ArrayList;
import javafx.scene.paint.Color;



public class Game extends Application implements Screen, Serializable {
    private final static long serialVersionUID = 650054;
    transient AnchorPane gamePane;
    transient Pane playfield;
    transient AnimationTimer gameLoop;
    boolean gameMoving;
    Ball ball;
    boolean hasRevived;
    private transient Text gameScore;
    boolean mouseClick = false;
    boolean clickedOnce = false;
    private int noOfStars;
    public ArrayList<Obstacle> obstacles;
    int score;
    transient public ArrayList<Star> starList;
    transient public ArrayList<ColorSwitcher> colorSwitchers;

    transient Scene scene;
    transient Scene pausedScene;
    transient Ball pausedBall;

    transient Stage stage;

    boolean gamePause;

    transient private Timer clock;

    transient boolean savedGameContinue = false;
    transient double savedBallPositionY;
    transient Color savedBallColor;
    transient boolean zenMode = false;

    transient String jumpSoundFile = "sounds/jump.wav";
    transient Media jumpSound;
    transient MediaPlayer jumpSoundPlayer;

    transient String starSoundFile = "sounds/star.wav";
    transient Media starSound;
    transient MediaPlayer starSoundPlayer;

    transient String csSoundFile = "sounds/colorswitch.wav";
    transient Media csSound;
    transient MediaPlayer csSoundPlayer;

    transient String gsSoundFile = "sounds/dead.wav";
    transient Media gsSound;
    transient MediaPlayer gsSoundPlayer;

    transient String collisionSoundFile = "sounds/error.wav";
    transient Media collisionSound;
    transient MediaPlayer collisionSoundPlayer;

    transient String zenSoundFile = "sounds/zen.wav";
    transient Media zenSound;
    transient MediaPlayer zenSoundPlayer;

    public Game (Game prevGame){
        obstacles = new ArrayList<>(prevGame.obstacles);
        starList = new ArrayList<Star>();
        colorSwitchers = new ArrayList<>();
        noOfStars = prevGame.noOfStars;
        savedBallPositionY = prevGame.ball.positionY;
        savedBallColor = prevGame.ball.ballColor;
        gameMoving = false;
        gamePause = false;
        savedGameContinue = true;
    }

    public boolean isHasRevived() {
        return hasRevived;
    }

    public void setHasRevived(boolean hasRevived) {
        this.hasRevived = hasRevived;
    }

    public Game(){
        MainMenu.getInstance().setNoOfGamesPlayed(MainMenu.getInstance().getNoOfGamesPlayed()+1);
        obstacles = new ArrayList<Obstacle>();
        starList = new ArrayList<Star>();
        colorSwitchers = new ArrayList<ColorSwitcher>();
        noOfStars = 0;
        gameMoving = false;
        gamePause = false;
        hasRevived= false;
        score=0;
    }

    public void resumeGame(Stage stage,boolean extralife) throws Exception {
        stage.setScene(pausedScene);
        stage.show();
        if(extralife){
            if(score% 9 == 0)
            {
                ball.setPositionY(ball.getPositionY()+140);
            }
            else if(score% 9 == 1)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+155);
            }
            else if(score% 9 == 2)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+155);
            }
            else if(score% 9 == 3)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+175);
            }
            else if(score% 9 == 4)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+190);
            }
            else if(score% 9 == 5)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+50);
            }
            else if(score% 9 == 6)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+180);
            }
            else if(score% 9 == 7)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+205);
            }
            else if(score% 9 == 8)
            {
                //tested
                ball.setPositionY(ball.getPositionY()+155);
            }
            ball.display();
        }
        mouseClick = false;
        clickedOnce = false;
        gamePause = false;
        scene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.UP) {
                mouseClick = true;
                gameLoop.start();
            }
        });
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
        long time = System.currentTimeMillis();
        //while(System.currentTimeMillis()-time<1500);
        gamePause = true;
        gameLoop.stop();
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
        if(savedGameContinue){
            if(noOfStars<1){
                noOfStars-=1;
            }
            else {
                noOfStars -= 2;
            }
            gameScore.setText(String.valueOf(noOfStars));
        }
        else {
            gameScore.setText("0");
        }
        gameScore.setX(21);
        gameScore.setStroke(Color.WHITE);
        gameScore.setFill(Color.WHITE);
        gameScore.setY(53);
        gameScore.setFont((new Font(50)));
        gamePane.getChildren().add(gameScore);

        if(!savedGameContinue) {
            obstacles.add(new CircleObstacle(250, 340, 70, false, 4000));
            obstacles.add(new TwoAdjacentStars(175, 20, 75, 4000));
            obstacles.add(new SquareObstacle(250, -350, 120, false, 4000));
            obstacles.add(new TwoEqualCircles(250, -745, 70, 82, 4000));
            obstacles.add(new LineObstacle(-1050));
            obstacles.add(new ThreeEqualCircles(250, -1380, 70, 82, 94, 4000));
            obstacles.add(new RhombusObstacle(250, -1800, 140, false, 4000));
            obstacles.add(new TwoAdjacentCircles(170, -2200, 80, 80, 16000));
            obstacles.add(new StarObstacle(330, -2550, 90, false, 4000));

        }

        for(int i=0; i<obstacles.size(); i++)
        {
            Group g = obstacles.get(i).generateObstacle();
            gamePane.getChildren().add(g);
            Image image;
            ImageView imageView;
            if(i==4)
            {
                image = new Image("file:./assets/golden-star.PNG");
                imageView = new ImageView(image);
                imageView.setX(235);
                imageView.setY(obstacles.get(i).getStarPositionY() -10);
                imageView.setFitHeight(30);
                imageView.setFitWidth(28);
                imageView.setPreserveRatio(true);
            }
            else{
                image = new Image("file:./assets/game-star.jpg");
                imageView = new ImageView(image);
                imageView.setX(240);
                imageView.setY(obstacles.get(i).getStarPositionY() -10);
                imageView.setFitHeight(20);
                imageView.setFitWidth(18);
                imageView.setPreserveRatio(true);
            }


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
        addBall(savedGameContinue);
        startGame();
        stage = primaryStage;
    }

    public void addBall(boolean resuming){
        Pane layer = playfield;
        if(resuming){
            double y = savedBallPositionY;
            ball = new Ball(layer,y,savedBallColor);
        }
        else {
            double y = 500;
            ball = new Ball(layer, y, Color.RED);
        }
        ball.display();
    }

    public void startGame() throws Exception{
        gameLoop = new AnimationTimer() {
            long time = System.currentTimeMillis();
            @Override
            public void handle(long l) {
                scene.setOnKeyPressed(e->{
                    if(e.getCode()==KeyCode.UP){
                        mouseClick = true;
                    }
                    else if(e.getCode()==KeyCode.P){
                        try{
                            pauseGame();
                        } catch(Exception exception){
                            exception.printStackTrace();
                        }
                    }
                    else if(e.getCode()==KeyCode.Q){
                        zenMode = true;
                        zenSound = new Media(new File(zenSoundFile).toURI().toString());
                        zenSoundPlayer = new MediaPlayer(zenSound);
                        zenSoundPlayer.play();
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
                        if(!zenMode) {
                            jumpSound = new Media(new File(jumpSoundFile).toURI().toString());
                            jumpSoundPlayer = new MediaPlayer(jumpSound);
                            jumpSoundPlayer.play();
                        }
                    }
                    ball.userMove();
                    boolean status = checkCollision();
                    if (status && !zenMode) {
                        try {
                            collisionSound = new Media(new File(collisionSoundFile).toURI().toString());
                            collisionSoundPlayer = new MediaPlayer(collisionSound);
                            collisionSoundPlayer.play();
                            endGame();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //System.out.println("Collided");
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
                    if (status1 && !zenMode) {
                        try {
                            collisionSound = new Media(new File(collisionSoundFile).toURI().toString());
                            collisionSoundPlayer = new MediaPlayer(collisionSound);
                            collisionSoundPlayer.play();
                            endGame();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // System.out.println("Collided");
                    }
                    ball.checkBottom();
                    if (gameMoving) {
                        boolean status2 = ball.isBottom();
                        if (status2 && !zenMode) {
                            try {
                                collisionSound = new Media(new File(collisionSoundFile).toURI().toString());
                                collisionSoundPlayer = new MediaPlayer(collisionSound);
                                collisionSoundPlayer.play();
                                endGame();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //   System.out.println("Collided");
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
        scene.setOnKeyPressed(e->{
            if(e.getCode()==KeyCode.S){
                gameLoop.start();
            }
        });
    }
    private void collectStars()
    {
        for(int j=0; j<starList.size(); j++)
        {
            if(starList.get(j).getLocation()>=ball.getLocationCollision() && !starList.get(j).isHasCollected())
            {
                score++;
                if(starList.get(j).getImagePath().equals("file:./assets/golden-star.PNG"))
                {
                    if(!zenMode) {
                        gsSound = new Media(new File(gsSoundFile).toURI().toString());
                        gsSoundPlayer = new MediaPlayer(gsSound);
                        gsSoundPlayer.play();
                    }
                    starList.get(j).getStarImg().setImage(null);
                    starList.get(j).setHasCollected(true);
                    handleGoldenStars();
                }
                else{
                    if(!zenMode) {
                        starSound = new Media(new File(starSoundFile).toURI().toString());
                        starSoundPlayer = new MediaPlayer(starSound);
                        starSoundPlayer.play();
                    }
                    starList.get(j).getStarImg().setImage(null);
                    starList.get(j).setHasCollected(true);
                    noOfStars++;
                }
                gameScore.setText(""+noOfStars);
            }

        }
    }
    private void handleGoldenStars()
    {
        Random random = new Random();
        int int_random = random.nextInt(3)+2;
        noOfStars+=int_random;
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
                if(!zenMode) {
                    csSound = new Media(new File(csSoundFile).toURI().toString());
                    csSoundPlayer = new MediaPlayer(csSound);
                    csSoundPlayer.play();
                }
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

    private void HandleDynamicObstacle(Obstacle obs, boolean isGolden)
    {
        Group dynamicGroup = obs.generateObstacle();
        gamePane.getChildren().add(dynamicGroup);
        Image imageDyn;
        ImageView imageViewDyn;
        if(isGolden)
        {
            imageDyn = new Image("file:./assets/golden-star.PNG");
            imageViewDyn = new ImageView(imageDyn);
            imageViewDyn.setX(235);
            imageViewDyn.setY(obs.getStarPositionY() -10);
            imageViewDyn.setFitHeight(30);
            imageViewDyn.setFitWidth(28);
            imageViewDyn.setPreserveRatio(true);

        }
        else{
            imageDyn = new Image("file:./assets/game-star.jpg");
            imageViewDyn = new ImageView(imageDyn);
            imageViewDyn.setX(240);
            imageViewDyn.setY(obs.getStarPositionY() -10);
            imageViewDyn.setFitHeight(20);
            imageViewDyn.setFitWidth(18);
            imageViewDyn.setPreserveRatio(true);

        }


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
        Random ran= new Random();
        int randomInt= ran.nextInt(10);
        boolean temp=false;
        if(randomInt==9)
        {
            temp=true;

        }
        if(obstacles.get(0) instanceof CircleObstacle)
        {
            //CIRCLE -> Y last obstacle -=400, radius 60,
            double speed = ((CircleObstacle) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((CircleObstacle) obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((CircleObstacle) obstacles.get(0)).setSpeed(3000);
            }
            obs= new CircleObstacle(250, newCenter-400,70, false ,((CircleObstacle) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);

        }
        else if(obstacles.get(0) instanceof TwoAdjacentStars)
        {
            //TWO ADJACENT STAR-> Y last obstacle -=320, len-> 75, x cord-> 175
            double speed = ((TwoAdjacentStars) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((TwoAdjacentStars)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((TwoAdjacentStars) obstacles.get(0)).setSpeed(3000);
            }
            obs= new TwoAdjacentStars(175, newCenter-320,75, ((TwoAdjacentStars) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);
        }
        else if(obstacles.get(0) instanceof SquareObstacle)
        {
            //SQUARE OBSTACLE-> Y last obstacle -=370,len ->120
            double speed = ((SquareObstacle) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((SquareObstacle)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((SquareObstacle) obstacles.get(0)).setSpeed(3000);
            }
            obs= new SquareObstacle(250, newCenter- 370, 120, false, ((SquareObstacle) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);

        }
        else if(obstacles.get(0) instanceof TwoEqualCircles)
        {
            //TWO EQUAL CIRCLE -> Y last obstacle-=395, r1->70, r2->82
            double speed = ((TwoEqualCircles) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((TwoEqualCircles)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((TwoEqualCircles) obstacles.get(0)).setSpeed(3000);
            }
            obs= new TwoEqualCircles(250, newCenter- 395, 70, 82, ((TwoEqualCircles) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);

        }
        else if(obstacles.get(0) instanceof LineObstacle)
        {
            //LINE OBSTACLE -> Y last obstacle-=305
            obs= new LineObstacle(newCenter-305);
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);
        }
        else  if(obstacles.get(0) instanceof  ThreeEqualCircles)
        {
            //THREE EQUAL CIRCLES -> Y last obstacle -=330, r1-> 70, r2-> 82, r3-> 94
            double speed = ((ThreeEqualCircles) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((ThreeEqualCircles)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((ThreeEqualCircles) obstacles.get(0)).setSpeed(3000);
            }
            obs = new ThreeEqualCircles(250, newCenter- 330, 70, 82, 94, ((ThreeEqualCircles) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);
        }
        else if(obstacles.get(0) instanceof  RhombusObstacle)
        {
            //RHOMBUS OBSTACLE -> Y last obstacle-=420, len ->120
            double speed = ((RhombusObstacle) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((RhombusObstacle)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((RhombusObstacle) obstacles.get(0)).setSpeed(3000);
            }
            obs= new RhombusObstacle(250, newCenter-420, 140, false, ((RhombusObstacle) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);
        }
        else if (obstacles.get(0) instanceof  TwoAdjacentCircles)
        {
            double speed = ((TwoAdjacentCircles) obstacles.get(0)).getSpeed();
            if(speed>13000)
            {
                ((TwoAdjacentCircles)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=13000)
            {
                ((TwoAdjacentCircles) obstacles.get(0)).setSpeed(9000);
            }
            //TWO ADJACENT CIRCLES -> Y last obstacle -=400, r1->80, r2-> 80, x cord-> 175
            obs= new TwoAdjacentCircles(175, newCenter-400,80, 80, ((TwoAdjacentCircles) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            HandleDynamicObstacle(obs, temp);
        }
        else{
            //STAR OBSTACLE -> Y last obstacle -=350, x cord-> 330, len->90
            double speed = ((StarObstacle) obstacles.get(0)).getSpeed();
            if(speed>3000)
            {
                ((StarObstacle)obstacles.get(0)).setSpeed(speed- 200);
            }
            if(speed<=3000)
            {
                ((StarObstacle) obstacles.get(0)).setSpeed(3000);
            }
            obs= new StarObstacle(330, newCenter-350, 90, false, ((StarObstacle) obstacles.get(0)).getSpeed());
            obstacles.add(obs);
            obstacles.remove(0);
            obstacles.set(8, obs);
            HandleDynamicObstacle(obs, temp);
        }

    }
}