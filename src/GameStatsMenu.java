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
        noOfGamesPlayed.setText(""+ MainMenu.getInstance().getNoOfGamesPlayed());
        noOfGamesPlayed.setX(335);
        noOfGamesPlayed.setStroke(Color.WHITE);
        noOfGamesPlayed.setFill(Color.WHITE);
        noOfGamesPlayed.setLayoutY(286);
        noOfGamesPlayed.setFont(Font.font ("Blissful Thinking", 35));
        root.getChildren().add(noOfGamesPlayed);

        HighScore = new Text();
        HighScore.setText(""+ MainMenu.getInstance().getHighScore());
        HighScore.setX(335);
        HighScore.setStroke(Color.WHITE);
        HighScore.setFill(Color.WHITE);
        HighScore.setLayoutY(336);
        HighScore.setFont(Font.font ("Blissful Thinking", 35));
        root.getChildren().add(HighScore);

        TotalStars = new Text();
        TotalStars.setText(""+ MainMenu.getInstance().getTotalStars());
        TotalStars.setX(335);
        TotalStars.setStroke(Color.WHITE);
        TotalStars.setFill(Color.WHITE);
        TotalStars.setLayoutY(386);
        TotalStars.setFont(Font.font ("Blissful Thinking", 35));
        root.getChildren().add(TotalStars);

        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
