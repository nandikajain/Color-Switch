package obstacles;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TwoAdjacentCircles extends Obstacle{
    //center is the pt of tangency of the 2 circles and 10 is the stroke width
    double centerX;
    double centerY;
    double radiusA;
    double radiusB;
    public TwoAdjacentCircles(double centerXa, double centerYa, double rA, double rB)
    {
        centerX = centerXa;
        centerY = centerYa;
        radiusA = rA;
        radiusB = rB;
    }
    @Override
    public Group generateObstacle()
    {
        Group group = new Group();
        CircleObstacle c1= new CircleObstacle(centerX, centerY, radiusA, false);
        Group g1= c1.generateObstacle();
        group.getChildren().addAll(g1);

        Group g2 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 0, 90, Color.PURPLE, 10);
        ArcComponent a2= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 90, 90, Color.CYAN, 10);
        ArcComponent a3= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 180, 90, Color.YELLOW, 10);
        ArcComponent a4= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 270, 90, Color.RED, 10);
        Arc arc1 = a1.returnArc();
        Arc arc2 = a2.returnArc();
        Arc arc3 = a3.returnArc();
        Arc arc4 = a4.returnArc();
        g2.getChildren().addAll(arc1);
        g2.getChildren().addAll(arc2);
        g2.getChildren().addAll(arc3);
        g2.getChildren().addAll(arc4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(g2);
        rotate.setAutoReverse(false);
        rotate.play();

        group.getChildren().addAll(g2);
        return group;
    }
    @Override
    public double getStarPositionY()
    {
        if(radiusB<radiusA)
            return centerY-radiusA;
        else
            return centerY-radiusB;
    }


}
