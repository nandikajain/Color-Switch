import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameEndMenu extends Application {
    Text curScore;
    Text highScoreText;
    Text totalStarsText;

    private static GameEndMenu gameEndMenu = null;
    Game prevGame;
    int finalStars;
    int totalStars;
    Stage stage;

    GameEndMenu(int noOfStars, Game curGame){
        prevGame = curGame;
        finalStars = noOfStars;
        MainMenu.getInstance().setTotalStars(finalStars+ MainMenu.getInstance().getTotalStars());
        totalStars = MainMenu.getInstance().getTotalStars();
        gameEndMenu = this;
    }

    public static GameEndMenu getInstance(){
        return gameEndMenu;
    }

    public void gameContinue() throws Exception {
    //    MainMenu.getInstance().setTotalStars(MainMenu.getInstance().getTotalStars()-100);
        prevGame.resumeGame(stage,true);
    }

    public boolean checkEligible(){
        System.out.println("Total stars"+ totalStars);
        if(totalStars>=50)
        {
            if(prevGame.isHasRevived())
            {
                return false;
            }
            prevGame.setHasRevived(true);
            MainMenu.getInstance().setTotalStars(totalStars - 50);
            return true;
        }

        else{
            return false;
        }
    }

    public void restartGame() throws Exception {//basically start new game
        Game game = new Game();
        game.start(stage);
    }

    public void exitGame(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane anchorPaneMenu = FXMLLoader.load(getClass().getResource("GameEndMenu.fxml"));
        primaryStage.setScene(new Scene(anchorPaneMenu, 500, 650));
        curScore = new Text();
        curScore.setText(""+ finalStars);
        curScore.setX(235);
        curScore.setStroke(javafx.scene.paint.Color.WHITE);
        curScore.setFill(Color.WHITE);
        curScore.setLayoutY(235);
        curScore.setFont(Font.font ("Blissful Thinking", 45));
        anchorPaneMenu.getChildren().add(curScore);

        totalStarsText = new Text();
        totalStarsText.setText(""+ totalStars);
        //System.out.println("Total stars: "+ totalStars);
        totalStarsText.setX(405);
        totalStarsText.setStroke(javafx.scene.paint.Color.WHITE);
        totalStarsText.setFill(Color.WHITE);
        totalStarsText.setLayoutY(105);
        totalStarsText.setFont(Font.font ("Blissful Thinking", 31));
        anchorPaneMenu.getChildren().add(totalStarsText);

        highScoreText = new Text();
        if(MainMenu.getInstance().getHighScore() >= finalStars)
            highScoreText.setText(""+ MainMenu.getInstance().getHighScore());
        else{
            highScoreText.setText(""+ finalStars);
            MainMenu.getInstance().setHighScore(finalStars);
        }
        highScoreText.setX(230);
        highScoreText.setStroke(javafx.scene.paint.Color.WHITE);
        highScoreText.setFill(Color.WHITE);
        highScoreText.setLayoutY(347);
        highScoreText.setFont(Font.font ("Blissful Thinking", 45));
        anchorPaneMenu.getChildren().add(highScoreText);
        MainMenu.getInstance().saveState();
        primaryStage.show();
    }
}


