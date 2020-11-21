import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Timer;

import java.util.ArrayList;

public class Game implements Screen{

    private int noOfStars;
    private Ball gameBall;
    private ArrayList<Obstacle> obstacleList;
    private ArrayList<Star> starList;

    private Timer clock;

    public Game (Game prevGame){

    }

    public Game(){

    }

    private void startGame(){

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
}
