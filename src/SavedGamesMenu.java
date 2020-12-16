import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SavedGamesMenu extends Application {

    ArrayList<Game> savedGamesList;
    ArrayList<Label> gameLabelArrayList;
    ArrayList<Label> scoreLabelArrayList;

    AnchorPane anchorPane;

    SavedGamesMenu(){
        savedGamesList = new ArrayList<>(MainMenu.getInstance().savedGames);
        gameLabelArrayList = new ArrayList<>();
        scoreLabelArrayList = new ArrayList<>();
    }

    private void displaySavedGames(){
        for(int i=0;i<savedGamesList.size();i++){
            Label temp = new Label("GAME"+(i+1));
            temp.setTextFill(Paint.valueOf("#FFFFFF"));
            temp.setLayoutX(76);
            temp.setLayoutY(260+100*i);
            temp.setFont(Font.font("Blissful Thinking",30));
            anchorPane.getChildren().add(temp);
            gameLabelArrayList.add(temp);

            Label temp2 = new Label(String.valueOf(savedGamesList.get(i).getNoOfStars()));
            temp2.setTextFill(Paint.valueOf("#FFFFFF"));
            temp2.setLayoutX(400);
            temp2.setLayoutY(284+i*100);
            temp2.setFont(Font.font("Blissful Thinking",24));
            anchorPane.getChildren().add(temp2);
            scoreLabelArrayList.add(temp2);
        }
    }

    private void startSelectedGame(Game chosenGame){

    }

    private void exitScreen(){

    }

    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = FXMLLoader.load(getClass().getResource("SavedGamesMenu.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        anchorPane = root;
        displaySavedGames();
        primaryStage.show();
    }
}
