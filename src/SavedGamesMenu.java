import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SavedGamesMenu extends Application {

//    SavedGamesMenu(ArrayList<Game> savedGameList){
//
//    }

    private void displaySavedGames(){

    }

    private void startSelectedGame(Game chosenGame){

    }

    private void exitScreen(){

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        Parent root = FXMLLoader.load(getClass().getResource("SavedGamesMenu.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
