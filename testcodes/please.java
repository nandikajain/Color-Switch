import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;

public class please extends Application {

    public Button button1;
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("CHAL JAAA");
        window.setResizable(false);

        Parent root1 = FXMLLoader.load(getClass().getResource("please1.fxml"));
        scene1 = new Scene(root1,600,300);
        //button1.setOnAction(e -> primaryStage.setScene(scene2));
        window.setScene(scene1);
        window.show();
    }


}
