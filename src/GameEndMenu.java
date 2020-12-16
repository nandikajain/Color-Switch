import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameEndMenu extends Application {

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
        GameEndMenuController.setLabels(finalStars,totalStars,420);
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
            GameEndMenuController.playAgainButton.setVisible(false);
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
        GridPane gridPaneMenu = FXMLLoader.load(getClass().getResource("GameEndMenu.fxml"));
        primaryStage.setScene(new Scene(gridPaneMenu, 500, 650));
        displayGameStats();
        checkEligible();
        primaryStage.show();
    }



}
