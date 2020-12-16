import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameEndMenuController implements Initializable {

    public static Button menuButton;
    public static Button playAgainButton;
    public static Button playCoinsButton;

    private static final String p_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #32dbf0; -fx-border-width: 4;";
    private static final String p_HOVERED_BUTTON_STYLE = "-fx-background-color: #32dbf0; -fx-border-color: #32dbf0; -fx-border-width: 4;";

    public static Label curGameScore;
    public static Label totalCoins;
    public static Label allTimeBestScore;

    public static void setLabels(int curScore, int total, int allTime){
        curGameScore.setText(String.valueOf(curScore));
        totalCoins.setText(String.valueOf(total));
        allTimeBestScore.setText(String.valueOf(allTime));
    }

    @FXML
    public void playAgainClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("Play Button Clicked");
        GameEndMenu.getInstance().restartGame();
    }

    @FXML
    public void menuButtonClicked(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(stage);
    }

    @FXML
    public void playCoinsClicked(ActionEvent actionEvent) throws Exception {
        GameEndMenu.getInstance().gameContinue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playAgainButton.setStyle(p_IDLE_BUTTON_STYLE);
        playAgainButton.setOnMouseEntered(e -> playAgainButton.setStyle(p_HOVERED_BUTTON_STYLE));
        playAgainButton.setOnMouseExited(e -> playAgainButton.setStyle(p_IDLE_BUTTON_STYLE));
    }
}
