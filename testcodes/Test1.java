import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Test1 extends Application {

    Stage stage;
    Test2 _page2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Test1.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        stage = primaryStage;
        primaryStage.show();
    }

    @FXML
    public void button1Click(MouseEvent mouseEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test2.fxml"));
        Parent root = loader.load();
        Group superGroup = new Group();
        superGroup.getChildren().addAll(root);
        Scene scene = new Scene(superGroup,400,600);
        stage.setScene(scene);
        stage.setResizable(false);
    }
}
