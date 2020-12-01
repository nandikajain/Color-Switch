package obstacles;
import javafx.scene.Group;
public class TwoEqualCircles {
    double centerX;
    double centerY;
    double r1;
    double r2;
    public TwoEqualCircles(double cX, double cY, double radius1, double radius2)
    {
        centerX=cX;
        centerY= cY;
        r1= radius1;
        r2= radius2;
    }
    public Group returnTwoEqualCircles(){
        Group group= new Group();
        CircleObstacle c1= new CircleObstacle(centerX, centerY, r1, false);
        CircleObstacle c2= new CircleObstacle(centerX, centerY, r2, true);
        Group g1= c1.returnCircleObstacle();
        Group g2= c2.returnCircleObstacle();
        group.getChildren().addAll(g1);
        group.getChildren().addAll(g2);
        return group;
    }
}
