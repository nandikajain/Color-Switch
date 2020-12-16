import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameEndMenuController implements Initializable {

    public Circle menuButton;
    public Button playAgainButton;
    public Button playCoinsButton;

    private static final String p_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #32dbf0; -fx-border-width: 4;";
    private static final String p_HOVERED_BUTTON_STYLE = "-fx-background-color: #32dbf0; -fx-border-color: #32dbf0; -fx-border-width: 4;";

    @FXML
    public void playAgainClicked(ActionEvent mouseEvent) throws Exception {
        System.out.println("Play Button Clicked");
        GameEndMenu.getInstance().restartGame();
    }

    @FXML
    public void menuButtonClicked(MouseEvent actionEvent) throws Exception {
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
