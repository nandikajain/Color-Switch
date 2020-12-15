import javafx.application.Application;
import javafx.stage.Stage;

public class MainProg extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        PlayBall playBall = new PlayBall();
        playBall.start(primaryStage);
    }
}
