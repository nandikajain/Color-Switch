import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {

    @FXML
    Circle gamePauseButton;

    //This will need to implement the Game data logic, saath mei serialization will be gogo

    @FXML
    public void gamePauseButtonClicked(MouseEvent mouseEvent) throws Exception {
        Stage stage = (Stage) gamePauseButton.getScene().getWindow();
        Game game = new Game();
        game.start(stage);
    }
}
