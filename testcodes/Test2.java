import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Test2 {

    Stage primaryStage;

    public Test2(){

    }

    public void showScreen(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test2.fxml"));
        Parent root = null;
        root = loader.load();
        Group superGroup = new Group();
        superGroup.getChildren().addAll(root);
        Scene scene = new Scene(superGroup,400,600);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
    }
}
