import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenuController implements Initializable {
    @FXML
    Button resumeGameButton;
    @FXML
    Button restartGameButton;
    @FXML
    Button saveGameButton;
    @FXML
    Circle menuButton;

    private static final String reg_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #ff0181; -fx-border-width: 4;";
    private static final String reg_HOVERED_BUTTON_STYLE = "-fx-background-color: #ff0181; -fx-border-color: #ff0181; -fx-border-width: 8;";
    private static final String sg_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #fae100; -fx-border-width: 4;";
    private static final String sg_HOVERED_BUTTON_STYLE = "-fx-background-color: #fae100; -fx-border-color: #fae100; -fx-border-width: 8;";
    private static final String rg_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #32dbf0; -fx-border-width: 4;";
    private static final String rg_HOVERED_BUTTON_STYLE = "-fx-background-color: #32dbf0; -fx-border-color: #32dbf0; -fx-border-width: 8;";


    @FXML
    void onMenuClicked(MouseEvent event) {

    }

    @FXML
    void onRestartClicked(MouseEvent event) {

    }

    @FXML
    void onResumeClicked(MouseEvent event) {

    }

    @FXML
    void onSaveGameClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saveGameButton.setStyle(sg_IDLE_BUTTON_STYLE);
        saveGameButton.setOnMouseEntered(e -> saveGameButton.setStyle(sg_HOVERED_BUTTON_STYLE));
        saveGameButton.setOnMouseExited(e -> saveGameButton.setStyle(sg_IDLE_BUTTON_STYLE));
        resumeGameButton.setStyle(rg_IDLE_BUTTON_STYLE);
        resumeGameButton.setOnMouseEntered(e -> resumeGameButton.setStyle(rg_HOVERED_BUTTON_STYLE));
        resumeGameButton.setOnMouseExited(e -> resumeGameButton.setStyle(rg_IDLE_BUTTON_STYLE));
        restartGameButton.setStyle(reg_IDLE_BUTTON_STYLE);
        restartGameButton.setOnMouseEntered(e -> restartGameButton.setStyle(reg_HOVERED_BUTTON_STYLE));
        restartGameButton.setOnMouseExited(e -> restartGameButton.setStyle(reg_IDLE_BUTTON_STYLE));
    }
}
