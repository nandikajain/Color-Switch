import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

public class PauseMenu extends Application {

    /*
    PauseMenu(Game curGame){

    }
     */

    private void endGame(){

    }

    private void restartGame(){

    }

    private void resumeGame(Game curGame){

    }

    private void saveGame(Game curGame){

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        primaryStage.setTitle("Color Switch");
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        primaryStage.setScene(new Scene(mainMenuPane,500, 650));
        primaryStage.show();
    }

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

}
