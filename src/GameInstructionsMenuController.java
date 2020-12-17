import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GameInstructionsMenuController {

    public Circle MenuButton;

    @FXML
    public void onMenuButtonClick(MouseEvent mouseEvent) throws Exception {
        Stage stage = (Stage) MenuButton.getScene().getWindow();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(stage);
    }
}
