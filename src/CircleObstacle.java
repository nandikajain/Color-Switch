import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;


public class CircleObstacle extends Obstacle implements Serializable {
    //returning the group
    private final static long serialVersionUID = 3423424;
    double centerX;
    double centerY;
    double radius;
    double speed;
    boolean isRotate;
    transient ArrayList<Shape> shapes;
    transient Arc arc1,arc2,arc3,arc4;


    //Change values here in order to get circle obstacles with different parameters
    public CircleObstacle(double X, double Y, double r, boolean rot , double s)
    {
        speed =s;

        centerX=X;
        centerY=Y;
        radius=r;
        isRotate=rot;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    @Override
    public Group generateObstacle()
    {
        shapes= new ArrayList<Shape>();
        Group group = new Group();
        //Circle Obstacle Creation
        ArcComponent a1= new ArcComponent(centerX, centerY, radius, radius, 0, 90, Color.YELLOW, 10);
        ArcComponent a2= new ArcComponent(centerX, centerY, radius, radius, 90, 90, Color.RED, 10);
        ArcComponent a3= new ArcComponent(centerX, centerY, radius, radius, 180, 90, Color.PURPLE, 10);
        ArcComponent a4= new ArcComponent(centerX, centerY, radius, radius, 270, 90, Color.CYAN, 10);
        arc1 = a1.returnArc();
        arc2 = a2.returnArc();
        arc3 = a3.returnArc();
        arc4 = a4.returnArc();
        group.getChildren().addAll(arc1);
        group.getChildren().addAll(arc2);
        group.getChildren().addAll(arc3);
        group.getChildren().addAll(arc4);
        shapes.add(arc1);
        shapes.add(arc2);
        shapes.add(arc3);
        shapes.add(arc4);
        //rotation
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(50000);
        rotate.setDuration(Duration.millis(speed));
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
    @Override
    public double getColorSwitcherPositionY(){
        return centerY - radius - 75;
    }
    @Override
    public ArrayList<Shape> getShapesList(){
        return shapes;
    }

    @Override
    public void display()
    {
        arc1.setLayoutY(arc1.getLayoutY()+5);
        arc2.setLayoutY(arc2.getLayoutY()+5);
        arc3.setLayoutY(arc3.getLayoutY()+5);
        arc4.setLayoutY(arc4.getLayoutY()+ 5);
        centerY+=5;
    }
    @Override
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
