import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    public ImageView playButton;
    public ImageView statsButton;
    public ImageView instructionsButton;
    public Button savedGamesButton;
    public Button muteButton;
    public Button exitButton;
    private static final String sg_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-color: #ff0181; -fx-border-width: 4;";
    private static final String sg_HOVERED_BUTTON_STYLE = "-fx-background-color: #ff0181; -fx-border-color: #ff0181; -fx-border-width: 4;";
    private static final String e_IDLE_BUTTON_STYLE = "-fx-background-color: #272727; -fx-border-width: 4; -fx-border-color: #900dff;";
    private static final String e_HOVERED_BUTTON_STYLE = "-fx-background-color: #900dff; -fx-border-width: 4; -fx-border-color: #900dff;";

    String buttonSoundFile = "sounds/button.wav";
    Media buttonSound;
    MediaPlayer buttonSoundPlayer;

    String playButtonSoundFile = "sounds/start.wav";
    Media playButtonSound;
    MediaPlayer playButtonSoundPlayer;

    @FXML
    public void onExitClicked(){
        System.exit(1);
    }

    @FXML
    public void onSavedGamesClicked(MouseEvent mouseEvent){}

    @FXML
    public void onPlayButtonClicked(MouseEvent mouseEvent) throws Exception {
        MainMenu.getInstance().backgroundSoundStop();
        playButtonSound = new Media(new File(playButtonSoundFile).toURI().toString());
        playButtonSoundPlayer = new MediaPlayer(playButtonSound);
        playButtonSoundPlayer.play();
        Stage stage = (Stage) playButton.getScene().getWindow();
        Game game = new Game();
        game.start(stage);
    }

    @FXML
    public void onSavedGamesClick(ActionEvent actionEvent) throws Exception {
        MainMenu.getInstance().backgroundSoundStop();
        Stage stage = (Stage) savedGamesButton.getScene().getWindow();
        SavedGamesMenu savedGamesMenu = new SavedGamesMenu();
        savedGamesMenu.start(stage);
    }
    @FXML
    public void onStatsButtonClicked(MouseEvent mouseEvent) throws Exception {
        MainMenu.getInstance().backgroundSoundStop();
        Stage stage = (Stage) statsButton.getScene().getWindow();
        GameStatsMenu statsMenu= new GameStatsMenu();
        statsMenu.start(stage);
    }
    @FXML
    public void onInstructionsButtonClicked(MouseEvent mouseEvent) throws Exception {
        MainMenu.getInstance().backgroundSoundStop();
        Stage stage = (Stage) instructionsButton.getScene().getWindow();
        GameInstructionsMenu insMenu= new GameInstructionsMenu();
        insMenu.start(stage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        savedGamesButton.setStyle(sg_IDLE_BUTTON_STYLE);
        savedGamesButton.setOnMouseEntered(e -> {
            savedGamesButton.setStyle(sg_HOVERED_BUTTON_STYLE);
            buttonSound = new Media(new File(buttonSoundFile).toURI().toString());
            buttonSoundPlayer = new MediaPlayer(buttonSound);
            buttonSoundPlayer.play();
        });
        savedGamesButton.setOnMouseExited(e -> savedGamesButton.setStyle(sg_IDLE_BUTTON_STYLE));
        exitButton.setStyle(e_IDLE_BUTTON_STYLE);
        exitButton.setOnMouseEntered(e -> {
            exitButton.setStyle(e_HOVERED_BUTTON_STYLE);
            buttonSound = new Media(new File(buttonSoundFile).toURI().toString());
            buttonSoundPlayer = new MediaPlayer(buttonSound);
            buttonSoundPlayer.play();
        });
        exitButton.setOnMouseExited(e -> exitButton.setStyle(e_IDLE_BUTTON_STYLE));
    }

    public void onMuteSoundClicked(MouseEvent mouseEvent) {
        boolean paused = MainMenu.getInstance().backgroundSoundPause();
        if(paused){
            muteButton.setText("UNMUTE");
            muteButton.setStyle("-fx-background-color: #ff0181; -fx-border-color: #ff0181; -fx-border-width: 4;");
            muteButton.setTextFill(Paint.valueOf("#272727"));
        }
        else{
            muteButton.setText("MUTE");
            muteButton.setStyle("-fx-background-color: #272727; -fx-border-color: #ff0181; -fx-border-width: 4;");
            muteButton.setTextFill(Paint.valueOf("#ff0181"));
        }
    }
}
