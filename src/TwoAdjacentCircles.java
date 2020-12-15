import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TwoAdjacentCircles extends Obstacle {
    //center is the pt of tangency of the 2 circles and 10 is the stroke width
    double centerX;
    double centerY;
    double radiusA;
    double radiusB;
    Arc arc1b, arc2b, arc3b, arc4b, arc1,arc2, arc3, arc4;
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
        Group g1 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1b= new ArcComponent(centerX, centerY, radiusA, radiusA, 0, 90, Color.YELLOW, 10);
        ArcComponent a2b= new ArcComponent(centerX, centerY, radiusA, radiusA, 90, 90, Color.RED, 10);
        ArcComponent a3b= new ArcComponent(centerX, centerY, radiusA, radiusA, 180, 90, Color.PURPLE, 10);
        ArcComponent a4b= new ArcComponent(centerX, centerY, radiusA, radiusA, 270, 90, Color.CYAN, 10);
        arc1b = a1b.returnArc();
        arc2b = a2b.returnArc();
        arc3b = a3b.returnArc();
        arc4b = a4b.returnArc();
        g1.getChildren().addAll(arc1b);
        g1.getChildren().addAll(arc2b);
        g1.getChildren().addAll(arc3b);
        g1.getChildren().addAll(arc4b);
        //rotation
        RotateTransition rot = new RotateTransition();
        rot.setAxis(Rotate.Z_AXIS);
        rot.setByAngle(360);
        rot.setCycleCount(50000);
        rot.setDuration(Duration.millis(3000));
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setNode(g1);
        rot.setAutoReverse(false);
        rot.play();
        group.getChildren().addAll(g1);

        Group g2 = new Group();
        //Circle Obstacle Creation
        ArcComponent a1= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 0, 90, Color.PURPLE, 10);
        ArcComponent a2= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 90, 90, Color.CYAN, 10);
        ArcComponent a3= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 180, 90, Color.YELLOW, 10);
        ArcComponent a4= new ArcComponent(centerX + radiusA+ radiusB+10, centerY, radiusB, radiusB, 270, 90, Color.RED, 10);
        arc1 = a1.returnArc();
        arc2 = a2.returnArc();
        arc3 = a3.returnArc();
        arc4 = a4.returnArc();
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
    public double getColorSwitcherPositionY(){
        if(radiusB<radiusA)
            return centerY - radiusA - 30;
        else
            return centerY - radiusB - 30;
    }
    @Override
    public void display()
    {
        arc1.setLayoutY(arc1.getLayoutY()+5);
        arc2.setLayoutY(arc2.getLayoutY()+5);
        arc3.setLayoutY(arc3.getLayoutY()+5);
        arc4.setLayoutY(arc4.getLayoutY()+ 5);
        arc1b.setLayoutY(arc1b.getLayoutY()+5);
        arc2b.setLayoutY(arc2b.getLayoutY()+5);
        arc3b.setLayoutY(arc3b.getLayoutY()+5);
        arc4b.setLayoutY(arc4b.getLayoutY()+ 5);
    }


}
