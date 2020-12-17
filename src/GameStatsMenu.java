import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GameStatsMenu extends Application {
    Text noOfGamesPlayed;
    Text TotalStars;
    Text HighScore;
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = FXMLLoader.load(getClass().getResource("GameStatsMenu.fxml"));

        noOfGamesPlayed = new Text();
   //     noOfGamesPlayed.setText(""+ MainMenu.getInstance().getNoOfGamesPlayed());
        noOfGamesPlayed.setX(216);
        noOfGamesPlayed.setStroke(Paint.valueOf("#e50000"));
        noOfGamesPlayed.setFill(Paint.valueOf("#e50000"));
        noOfGamesPlayed.setLayoutY(302);
        noOfGamesPlayed.setFont(Font.font ("Calibri Bold", 27));
        root.getChildren().add(noOfGamesPlayed);

        HighScore = new Text();
     //   HighScore.setText(""+ MainMenu.getInstance().getHighScore());
        HighScore.setX(252);
        HighScore.setStroke(Paint.valueOf("#e50000"));
        HighScore.setFill(Paint.valueOf("#e50000"));
        HighScore.setLayoutY(399);
        HighScore.setFont(Font.font ("Calibri Bold", 27));
        root.getChildren().add(HighScore);

        TotalStars = new Text();
       // TotalStars.setText(""+ MainMenu.getInstance().getTotalStars());
        TotalStars.setX(260);
        TotalStars.setStroke(Paint.valueOf("#e50000"));
        TotalStars.setFill(Paint.valueOf("#e50000"));
        TotalStars.setLayoutY(512);
        TotalStars.setFont(Font.font ("Calibri Bold", 27));
        root.getChildren().add(TotalStars);

        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
