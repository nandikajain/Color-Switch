package obstacles;
//Have to resolve the problem of never having the same color ugh
import javafx.scene.Group;

public class TwoAdjacentCircles {
    //center is the pt of tangency of the 2 circles and 10 is the stroke width
    double centerX;
    double centerY;
    double radiusA;
    double radiusB;
    boolean rot1;
    boolean rot2;
    public TwoAdjacentCircles(double centerXa, double centerYa, double rA, double rB, boolean rotation1, boolean rotation2)
    {
        centerX = centerXa;
        centerY = centerYa;
        radiusA = rA;
        radiusB = rB;
        rot1 = rotation1;
        rot2 = rotation2;
    }
    public Group returnTwoAdjacentCircles()
    {
        Group group = new Group();
        CircleObstacle c1= new CircleObstacle(centerX - 10 - radiusA, centerY, radiusA, rot1);
        CircleObstacle c2= new CircleObstacle(centerX + 10 + radiusB, centerY, radiusB, rot2);
        Group g1= c1.returnCircleObstacle();
        Group g2= c2.returnCircleObstacle();
        group.getChildren().addAll(g1);
        group.getChildren().addAll(g2);
        return group;
    }
}
