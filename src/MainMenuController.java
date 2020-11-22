import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class MainMenuController {

    public ImageView playButton;
    public Button savedGamesButton;

    @FXML
    public void onExitClicked(){
        System.exit(1);
    }

    @FXML
    public void onSavedGamesClicked(MouseEvent mouseEvent) {

    }

    @FXML
    public void onPlayClicked(MouseEvent mouseEvent) {

    }


    @FXML
    public void onPlayButtonClick(MouseEvent mouseEvent) throws Exception {

    }



    @FXML
    public void onSavedGamesClick(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) savedGamesButton.getScene().getWindow();
        SavedGamesMenu savedGamesMenu = new SavedGamesMenu();
        savedGamesMenu.start(stage);
    }
}
