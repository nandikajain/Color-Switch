import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameEndMenu extends Application {

//    GameEndMenu(int noOfStars, Game curGame){
//
//    }

    private void displayGameStats(Game curGame){
    
    }

    private void gameContinue(Game curGame){

    }

    public boolean checkEligible(){
        return false;
    }

    public void restartGame(){//basically start new game

    }

    public void exitGame(){

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GameEndMenu.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 750));
        primaryStage.show();
    }

    @FXML
    public void playAgainClicked(MouseEvent mouseEvent) {
        System.out.println("Play Button Clicked");
    }

}
