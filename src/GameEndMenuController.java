import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GameEndMenuController implements Initializable {

    public Button menuButton;
    public Button playAgainButton;
    public Button playCoinsButton;

    private static final String p_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #32dbf0; -fx-border-width: 4;";
    private static final String p_HOVERED_BUTTON_STYLE = "-fx-background-color: #32dbf0; -fx-border-color: #32dbf0; -fx-border-width: 4;";

    @FXML
    public void playAgainClicked(MouseEvent mouseEvent) {
        System.out.println("Play Button Clicked");
    }

    @FXML
    public void menuButtonClicked(ActionEvent actionEvent) {

    }

    @FXML
    public void playCoinsClicked(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playAgainButton.setStyle(p_IDLE_BUTTON_STYLE);
        playAgainButton.setOnMouseEntered(e -> playAgainButton.setStyle(p_HOVERED_BUTTON_STYLE));
        playAgainButton.setOnMouseExited(e -> playAgainButton.setStyle(p_IDLE_BUTTON_STYLE));
    }
}
