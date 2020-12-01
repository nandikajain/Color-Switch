package obstacles;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TestObstacles extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.getIcons().add(new Image("file:./assets/logo.png"));
        AnchorPane root = new AnchorPane();
//        ###Circle Obstacle
//        CircleObstacle c1 = new CircleObstacle(250, 210, 60, false);
//        Group group = c1.returnCircleObstacle();

//          ###Star Obstacle
//        StarObstacle s1= new StarObstacle(250, 210, 60, true);
//        Group group = s1.returnStarObstacle();

//        ###Line Obstacle
//        LineObstacle l1= new LineObstacle(90);
//        Group group= l1.returnLineObstacle();

//       ### Square Obstacle
        SquareObstacle sq1= new SquareObstacle(250, 300, 150, true);
        Group group = sq1.returnSquareObstacle();


        root.getChildren().add(group);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 500, 650));
        primaryStage.show();

    }
}
