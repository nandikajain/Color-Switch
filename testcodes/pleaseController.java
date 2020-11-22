import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pleaseController {

    public Button button1;

    @FXML
    public void onButtonClick(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) button1.getScene().getWindow();
        //stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("please2.fxml"));
        //loader.setController(this);
        Parent root2 = (Parent) loader.load();
        Scene scene2 = new Scene(root2,400,600);
        stage.setTitle("CHAL GAYA");
        stage.setScene(scene2);
    }
}
