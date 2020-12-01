package obstacles;
import javafx.scene.Group;
public class ThreeEqualCircles {
    double centerX;
    double centerY;
    double r1;
    double r2;
    double r3;
    public ThreeEqualCircles(double cX, double cY, double radius1, double radius2, double radius3)
    {
        centerX=cX;
        centerY= cY;
        r1= radius1;
        r2= radius2;
        r3= radius3;
    }
    public Group returnThreeEqualCircles(){
        Group group= new Group();
        CircleObstacle c1= new CircleObstacle(centerX, centerY, r1, false);
        CircleObstacle c2= new CircleObstacle(centerX, centerY, r2, true);
        CircleObstacle c3= new CircleObstacle(centerX, centerY, r3, false);
        Group g1= c1.returnCircleObstacle();
        Group g2= c2.returnCircleObstacle();
        Group g3= c3.returnCircleObstacle();
        group.getChildren().addAll(g1);
        group.getChildren().addAll(g2);
        group.getChildren().addAll(g3);
        return group;
    }
}
