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
    Stage stage;

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

    private void startSelectedGame(){
        int x = savedGamesList.size();
        if(x==1) {
            gameLabelArrayList.get(0).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(0));
                savedGamesList.remove(0);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(1);
            });
        }
        else if(x==2) {
            gameLabelArrayList.get(0).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(0));
                savedGamesList.remove(0);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(1);
            });
            gameLabelArrayList.get(1).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(1));
                savedGamesList.remove(1);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(2);
            });
        }
        else if(x==3) {
            gameLabelArrayList.get(0).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(0));
                savedGamesList.remove(0);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(1);
            });
            gameLabelArrayList.get(1).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(1));
                savedGamesList.remove(1);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(2);
            });
            gameLabelArrayList.get(2).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(2));
                savedGamesList.remove(2);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(3);
            });
        }
        else if(x==4) {
            gameLabelArrayList.get(0).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(0));
                savedGamesList.remove(0);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(1);
            });
            gameLabelArrayList.get(1).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(1));
                savedGamesList.remove(1);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(2);
            });
            gameLabelArrayList.get(2).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(2));
                savedGamesList.remove(2);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(3);
            });
            gameLabelArrayList.get(3).setOnMouseClicked(e -> {
                Game game = new Game(savedGamesList.get(3));
                savedGamesList.remove(3);
                try {
                    game.start(stage);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.out.println(4);
            });
        }
    }

    private void exitScreen(){

    }

    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = FXMLLoader.load(getClass().getResource("SavedGamesMenu.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        anchorPane = root;
        displaySavedGames();
        primaryStage.show();
        startSelectedGame();
    }
}
