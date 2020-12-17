import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class PauseMenu extends Application {

    private static PauseMenu pauseMenu = null;
    Game curPausedGame;
    Stage stage;

    PauseMenu(Game curGame){
        curPausedGame = curGame;
        pauseMenu = this;
    }

    private void endGame(){

    }

    public void restartGame() throws Exception {
        Game game = new Game();
        game.start(stage);
    }

    public void resumeGame() throws Exception {
        curPausedGame.resumeGame(stage,false);
    }

    public void saveGame(){
        int gameListSize = MainMenu.getInstance().savedGames.size();
        if(gameListSize<4) {
            MainMenu.getInstance().savedGames.add(curPausedGame);
        }
        else{
            for(int i=1;i<=3;i++){
                MainMenu.getInstance().savedGames.set(i-1,MainMenu.getInstance().savedGames.get(i));
            }
            MainMenu.getInstance().savedGames.set(3,curPausedGame);
        }
        MainMenu.getInstance().saveState();
        System.out.println(MainMenu.getInstance().savedGames.size());
    }

    public static PauseMenu getInstance(){
        return pauseMenu;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        primaryStage.setTitle("Color Switch");
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        primaryStage.setScene(new Scene(mainMenuPane,500, 650));
        primaryStage.show();
    }



}
