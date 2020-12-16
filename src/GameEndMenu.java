import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class GameEndMenu extends Application {
    Text curScore;
    private static GameEndMenu gameEndMenu = null;
    Game prevGame;
    int finalStars;
    int totalStars;
    Stage stage;

    GameEndMenu(int noOfStars, Game curGame){
        prevGame = curGame;
        finalStars = noOfStars;
        totalStars = MainMenu.getInstance().getTotalStars();
        gameEndMenu = this;
    }

    public static GameEndMenu getInstance(){
        return gameEndMenu;
    }

    private void displayGameStats(){
        //GameEndMenuController.setLabels(finalStars,totalStars,420);
    }

    public void gameContinue() throws Exception {
        MainMenu.getInstance().setTotalStars(MainMenu.getInstance().getTotalStars()-100);
        prevGame.resumeGame(stage);
    }

    public void checkEligible(){
        if(totalStars>=100){
            System.out.println("Kyu darta hai tu yaar daaw laga");
        }
        else{
            //GameEndMenuController.playAgainButton.setVisible(false);
        }
    }

    public void restartGame() throws Exception {//basically start new game
        Game game = new Game();
        game.start(stage);
    }

    public void exitGame(){

    }

    /*public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane anchorPaneMenu = FXMLLoader.load(getClass().getResource("GameEndMenu.fxml"));
        primaryStage.setScene(new Scene(anchorPaneMenu, 500, 650));
        displayGameStats();
        checkEligible();
        curScore = new Text();
        curScore.setText(""+ finalStars);
        curScore.setX(240);
        curScore.setStroke(javafx.scene.paint.Color.WHITE);
        curScore.setFill(Color.WHITE);
        curScore.setLayoutY(260);
        curScore.setFont(Font.font ("Blissful Thinking", 45));
        anchorPaneMenu.getChildren().add(curScore);
        primaryStage.show();
    }
}


