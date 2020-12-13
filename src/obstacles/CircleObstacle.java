package obstacles;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CircleObstacle extends Obstacle {
    //returning the group
    double centerX;
    double centerY;
    double radius;
    boolean isRotate;

    //Change values here in order to get circle obstacles with different parameters
    public CircleObstacle(double X, double Y, double r, boolean rot )
    {
        centerX=X;
        centerY=Y;
        radius=r;
        isRotate=rot;
    }
    @Override
    public Group generateObstacle()
    {
        Group group = new Group();
        //Circle Obstacle Creation
        ArcComponent a1= new ArcComponent(centerX, centerY, radius, radius, 0, 90, Color.YELLOW, 10);
        ArcComponent a2= new ArcComponent(centerX, centerY, radius, radius, 90, 90, Color.RED, 10);
        ArcComponent a3= new ArcComponent(centerX, centerY, radius, radius, 180, 90, Color.PURPLE, 10);
        ArcComponent a4= new ArcComponent(centerX, centerY, radius, radius, 270, 90, Color.CYAN, 10);
        Arc arc1 = a1.returnArc();
        Arc arc2 = a2.returnArc();
        Arc arc3 = a3.returnArc();
        Arc arc4 = a4.returnArc();
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(3000));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(group);
        rotate.setAutoReverse(isRotate);
        rotate.play();

        return group;
    }
    @Override
    public double getStarPositionY()
    {
        return centerY;
    }
    public double getCenterY() {
        return centerY;
    }
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public boolean isRotate() {
        return isRotate;
    }
    public void setRotate(boolean rotate) {
        isRotate = rotate;
    }
    public double getCenterX() {
        return centerX;
    }
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }


}
